package com.eii.testassessment.mapper;

import com.eii.testassessment.model.DataFile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DataFileRowMapper implements RowMapper<DataFile> {
    @Override
    public DataFile mapRow(ResultSet rs, int rowNum) throws SQLException {
        DataFile dataFile = new DataFile();
        dataFile.setId(rs.getInt("id"));
        dataFile.setStatus(rs.getString("validation_status"));
        dataFile.setType(rs.getString("file_type"));
        dataFile.setCreatedOn(rs.getTimestamp("created_on"));
        dataFile.setCreatedOn(rs.getTimestamp("updated_on"));

        return dataFile;
    }
}
