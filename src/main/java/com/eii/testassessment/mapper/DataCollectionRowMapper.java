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

        DataFile orderFile = mapToDataFile(rs, "order_file_");
        DataFile assetFile = mapToDataFile(rs, "asset_file_");
        DataFile inventoryFile = mapToDataFile(rs, "inventory_file_");

        dataCollection.setDataFileList(Arrays.asList(orderFile, assetFile, inventoryFile));

        return dataCollection;
    }

    private DataFile mapToDataFile(ResultSet rs, String prefix) throws SQLException {
        DataFile dataFile = new DataFile();
        dataFile.setId(rs.getInt(prefix + "id"));
        dataFile.setCreatedOn(rs.getTimestamp(prefix + "created_on"));
        dataFile.setUpdatedOn(rs.getTimestamp(prefix + "updated_on"));
        dataFile.setType(rs.getString(prefix + "type"));
        dataFile.setStatus(rs.getString(prefix + "status"));
        return dataFile;
    }
}
