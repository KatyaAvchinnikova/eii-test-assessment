package com.eii.testassessment.mapper;

import com.eii.testassessment.dto.DataCollectionResponseDto;
import com.eii.testassessment.dto.DataFileDto;
import com.eii.testassessment.model.DataCollection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataCollectionMapper {
    private final DataFileMapper dataFileMapper;

    public DataCollectionResponseDto toDto(DataCollection model) {
        DataCollectionResponseDto dto = new DataCollectionResponseDto();
        List<DataFileDto> dataFileDtoList = model.getDataFileList()
                                                 .stream()
                                                 .map(dataFileMapper::toDto)
                                                 .collect(Collectors.toList());
        dto.setDataFileList(dataFileDtoList);
        dto.setCreatedOn(model.getCreatedOn());
        dto.setId(model.getId());
        dto.setNote(model.getNote());
        dto.setStatus(model.getStatus());
        dto.setUpdatedOn(model.getUpdatedOn());
        dto.setTag(model.getTag());
        return dto;
    }
}
