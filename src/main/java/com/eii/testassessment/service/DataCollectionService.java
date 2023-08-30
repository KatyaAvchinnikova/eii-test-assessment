package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionRequestDto;
import com.eii.testassessment.model.DataCollection;

import java.util.List;
import java.util.Map;

public interface DataCollectionService {
    int save(DataCollectionRequestDto dataCollectionRequestDto);

    List<DataCollection> findAll(Map<String, String> params);

    DataCollection findById(Integer id);

    void update(int id, DataCollectionRequestDto dataCollectionDto);

    void deleteById(int id);
}
