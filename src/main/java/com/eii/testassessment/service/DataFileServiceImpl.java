package com.eii.testassessment.service;

import com.eii.testassessment.exception.ValidationException;
import com.eii.testassessment.model.DataFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataFileServiceImpl implements DataFileService {
    @Override
    public void validateDataFiles(List<DataFile> dataFiles) {
        List<String> messages = new ArrayList<>();

        if (dataFiles.size() < 3) {
            throw new ValidationException("Data collection should contain data file for each type");
        }

        List<String> types = new ArrayList<>();
        types.add("orders");
        types.add("assets");
        types.add("inventory");

        for (DataFile file : dataFiles) {
            if (!"valid".equals(file.getStatus())) {
                messages.add(String.format("DataFile with id %s has invalid status", file.getId()));
            }
            if (types.contains(file.getType())) {
                types.remove(file.getType());
            } else {
                messages.add(String.format("DataFile with id %s has invalid type", file.getId()));
            }
        }

        if (messages.size() > 0) {
            throw new ValidationException(String.join(" ", messages));
        }
    }
}
