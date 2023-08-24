package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.dto.DataCollectionDto;

import java.util.List;
import java.util.Map;

public interface DataCollectionService {
    int save(DataCollectionCreateDto dataCollectionCreateDto);

    List<DataCollectionDto> findAll(Map<String, String> params);

    DataCollectionDto findById(Integer id);

    void update(int id, DataCollectionCreateDto dataCollectionDto);

    void deleteById(int id);
}
