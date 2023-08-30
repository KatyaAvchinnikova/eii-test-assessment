package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.dto.DataCollectionDto;
import com.eii.testassessment.repository.DataCollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DataCollectionServiceImpl implements DataCollectionService {
    private final DataCollectionRepository dataCollectionRepository;

    @Override
    @Transactional
    public int save(DataCollectionCreateDto dataCollectionCreateDto) {
        return dataCollectionRepository.save(dataCollectionCreateDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DataCollectionDto> findAll(Map<String, String> params) {
        return dataCollectionRepository.findAll(params);
    }

    @Override
    @Transactional(readOnly = true)
    public DataCollectionDto findById(Integer id) {
        return dataCollectionRepository.findById(id);
    }

    @Override
    @Transactional
    public void update(int id, DataCollectionCreateDto dataCollectionDto) {
        DataCollectionDto dto = buildDataCollectionDto(id, dataCollectionDto);
        dataCollectionRepository.update(dto);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        DataCollectionDto dto = dataCollectionRepository.findById(id);
        dto.setStatus("DELETED");
        dataCollectionRepository.update(dto);
    }

    private DataCollectionDto buildDataCollectionDto(int id, DataCollectionCreateDto dataCollectionDto) {
        DataCollectionDto dto = dataCollectionRepository.findById(id);
        dto.setFileIdAssets(dataCollectionDto.getFileIdAssets());
        dto.setFileIdInventory(dataCollectionDto.getFileIdInventory());
        dto.setFileIdOrders(dataCollectionDto.getFileIdOrders());
        dto.setNote(dataCollectionDto.getNote());
        dto.setTag(dataCollectionDto.getTag());
        dto.setStatus(dataCollectionDto.getStatus());
        dto.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
        return dto;
    }
}
