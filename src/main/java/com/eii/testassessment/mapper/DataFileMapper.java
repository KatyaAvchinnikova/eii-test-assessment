package com.eii.testassessment.mapper;

import com.eii.testassessment.dto.DataFileDto;
import com.eii.testassessment.model.DataFile;
import org.springframework.stereotype.Component;

@Component
public class DataFileMapper {
    public DataFileDto toDto(DataFile model) {
        DataFileDto dto = new DataFileDto();
        dto.setCreatedOn(model.getCreatedOn());
        dto.setId(model.getId());
        dto.setStatus(model.getStatus());
        dto.setType(model.getType());
        dto.setUpdatedOn(model.getUpdatedOn());
        return dto;
    }
}
