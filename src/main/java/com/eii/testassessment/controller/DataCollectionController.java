package com.eii.testassessment.controller;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.dto.DataCollectionDto;
import com.eii.testassessment.service.DataCollectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data-collections")
@RequiredArgsConstructor
@Slf4j
public class DataCollectionController {
    private final DataCollectionService dataCollectionService;

    @PostMapping()
    public ResponseEntity<String> saveDataCollection(@RequestBody DataCollectionCreateDto dataCollectionCreateDto) {
        try {
            dataCollectionService.save(dataCollectionCreateDto);
            log.info("Data collection was created successfully");
            return new ResponseEntity<>("Data collection was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<DataCollectionDto>> getDataCollections() {
        List<DataCollectionDto> dataCollections = dataCollectionService.findAll();

        if (dataCollections.size() != 0) {
            return new ResponseEntity<>(dataCollections, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
