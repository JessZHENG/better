package com.example.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@Entity
public class BuildingBasic {
    private int id;
    private String bType="无";
    private String name="无";
    private String address="无";
    private String uri="无";
    private String lon="无";
    private String lat="无";

    public BuildingBasic(){}
    public BuildingBasic(String bType, String name, String address, String uri, String lon, String lat){
        this.bType=bType;
        this.address=address;
        this.name=name;
        this.uri=uri;
        this.lon=lon;
        this.lat=lat;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String toString(){
        return (
                "bType:"+bType
                +"\naddress:"+address
                +"\nname:"+name
                +"\nuri:"+uri
                +"\nlon:"+lon
                +"\nlat:"+lat
                );
    }
}
