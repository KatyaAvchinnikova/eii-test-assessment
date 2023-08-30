package com.eii.testassessment.repository;

import com.eii.testassessment.dto.DataCollectionDto;
import com.eii.testassessment.dto.DataCollectionRequestDto;
import com.eii.testassessment.model.DataCollection;
import com.eii.testassessment.model.DataFile;

import java.util.List;
import java.util.Map;

public interface DataCollectionRepository {
    int save(DataCollectionRequestDto dataCollectionDto, List<DataFile> dataFiles);

    int update(DataCollection dataCollection);

    DataCollection findById(Integer id);

    List<DataCollection> findAll(Map<String, String> params);
}
