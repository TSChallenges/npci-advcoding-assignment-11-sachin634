package com.agrichallenge.agdata.controller;

import com.agrichallenge.agdata.model.AgData;
import com.agrichallenge.agdata.service.AgDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/agdata")
public class AgDataController {

    @Autowired
    private AgDataService agDataService;

    @GetMapping("")
    public ResponseEntity<List<AgData>> getAllProducts() throws IOException {
        List<AgData> products = agDataService.loadAgData();
        if (products.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/crop-count")
    public ResponseEntity<Long> getAllCropName(@RequestParam("cropName") String name){
        Long data=agDataService.getCropCount(name);
        if(data==null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        }

        return new ResponseEntity<>(data, HttpStatus.OK);

    }



    // TODO: GET /api/agdata/average-yield?cropName=wheat

    @GetMapping("/average-yield")
    public ResponseEntity<Double> getAverageYielEntity(@RequestParam("cropName") String name){
        Double data=agDataService.getAverageYield(name);
        if(data==null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    // TODO: GET /api/agdata/by-region?region=Midwest

    @GetMapping("by-region")
    public ResponseEntity<List<AgData>> getRegionData(@RequestParam("region") String name){
        List<AgData> list=agDataService.getRecordsByRegion(name);
        if(list==null || list.isEmpty() || list.size()==0){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(list, HttpStatus.OK);

    }



}
