package com.eii.testassessment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataFileDto {
    private Integer id;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    private String fileType;
    private String validationStatus;
}
