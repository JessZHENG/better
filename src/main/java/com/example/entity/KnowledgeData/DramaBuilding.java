package com.example.entity.KnowledgeData;

public class DramaBuilding extends Building{
    //nameS-name
    private String bUri;
    private String movieName;
    private String building_type="drama";


    public String getbUri() {
        return bUri;
    }

    public void setbUri(String bUri) {
        this.bUri = bUri;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String getBuilding_type() {
        return building_type;
    }

    @Override
    public void setBuilding_type(String building_type) {
        this.building_type = building_type;
    }

    @Override
    public String toString(){
        String str=super.toString();
        return (
                str
        +"\nbuilding_type:"+building_type
        +"\nbUri:"+bUri);
    }
}
