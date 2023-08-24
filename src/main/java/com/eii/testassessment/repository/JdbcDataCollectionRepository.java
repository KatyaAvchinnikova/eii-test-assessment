package com.eii.testassessment.repository;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.dto.DataCollectionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcDataCollectionRepository implements DataCollectionRepository{
    @Override
    public int save(DataCollectionCreateDto dataCollectionDto) {
        return 0;
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
        return null;
    }
}
