package com.eii.testassessment.mapper;

import com.eii.testassessment.model.DataCollection;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DataCollectionRowMapper implements RowMapper<DataCollection> {
    @Override
    public DataCollection mapRow(ResultSet rs, int rowNum) throws SQLException {
        DataCollection dataCollection = new DataCollection();
        dataCollection.setId(rs.getInt("id"));
        dataCollection.setCreatedOn(rs.getTimestamp("created_on"));
        dataCollection.setUpdatedOn(rs.getTimestamp("updated_on"));
        dataCollection.setDataFileList(null);
        dataCollection.setNote(rs.getString("note"));
        dataCollection.setTag(rs.getString("tag"));
        dataCollection.setStatus(rs.getString("status"));

        return dataCollection;
    }
}
