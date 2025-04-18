package com.agrichallenge.agdata.model;

public class AgData {

    private Integer id;
    private String crop;
    private String region;
    private Integer yield;
    private Integer year;

    public AgData(){

    }

    public AgData(int id,String crop,String region,int yield,int year){
        this.id = id;
        this.crop = crop;
        this.region = region;
        this.yield=yield;
        this.year = year;
    }


    // TODO: Default constructor - No arguments
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setCrop(String crop){
        this.crop = crop;
    }

    public String getCrop(){
        return crop;
    }

    public String getRegion(){
        return region;
    }

    public void setRegion(String region){
        this.region = region;
    }

    public int getYield(){
        return yield;
    }

    public void setYield(int yield){
        this.yield = yield;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    // TODO: Parameterized constructor


    // TODO: Getters and Setters


}
