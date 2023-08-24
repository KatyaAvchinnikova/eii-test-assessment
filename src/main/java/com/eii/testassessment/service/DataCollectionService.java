package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.dto.DataCollectionDto;

import java.util.List;

public interface DataCollectionService {
    int save(DataCollectionCreateDto dataCollectionCreateDto);

    List<DataCollectionDto> findAll();

    DataCollectionDto findById(Integer id);

    void update(int id, DataCollectionCreateDto dataCollectionDto);
}
