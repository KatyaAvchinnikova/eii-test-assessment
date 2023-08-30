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
public class DataCollectionDto {
    private int fileIdOrders;
    private int fileIdAssets;
    private int fileIdInventory;
    private String status;
    private String tag;
    private String note;
}
