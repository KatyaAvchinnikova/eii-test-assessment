package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.dto.DataFileDto;
import com.eii.testassessment.dto.DataFileValidationDto;
import com.eii.testassessment.exception.ValidationException;
import com.eii.testassessment.repository.DataFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataFileServiceImpl implements DataFileService {
    private final DataFileRepository dataFileRepository;

    @Override
    public void validateDataFiles(DataCollectionCreateDto dto) {
        checkDataFileTypeAndStatus(dto);
    }

    private void checkDataFileTypeAndStatus(DataCollectionCreateDto dto) {
        List<DataFileDto> dataFilesDtos = dto.getDataFiles();

        List<String> messages = new ArrayList<>();

        if (dataFilesDtos.size() < 3) {
            throw new ValidationException("Data collection should contain tata file for each type");
        }

        List<Long> ids = dataFilesDtos
                .stream()
                .map(DataFileDto::getId)
                .collect(Collectors.toList());

        List<DataFileValidationDto> dataFiles = dataFileRepository.findByIds(ids);

        List<String> types = Arrays.asList("orders", "assets", "inventory");

        for (DataFileValidationDto file : dataFiles) {
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
