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
public class DataCollectionDto {
    private Integer id;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    private Integer fileIdOrders;
    private Integer fileIdAssets;
    private Integer fileIdInventory;
    private String status;
    private String tag;
    private String note;
}
