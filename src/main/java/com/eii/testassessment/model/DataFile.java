package com.eii.testassessment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataFile {
    private Integer id;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    private String type;
    private String status;
}
