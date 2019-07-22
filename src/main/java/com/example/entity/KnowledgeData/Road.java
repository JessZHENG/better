package com.example.entity.KnowledgeData;

public class Road {
    private String road_name;
    private String road_uri;

    public String getRoad_name() {
        return road_name;
    }

    public void setRoad_name(String road_name) {
        this.road_name = road_name;
    }

    public String getRoad_uri() {
        return road_uri;
    }

    public void setRoad_uri(String road_uri) {
        this.road_uri = road_uri;
    }

    public String toString(){
        return (
                "road_name:"+road_name
                +"\nroad_uri:"+road_uri
                );
    }
}
