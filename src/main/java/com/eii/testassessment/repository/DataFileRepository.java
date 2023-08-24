package com.eii.testassessment.repository;

import com.eii.testassessment.dto.DataFileValidationDto;

public interface DataFileRepository {
    DataFileValidationDto validateByTypeAndStatus(long id, String type);
}
