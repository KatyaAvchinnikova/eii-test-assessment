package com.eii.testassessment.service;

import com.eii.testassessment.model.DataFile;

import java.util.List;

public interface DataFileService {
    void validateDataFiles(List<DataFile> dataFiles);
}
