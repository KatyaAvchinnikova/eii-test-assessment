package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionCreateDto;

public interface DataFileService {
    void validateDataFiles(DataCollectionCreateDto dto);
}
