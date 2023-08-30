package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.model.DataCollection;

import java.util.List;
import java.util.Map;

public interface DataCollectionService {
    int save(DataCollectionCreateDto dataCollectionCreateDto);

    List<DataCollection> findAll(Map<String, String> params);

    DataCollection findById(Integer id);

    void update(int id, DataCollectionCreateDto dataCollectionDto);

    void deleteById(int id);
}
