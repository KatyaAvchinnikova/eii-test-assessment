package com.eii.testassessment.repository;

import com.eii.testassessment.model.DataFile;

import java.util.List;

public interface DataFileRepository {
    List<DataFile> findByIds(List<Integer> ids);
}
