package com.eii.testassessment.mapper;

import com.eii.testassessment.model.DataCollection;
import com.eii.testassessment.model.DataFile;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataCollectionRowMapper implements RowMapper<DataCollection> {

    @Override
    public DataCollection mapRow(ResultSet rs, int rowNum) throws SQLException {
        DataCollection dataCollection = new DataCollection();

        dataCollection.setId(rs.getInt("id"));
        dataCollection.setCreatedOn(rs.getTimestamp("created_on"));
        dataCollection.setUpdatedOn(rs.getTimestamp("updated_on"));
        dataCollection.setStatus(rs.getString("status"));
        dataCollection.setTag(rs.getString("tag"));
        dataCollection.setNote(rs.getString("note"));

        DataFile orderFile = new DataFile();
        orderFile.setId(rs.getInt("order_file_id"));
        orderFile.setCreatedOn(rs.getTimestamp("order_created_on"));
        orderFile.setUpdatedOn(rs.getTimestamp("order_updated_on"));
        orderFile.setType(rs.getString("order_file_type"));
        orderFile.setStatus(rs.getString("order_file_status"));

        DataFile assetFile = new DataFile();
        assetFile.setId(rs.getInt("asset_file_id"));
        assetFile.setCreatedOn(rs.getTimestamp("asset_created_on"));
        assetFile.setUpdatedOn(rs.getTimestamp("asset_updated_on"));
        assetFile.setType(rs.getString("asset_file_type"));
        assetFile.setStatus(rs.getString("asset_file_status"));

        DataFile inventoryFile = new DataFile();
        inventoryFile.setId(rs.getInt("inventory_file_id"));
        inventoryFile.setCreatedOn(rs.getTimestamp("inventory_created_on"));
        inventoryFile.setUpdatedOn(rs.getTimestamp("inventory_updated_on"));
        inventoryFile.setType(rs.getString("inventory_file_type"));
        inventoryFile.setStatus(rs.getString("inventory_file_status"));

        dataCollection.setDataFileList(Arrays.asList(orderFile, assetFile, inventoryFile));

        return dataCollection;
    }
}
