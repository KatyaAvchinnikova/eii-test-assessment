package com.eii.testassessment.controller;

import com.eii.testassessment.dto.DataCollectionCreateDto;
import com.eii.testassessment.model.DataCollection;
import com.eii.testassessment.service.DataCollectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data-collections")
@RequiredArgsConstructor
@Slf4j
public class DataCollectionController {
    private final DataCollectionService dataCollectionService;

    @PostMapping()
    public ResponseEntity<String> saveDataCollection(@RequestBody DataCollectionCreateDto dataCollectionCreateDto) {
        dataCollectionService.save(dataCollectionCreateDto);
        log.info("Data collection was created successfully");
        return new ResponseEntity<>("Data collection was created successfully.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DataCollection>> getDataCollections(@RequestParam(required = false) Map<String, String> params) {
        List<DataCollection> dataCollections = dataCollectionService.findAll(params);

        if (dataCollections.size() != 0) {
            log.info("Data collections found, sending response with status OK.");
            return new ResponseEntity<>(dataCollections, HttpStatus.OK);
        } else {
            log.warn("No data collections found, sending response with status NOT_FOUND.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataCollection> getDataCollectionById(@PathVariable Integer id) {
        DataCollection dataCollections = dataCollectionService.findById(id);
        return new ResponseEntity<>(dataCollections, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDataCollection(@PathVariable("id") int id, @RequestBody DataCollectionCreateDto dataCollectionDto) {
        // dataFileService.validateDataFiles(dataCollectionDto);
        dataCollectionService.update(id, dataCollectionDto);
        return new ResponseEntity<>("Data collection was updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDataCollectionById(@PathVariable("id") int id) {
        dataCollectionService.deleteById(id);
        return new ResponseEntity<>("Data collection was deleted successfully.", HttpStatus.OK);
    }
}
