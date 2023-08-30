package com.eii.testassessment.service;

import com.eii.testassessment.dto.DataCollectionRequestDto;
import com.eii.testassessment.model.DataCollection;
import com.eii.testassessment.model.DataFile;
import com.eii.testassessment.repository.DataCollectionRepository;
import com.eii.testassessment.repository.DataFileRepository;
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
    private final DataFileService dataFileService;
    private final DataFileRepository dataFileRepository;

    @Override
    @Transactional
    public int save(DataCollectionRequestDto dataCollectionRequestDto) {
        List<DataFile> dataFiles = dataFileRepository.findByIds(dataCollectionRequestDto.getDataFileIds());
        dataFileService.validateDataFiles(dataFiles);
        return dataCollectionRepository.save(dataCollectionRequestDto, dataFiles);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DataCollection> findAll(Map<String, String> params) {
        return dataCollectionRepository.findAll(params);
    }

    @Override
    @Transactional(readOnly = true)
    public DataCollection findById(Integer id) {
        return dataCollectionRepository.findById(id);
    }

    @Override
    @Transactional
    public void update(int id, DataCollectionRequestDto dataCollectionDto) {
        List<DataFile> dataFiles = dataFileRepository.findByIds(dataCollectionDto.getDataFileIds());
        dataFileService.validateDataFiles(dataFiles);
        DataCollection dto = buildDataCollectionDto(id, dataCollectionDto, dataFiles);
        dataCollectionRepository.update(dto);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        DataCollection dto = dataCollectionRepository.findById(id);
        dto.setStatus("DELETED");
        dataCollectionRepository.update(dto);
    }

    private DataCollection buildDataCollectionDto(int id, DataCollectionRequestDto dataCollectionDto, List<DataFile> dataFiles) {
        DataCollection dto = dataCollectionRepository.findById(id);
        dto.setDataFileList(dataFiles);
        dto.setNote(dataCollectionDto.getNote());
        dto.setTag(dataCollectionDto.getTag());
        dto.setStatus(dataCollectionDto.getStatus());
        dto.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
        return dto;
    }
}
