package com.example.entity.KnowledgeData;

public class Images {
    private String description;
    private String path;
    private String uri;
    private String source;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String toString(){
        return (
                "uri:"+uri
                +"\npath:"+path
                +"\ndescription:"+description
                );
    }
}
