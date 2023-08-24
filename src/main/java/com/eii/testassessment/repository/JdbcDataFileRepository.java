package com.eii.testassessment.repository;

import com.eii.testassessment.dto.DataFileValidationDto;
import com.eii.testassessment.exception.ResourceNotFoundException;
import com.eii.testassessment.mapper.DataFileValidationRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcDataFileRepository implements DataFileRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final DataFileValidationRowMapper validationRowMapper;

    @Override
    public DataFileValidationDto validateByTypeAndStatus(long id, String type) {
        String sql = "SELECT id, " +
                "CASE " +
                "WHEN validation_status = 'valid' THEN TRUE " +
                "ELSE FALSE " +
                "END AS is_valid_status, " +
                "CASE " +
                "WHEN file_type = :type THEN TRUE " +
                "ELSE FALSE " +
                "END AS is_valid_type " +
                "FROM eii_test.data_files " +
                "WHERE id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource("id", id);
        parameters.addValue("type", type);
        try {
            return jdbcTemplate.queryForObject(sql, parameters, validationRowMapper);
        } catch (RuntimeException ex) {
            throw new ResourceNotFoundException("Data file", "id", id);
        }
    }
}
