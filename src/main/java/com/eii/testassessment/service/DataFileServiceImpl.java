package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.dto.DataFileValidationDto;
import com.eii.testassessment.exception.ValidationException;
import com.eii.testassessment.repository.DataFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DataFileServiceImpl implements DataFileService {
    private final DataFileRepository dataFileRepository;

    @Override
    public void validateDataFiles(DataCollectionCreateDto dto) {
        checkDataFileIds(dto);
        checkDataFileTypeAndStatus(dto);
    }

    private void checkDataFileTypeAndStatus(DataCollectionCreateDto dto) {
        List<String> exceptionMessages = new ArrayList<>();
        String message = "Data file with id %s for field %s has invalid status or type.";
        // orders
        DataFileValidationDto orderValidation = dataFileRepository.validateByTypeAndStatus(dto.getFileIdOrders(), "orders");
        if (!orderValidation.isValidStatus() || !orderValidation.isValidType()) {
            exceptionMessages.add(String.format(message, dto.getFileIdOrders(), "fileIdOrders"));
        }

        //assets
        DataFileValidationDto assetValidation = dataFileRepository.validateByTypeAndStatus(dto.getFileIdAssets(), "assets");
        if (!assetValidation.isValidStatus() || !assetValidation.isValidType()) {
            exceptionMessages.add(String.format(message, dto.getFileIdOrders(), "fileIdAssets"));
        }

        //inventory
        DataFileValidationDto inventoryValidation = dataFileRepository.validateByTypeAndStatus(dto.getFileIdInventory(), "inventory");
        if (!inventoryValidation.isValidStatus() || !inventoryValidation.isValidType()) {
            exceptionMessages.add(String.format(message, dto.getFileIdOrders(), "fileIdInventory"));
        }

        if (exceptionMessages.size() > 0) {
            throw new ValidationException(String.join(" ", exceptionMessages));
        }
    }

    private void checkDataFileIds(DataCollectionCreateDto dto) {
        if (dto.getFileIdAssets() == null
                || dto.getFileIdOrders() == null
                || dto.getFileIdInventory() == null) {
            throw new ValidationException("Data file shouldn't be empty");
        }

        if (Objects.equals(dto.getFileIdAssets(), dto.getFileIdInventory())
                || Objects.equals(dto.getFileIdInventory(), dto.getFileIdOrders())
                || Objects.equals(dto.getFileIdAssets(), dto.getFileIdOrders())) {

            throw new ValidationException("Data Collection must contain exactly one Data File from each type.");
        }
    }
}
