package com.eii.testassessment.repository;

import com.eii.testassessment.dto.DataFileValidationDto;

import java.util.List;

public interface DataFileRepository {
    List<DataFileValidationDto> findByIds(List<Long> ids);
}
