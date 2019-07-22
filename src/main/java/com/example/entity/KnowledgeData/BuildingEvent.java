package com.example.entity.KnowledgeData;

public class BuildingEvent {
    private String startedAtTime;
    private String endedAtTime;
    private String description;
    private String eventID;
    private int hasImg=0;
    private String imagePath;

    /*
    List images
     */

    public String getStartedAtTime() {
        return startedAtTime;
    }

    public void setStartedAtTime(String startedAtTime) {
        this.startedAtTime = startedAtTime;
    }

    public String getEndedAtTime() {
        return endedAtTime;
    }

    public void setEndedAtTime(String endedAtTime) {
        this.endedAtTime = endedAtTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public int getHasImg() {
        return hasImg;
    }

    public void setHasImg(int hasImg) {
        this.hasImg = hasImg;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String toString(){
        return (
                "startedAtTime:"+startedAtTime
                +"\ndescription:"+description
                +"\nhasImg:"+hasImg
                +"\nimagePath:"+imagePath
                );
    }
}
