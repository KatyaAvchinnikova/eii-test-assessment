package com.eii.testassessment.repository;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.dto.DataCollectionDto;

import java.util.List;

public interface DataCollectionRepository {
    int save(DataCollectionCreateDto dataCollectionDto);

    int update(DataCollectionDto dataCollectionDto);

    DataCollectionDto findById(Integer id);

    int deleteById(Integer id);

    List<DataCollectionDto> findAll();
}
