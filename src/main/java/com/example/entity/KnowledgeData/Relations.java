package com.example.entity.KnowledgeData;

import java.util.List;

public class Relations {
    private int hasPerson=0;
    private int hasWork=0;

    private List<Relation> relationPersonList;
    private List<Relation> relationWorkList;

    public int getHasPerson() {
        return hasPerson;
    }

    public void setHasPerson(int hasPerson) {
        this.hasPerson = hasPerson;
    }

    public int getHasWork() {
        return hasWork;
    }

    public void setHasWork(int hasWork) {
        this.hasWork = hasWork;
    }

    public List<Relation> getRelationPersonList() {
        return relationPersonList;
    }

    public void setRelationPersonList(List<Relation> relationPersonList) {
        this.relationPersonList = relationPersonList;
    }

    public List<Relation> getRelationWorkList() {
        return relationWorkList;
    }

    public void setRelationWorkList(List<Relation> relationWorkList) {
        this.relationWorkList = relationWorkList;
    }

    private String personListToString(){
        int i;
        StringBuilder personStr= new StringBuilder();
        Relation relationPerson=new Relation();
        if(relationPersonList!=null)
            for(i=0;i<relationPersonList.size();i++){
                relationPerson=relationPersonList.get(i);
                personStr.append("\n").append(relationPerson.toString());
            }
        return personStr.toString();

    }

    private String workListToString(){
        int i;
        StringBuilder workStr= new StringBuilder();
        Relation relationWork=new Relation();
        if(relationWorkList!=null)
            for(i=0;i<relationWorkList.size();i++){
                relationWork=relationWorkList.get(i);
                workStr.append("\n").append(relationWork.toString());
            }
        return workStr.toString();

    }



    public String toString(){

        return (
                "hasPerson:"+hasPerson
                +"\nhasWork:"+hasWork
                +"\nrelationPersonList:"+personListToString()
                +"\nrelationWorkList:"+workListToString()
                );
    }
}
