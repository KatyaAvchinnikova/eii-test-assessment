package com.eii.testassessment.repository;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.dto.DataCollectionDto;
import com.eii.testassessment.mapper.DataCollectionRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcDataCollectionRepository implements DataCollectionRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final DataCollectionRowMapper dataCollectionRowMapper;

    @Override
    public int save(DataCollectionCreateDto dataCollectionDto) {
        String sql = "INSERT INTO eii_test.data_collections (file_id_orders, file_id_assets, file_id_inventory, status, tag, note) " +
                "VALUES (:file_id_orders, :file_id_asserts, :file_id_inventory, :status, :tag, :note)";

        MapSqlParameterSource parameters = new MapSqlParameterSource("file_id_orders", dataCollectionDto.getFileIdOrders());
        parameters.addValue("file_id_asserts", dataCollectionDto.getFileIdAssets());
        parameters.addValue("file_id_inventory", dataCollectionDto.getFileIdInventory());
        parameters.addValue("status", dataCollectionDto.getStatus());
        parameters.addValue("tag", dataCollectionDto.getTag());
        parameters.addValue("note", dataCollectionDto.getTag());

        return jdbcTemplate.update(sql, parameters);
    }

    @Override
    public int update(DataCollectionDto dataCollectionDto) {
        return 0;
    }

    @Override
    public DataCollectionDto findById(Integer id) {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public List<DataCollectionDto> findAll() {
        String sql = "SELECT id, " +
                "created_on, " +
                "updated_on, " +
                "file_id_orders, " +
                "file_id_assets, " +
                "file_id_inventory, " +
                "status, " +
                "tag, " +
                "note " +
                "FROM eii_test.data_collections";

        return new ArrayList<>(jdbcTemplate.query(sql, new MapSqlParameterSource(), dataCollectionRowMapper));
    }
}
