package com.example.entity.KnowledgeData;

public class Location {
    String lon;
    String lat;

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
                "lon:"+lon
                +"\nlat:"+lat
                );
    }
}
