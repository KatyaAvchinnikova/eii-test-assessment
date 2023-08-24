package com.eii.testassessment.mapper;

import com.eii.testassessment.dto.DataCollectionDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DataCollectionRowMapper implements RowMapper<DataCollectionDto> {
    @Override
    public DataCollectionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        DataCollectionDto dataCollectionDto = new DataCollectionDto();
        dataCollectionDto.setId(rs.getInt("id"));
        dataCollectionDto.setCreatedOn(rs.getTimestamp("created_on"));
        dataCollectionDto.setUpdatedOn(rs.getTimestamp("updated_on"));
        dataCollectionDto.setFileIdAssets(rs.getInt("file_id_assets"));
        dataCollectionDto.setFileIdInventory(rs.getInt("file_id_inventory"));
        dataCollectionDto.setFileIdOrders(rs.getInt("file_id_inventory"));
        dataCollectionDto.setNote(rs.getString("note"));
        dataCollectionDto.setTag(rs.getString("tag"));
        dataCollectionDto.setStatus(rs.getString("status"));

        return dataCollectionDto;
    }
}
