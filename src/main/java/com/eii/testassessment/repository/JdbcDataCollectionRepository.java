package com.eii.testassessment.repository;

import com.eii.testassessment.dto.DataCollectionDto;
import com.eii.testassessment.dto.DataCollectionRequestDto;
import com.eii.testassessment.exception.ResourceNotFoundException;
import com.eii.testassessment.mapper.DataCollectionRowMapper;
import com.eii.testassessment.model.DataCollection;
import com.eii.testassessment.model.DataFile;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcDataCollectionRepository implements DataCollectionRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final DataCollectionRowMapper dataCollectionRowMapper;

    @Override
    public int save(DataCollectionRequestDto dataCollectionDto, List<DataFile> dataFiles) {
        String sql = "INSERT INTO eii_test.data_collections (file_id_orders, file_id_assets, file_id_inventory, status, tag, note) " +
                "VALUES (:file_id_orders, :file_id_assets, :file_id_inventory, :status, :tag, :note)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        putFileIdParameters(dataFiles, parameters);
        parameters.addValue("status", dataCollectionDto.getStatus());
        parameters.addValue("tag", dataCollectionDto.getTag());
        parameters.addValue("note", dataCollectionDto.getTag());

        return jdbcTemplate.update(sql, parameters);
    }

    @Override
    public int update(DataCollection dataCollection) {
        String sql = "UPDATE eii_test.data_collections SET file_id_orders = :file_id_orders, " +
                "file_id_assets = :file_id_assets, " +
                "file_id_inventory = :file_id_inventory, " +
                "status = :status, " +
                "tag = :tag, " +
                "note = :note, " +
                "updated_on = :updated_on " +
                "WHERE id = :id";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        putFileIdParameters(dataCollection.getDataFileList(), parameters);
        parameters.addValue("status", dataCollection.getStatus());
        parameters.addValue("tag", dataCollection.getTag());
        parameters.addValue("note", dataCollection.getNote());
        parameters.addValue("id", dataCollection.getId());
        parameters.addValue("updated_on", dataCollection.getUpdatedOn());

        return jdbcTemplate.update(sql, parameters);
    }

    @Override
    public DataCollection findById(Integer id) {
        String sql = "SELECT id, " +
                "created_on, " +
                "updated_on, " +
                "file_id_orders, " +
                "file_id_assets, " +
                "file_id_inventory, " +
                "status, " +
                "tag, " +
                "note " +
                "FROM eii_test.data_collections " +
                "WHERE id = :id AND status != 'DELETED'";

        MapSqlParameterSource parameters = new MapSqlParameterSource("id", id);

        try {
            return jdbcTemplate.queryForObject(sql, parameters, dataCollectionRowMapper);
        } catch (RuntimeException ex) {
            throw new ResourceNotFoundException("Data collection", "id", id);
        }
    }

    @Override
    public List<DataCollection> findAll(Map<String, String> params) {
        String sql = "SELECT id, " +
                "created_on, " +
                "updated_on, " +
                "file_id_orders, " +
                "file_id_assets, " +
                "file_id_inventory, " +
                "status, " +
                "tag, " +
                "note " +
                "FROM eii_test.data_collections " +
                "WHERE status != 'DELETED'";

        if (params.containsKey("filter")) {
            String[] filterParts = params.get("filter").split(",");
            if ("subset".equals(filterParts[1].split(":")[1])) {
                sql += " AND " + filterParts[0].split(":")[1] + " LIKE '%" + filterParts[2].split(":")[1] + "%' ";
            }
        }

        if (params.containsKey("sort")) {
            String[] sortParts = params.get("sort").split(",");
            sql += "ORDER BY " + sortParts[0].split(":")[1] + " " + sortParts[1].split(":")[1];
        }

        return jdbcTemplate.query(sql, dataCollectionRowMapper);
    }

    private void putFileIdParameters(List<DataFile> dataFiles, MapSqlParameterSource parameters) {
        for (DataFile dataFile : dataFiles) {
            switch (dataFile.getType()) {
                case "orders" -> parameters.addValue("file_id_orders", dataFile.getId());
                case "assets" -> parameters.addValue("file_id_assets", dataFile.getId());
                case "inventory" -> parameters.addValue("file_id_inventory", dataFile.getId());
            }
        }
    }
}
