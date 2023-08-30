package com.eii.testassessment.repository;

import com.eii.testassessment.mapper.DataFileRowMapper;
import com.eii.testassessment.model.DataFile;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcDataFileRepository implements DataFileRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final DataFileRowMapper dataFileRowMapper;

    @Override
    public List<DataFile> findByIds(List<Integer> ids) {
        String sql = "SELECT id, validation_status, file_type, created_on, updated_on " +
                "FROM eii_test.data_files " +
                "WHERE id in (:ids)";
        MapSqlParameterSource parameters = new MapSqlParameterSource("ids", ids);
        return jdbcTemplate.query(sql, parameters, dataFileRowMapper);
    }
}
