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
public class DataCollectionRequestDto {
    List<Integer> dataFileIds;
    private String status;
    private String tag;
    private String note;
}
