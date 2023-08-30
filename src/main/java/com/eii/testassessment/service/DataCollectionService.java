package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionRequestDto;
import com.eii.testassessment.dto.DataCollectionResponseDto;

import java.util.List;
import java.util.Map;

public interface DataCollectionService {
    int save(DataCollectionRequestDto dataCollectionRequestDto);

    List<DataCollectionResponseDto> findAll(Map<String, String> params);

    DataCollectionResponseDto findById(Integer id);

    void update(int id, DataCollectionRequestDto dataCollectionDto);

    void deleteById(int id);
}
