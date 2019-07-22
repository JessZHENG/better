package com.example.entity.KnowledgeData;

public class Relation {
    private String type;//person or organization or work
    private String name;
    private String uri;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String toString(){
        return (
                "type:"+type
                +"\nname:"+name
                +"\nuri:"+uri
                );
    }
}
