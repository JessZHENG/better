package com.example.entity.KnowledgeData;

import java.util.List;

public class HisBuilding extends Building{

    private String architectureStructure;
    private String architecturalStyle;
    private String created;
    private List<Designer> buildingDesignerList;
    private String building_type="his";

    public String getArchitectureStructure() {
        return architectureStructure;
    }

    public void setArchitectureStructure(String architectureStructure) {
        this.architectureStructure = architectureStructure;
    }

    public String getArchitecturalStyle() {
        return architecturalStyle;
    }

    public void setArchitecturalStyle(String architecturalStyle) {
        this.architecturalStyle = architecturalStyle;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public List<Designer> getBuildingDesignerList() {
        return buildingDesignerList;
    }

    public void setBuildingDesignerList(List<Designer> buildingDesignerList) {
        this.buildingDesignerList = buildingDesignerList;
    }

    @Override
    public String getBuilding_type() {
        return building_type;
    }

    @Override
    public void setBuilding_type(String building_type) {
        this.building_type = building_type;
    }

    private String designerToString(){
        int i;
        StringBuilder designerstr= new StringBuilder();
        Designer designer=new Designer();
        if(buildingDesignerList!=null)
        for(i=0;i<buildingDesignerList.size();i++){
            designer=buildingDesignerList.get(i);
            designerstr.append("\n").append(designer.toString());
        }
        return designerstr.toString();

    }

    @Override
    public String toString(){
        String str=super.toString();
        return(
                str
                +"\nbuilding_type"+building_type
                +"\narchitectureStructure:"+architectureStructure
                +"\narchitecturalStyle:"+architecturalStyle
                +"\ncreated:"+created
                +"\ndesigner:"+designerToString()
                );
    }

}
