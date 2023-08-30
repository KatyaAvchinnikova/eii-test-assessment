package com.eii.testassessment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataCollectionCreateDto {
    List<DataFileDto> dataFiles;
    private String status;
    private String tag;
    private String note;
}
