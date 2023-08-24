package com.eii.testassessment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataCollectionCreateDto {
    private Integer fileIdOrders;
    private Integer fileIdAssets;
    private Integer fileIdInventory;
    private String status;
    private String tag;
    private String note;
}
