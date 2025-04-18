package com.agrichallenge.agdata.service;

import com.agrichallenge.agdata.model.AgData;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Service class for analyzing agricultural data
// TODO: Implement this service class according to the requirements.

@Service
public class AgDataService {

    private final List<AgData> agDataList;

    public AgDataService() throws IOException {
        this.agDataList = loadAgData();
    }

    public List<AgData> loadAgData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Load the data from JSON file from resources
        InputStream inputStream = getClass().getResourceAsStream("/data/agdata.json");
        // Map the JSON to a List of AgData objects
        return objectMapper.readValue(inputStream, new TypeReference<List<AgData>>() {});
    }

    public Long getCropCount(String cropName) {
        // TODO: Implement this method to Count how many times a specific crop appears in the dataset
        Long count =0L;
        for(AgData agData : agDataList){
            if(agData.getCrop().equalsIgnoreCase(cropName))
                count++;
        }
        return count;
    }

    public double getAverageYield(String cropName) {
        // TODO: Implement this method to Calculate the average yield for a specific crop if it exists, else return 0.0
        int count =0;
        double totalYield = 0.0;
        for(AgData agData:agDataList){
            if(agData.getCrop().equalsIgnoreCase(cropName)){
                count++;
                totalYield+=agData.getYield();
            }
        }
        return totalYield/count;
    }

    public List<AgData> getRecordsByRegion(String region) {
        // TODO: Implement this method to Get all records from a specific region
        List<AgData> data=new ArrayList();
        for(AgData agData:agDataList){
            if(agData.getRegion().equalsIgnoreCase(region)){
                data.add(agData);
            }
        }
        return data;
    }

}

