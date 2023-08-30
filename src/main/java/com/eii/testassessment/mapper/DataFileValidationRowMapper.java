package com.eii.testassessment.mapper;

import com.eii.testassessment.dto.DataFileValidationDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DataFileValidationRowMapper implements RowMapper<DataFileValidationDto> {
    @Override
    public DataFileValidationDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        DataFileValidationDto dataFileValidationDto = new DataFileValidationDto();
        dataFileValidationDto.setId(rs.getLong("id"));
        dataFileValidationDto.setStatus(rs.getString("validation_status"));
        dataFileValidationDto.setType(rs.getString("file_type"));

        return dataFileValidationDto;
    }
}
