package com.eii.testassessment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataCollectionResponseDto {
    private Integer id;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    List<DataFileDto> dataFileList;
    private String status;
    private String tag;
    private String note;
}
