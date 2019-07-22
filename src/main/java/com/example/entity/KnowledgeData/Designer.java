package com.example.entity.KnowledgeData;

public class Designer {
    private String designer_name;
    private String designer_uri;
    private String designer_type;//person=人；organization=组织机构

    public String getDesigner_name() {
        return designer_name;
    }

    public void setDesigner_name(String designer_name) {
        this.designer_name = designer_name;
    }

    public String getDesigner_uri() {
        return designer_uri;
    }

    public void setDesigner_uri(String designer_uri) {
        this.designer_uri = designer_uri;
    }

    public String getDesigner_type() {
        return designer_type;
    }

    public void setDesigner_type(String designer_type) {
        this.designer_type = designer_type;
    }

    public String toString(){
        return (
                "designer_name:"+designer_name
                +"\ndesigner_type:"+designer_type
                +"\ndesigner_uri:"+designer_uri
                );
    }
}
