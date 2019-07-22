package com.example.entity.KnowledgeData;

import java.util.List;

public class Building {

    private String building_type;//建筑类型：his,drama,red
    private String yname;//别名
    private String address;//地址
    private String name;//名字
    private String uri;//URI
    private String housenumber;//
    private String des;//简介
    private int hasEvent=0;
    private int hasFile=0;
    private int hasLocation=0;
    private int hasRoad=0;
    private int hasRelation=0;

    private List<BuildingEvent> buildingEventList;
    private List<Images> buildingImageList;
    private List<Location> buildingLocation;
    private List<Road> buildingRoadList;

    private Relations buildingRelation;


    /*
    List:event relation images
     */

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getHasEvent() {
        return hasEvent;
    }

    public void setHasEvent(int hasEvent) {
        this.hasEvent = hasEvent;
    }

    public int getHasFile() {
        return hasFile;
    }

    public void setHasFile(int hasFile) {
        this.hasFile = hasFile;
    }

    public int getHasRelation() {
        return hasRelation;
    }

    public int getHasLocation() {
        return hasLocation;
    }

    public void setHasLocation(int hasLocation) {
        this.hasLocation = hasLocation;
    }

    public int getHasRoad() {
        return hasRoad;
    }

    public void setHasRoad(int hasRoad) {
        this.hasRoad = hasRoad;
    }

    public void setHasRelation(int hasRelation) {
        this.hasRelation = hasRelation;
    }

    public List<BuildingEvent> getBuildingEventList() {
        return buildingEventList;
    }

    public void setBuildingEventList(List<BuildingEvent> buildingEventList) {
        this.buildingEventList = buildingEventList;
    }

    public List<Images> getBuildingImageList() {
        return buildingImageList;
    }

    public void setBuildingImageList(List<Images> buildingImageList) {
        this.buildingImageList = buildingImageList;
    }

    public List<Location> getBuildingLocation() {
        return buildingLocation;
    }

    public void setBuildingLocation(List<Location> buildingLocation) {
        this.buildingLocation = buildingLocation;
    }

    public List<Road> getBuildingRoadList() {
        return buildingRoadList;
    }

    public void setBuildingRoadList(List<Road> buildingRoad) {
        this.buildingRoadList = buildingRoad;
    }

    public String getBuilding_type() {
        return building_type;
    }

    public void setBuilding_type(String building_type) {
        this.building_type = building_type;
    }

    public Relations getBuildingRelation() {
        return buildingRelation;
    }

    public void setBuildingRelation(Relations buildingRelation) {
        this.buildingRelation = buildingRelation;
    }

    private String locationToString(){
        int i;
        StringBuilder locationstr= new StringBuilder();
        Location location=new Location();
        if(buildingLocation!=null)
        for(i=0;i<buildingLocation.size();i++){
            location=buildingLocation.get(i);
            locationstr.append("\n").append(location.toString());
        }
        return locationstr.toString();

    }

    private String eventListToString(){
        int i;
        StringBuilder eventstr= new StringBuilder();
        BuildingEvent buildingEvent=new BuildingEvent();
        if(buildingEventList!=null)
        for(i=0;i<buildingEventList.size();i++){
            buildingEvent=buildingEventList.get(i);
            eventstr.append("\n").append(buildingEvent.toString());
        }
        return eventstr.toString();

    }

    private String imageListToString(){
        int i;
        StringBuilder imagestr= new StringBuilder();
        Images buildingImage=new Images();
        if(buildingImageList!=null)
            for(i=0;i<buildingImageList.size();i++){
                buildingImage=buildingImageList.get(i);
                imagestr.append("\n").append(buildingImage.toString());
            }
        return imagestr.toString();

    }

    private String roadListToString(){
        int i;
        StringBuilder roadStr= new StringBuilder();
        Road buildingRoad=new Road();
        if(buildingRoadList!=null)
            for(i=0;i<buildingRoadList.size();i++){
                buildingRoad=buildingRoadList.get(i);
                roadStr.append("\n").append(buildingRoad.toString());
            }
        return roadStr.toString();

    }


    public String toString(){
        String rStr="";
     if (hasRelation!=0)
         rStr=buildingRelation.toString();
        return (
               "\naddress:"+address
                +"\nyname:"+yname
                +"\nname:"+name
                +"\nuri:"+uri
                +"\nhoudenumber:"+housenumber
                +"\ndes:"+des
                +"\nhasLocation:"+hasLocation
                +"\nlocation:"+locationToString()
                +"\nhasEvent:"+hasEvent
                +"\nevent:"+eventListToString()
                +"\nhasFile:"+hasFile
                +"\nimage:"+imageListToString()
                +"\nhasRoad:"+hasRoad
                +"\nbuildingRoad:"+roadListToString()
                +"\nhasRelation:"+hasRelation
                +"\nbuildingRelation:\n"+rStr
        );
    }
}
