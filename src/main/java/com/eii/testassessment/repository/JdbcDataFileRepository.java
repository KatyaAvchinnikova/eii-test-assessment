package com.eii.testassessment.repository;

import com.eii.testassessment.dto.DataFileValidationDto;
import com.eii.testassessment.mapper.DataFileValidationRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcDataFileRepository implements DataFileRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final DataFileValidationRowMapper validationRowMapper;

    @Override
    public List<DataFileValidationDto> findByIds(List<Long> ids) {
        String sql = "SELECT id, validation_status, file_type " +
                "FROM eii_test.data_files " +
                "WHERE id in :ids;";
        MapSqlParameterSource parameters = new MapSqlParameterSource("ids", ids);

        return jdbcTemplate.query(sql, parameters, validationRowMapper);
    }
}
