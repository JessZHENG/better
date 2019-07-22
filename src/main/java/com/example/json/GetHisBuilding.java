package com.example.json;

import com.example.entity.KnowledgeData.HisBuilding;
import com.example.entity.KnowledgeData.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetHisBuilding {
    public GetHisBuilding(){}
    public HisBuilding GetHisBuilding(String urlStr) {
        HttpUtil httpUtil = new HttpUtil();
        String jsonStr = httpUtil.getJsonContent(urlStr);
        HisBuilding hisBuilding=new HisBuilding();
        try
        {
            //将json字符串转换为json对象
            JSONObject jsonObject=JSONObject.fromObject(jsonStr);
            //得到指定json key对象的value对象
            JSONObject hisBuildingObj=jsonObject.getJSONObject("data");
            //获取对象的所有属性
            if(hisBuildingObj.containsKey("address"))
            hisBuilding.setAddress(hisBuildingObj.getString("address"));
            if(hisBuildingObj.containsKey("created"))
            hisBuilding.setCreated(hisBuildingObj.getString("created"));
            if(hisBuildingObj.containsKey("houseNumber"))
            hisBuilding.setHousenumber(hisBuildingObj.getString("houseNumber"));
            if(hisBuildingObj.containsKey("description"))
            hisBuilding.setDes(hisBuildingObj.getString("description"));
            if(hisBuildingObj.containsKey("uri"))
            hisBuilding.setUri(hisBuildingObj.getString("uri"));
            if(hisBuildingObj.containsKey("architecturalStyle"))
            hisBuilding.setArchitecturalStyle(hisBuildingObj.getString("architecturalStyle"));
            if(hisBuildingObj.containsKey("hasFile"))
            hisBuilding.setHasFile(hisBuildingObj.getInt("hasFile"));
            if(hisBuildingObj.containsKey("architectureStructure"))
            hisBuilding.setArchitectureStructure(hisBuildingObj.getString("architectureStructure"));
            if(hisBuildingObj.containsKey("yname"))
            hisBuilding.setYname(hisBuildingObj.getString("yname"));

            //location
            if(hisBuildingObj.containsKey("location")) {
                JSONObject locationObj = null;
                JSONArray locationArray = hisBuildingObj.getJSONArray("location");
                if (locationArray.size() != 0) {
                    List<Location> list = new ArrayList<Location>();
                    for (int i = 0; i < locationArray.size(); i++) {
                        locationObj = locationArray.getJSONObject(i);
                        Location location = new Location();
                        if (locationObj.containsKey("long"))
                            location.setLon(locationObj.getString("long"));
                        if (locationObj.containsKey("lat"))
                            location.setLat(locationObj.getString("lat"));
                        list.add(location);
                    }
                    hisBuilding.setHasLocation(1);
                    hisBuilding.setBuildingLocation(list);
                }
            }


            //designer
            if(hisBuildingObj.containsKey("designer")){
                JSONObject designerObj=null;
                JSONArray designerArray = hisBuildingObj.getJSONArray("designer");
                List<Designer> list = new ArrayList<Designer>();
                for(int i=0;i<designerArray.size();i++){
                    designerObj = designerArray.getJSONObject(i);
                    Designer designer=new Designer();
                    if(designerObj.containsKey("name")) {
                        designer.setDesigner_name(designerObj.getString("name"));
                        designer.setDesigner_type("person");
                    }
                    if(designerObj.containsKey("label")) {
                        designer.setDesigner_name(designerObj.getString("label"));
                        designer.setDesigner_type("organization");
                    }
                    if(designerObj.containsKey("uri"))
                        designer.setDesigner_uri(designerObj.getString("uri"));
                    list.add(designer);
                }
                hisBuilding.setBuildingDesignerList(list);
            }

            //road
            if(hisBuildingObj.containsKey("road")){
                JSONObject roadObj=null;
                JSONArray roadArray = hisBuildingObj.getJSONArray("road");
                if(roadArray.size()!=0) {
                    List<Road> list = new ArrayList<Road>();
                    for (int i = 0; i < roadArray.size(); i++) {
                        roadObj = roadArray.getJSONObject(i);
                        Road road = new Road();
                        if (roadObj.containsKey("name"))
                            road.setRoad_name(roadObj.getString("name"));
                        if (roadObj.containsKey("uri"))
                            road.setRoad_uri(roadObj.getString("uri"));
                        list.add(road);
                    }
                    hisBuilding.setHasRoad(1);
                    hisBuilding.setBuildingRoadList(list);
                }
            }


            //event
            if(hisBuildingObj.containsKey("event")) {
                JSONObject eventObj = null;
                JSONArray eventArray = hisBuildingObj.getJSONArray("event");
                if (eventArray.size() != 0) {
                    List<BuildingEvent> list = new ArrayList<BuildingEvent>();
                    for (int i = 0; i < eventArray.size(); i++) {
                        eventObj = eventArray.getJSONObject(i);
                        BuildingEvent buildingEvent = new BuildingEvent();
                        if (eventObj.containsKey("startedAtTime"))
                            buildingEvent.setStartedAtTime(eventObj.getString("startedAtTime"));
                        if (eventObj.containsKey("description"))
                            buildingEvent.setDescription(eventObj.getString("description"));
                        list.add(buildingEvent);
                    }
                    hisBuilding.setHasEvent(1);
                    hisBuilding.setBuildingEventList(list);

                    //relation
                    Relations relations=new Relations();
                    if(hisBuildingObj.containsKey("relation")){
                        JSONObject personObj=null;
                        JSONArray personArray = hisBuildingObj.getJSONArray("relation");
                        List<Relation> personList = new ArrayList<Relation>();
                        if(personArray.size()!=0) {
                            for (int i = 0; i < personArray.size(); i++) {
                                personObj = personArray.getJSONObject(i);
                                Relation personRelation = new Relation();
                                if (personObj.containsKey("name"))
                                    personRelation.setName(personObj.getString("name"));
                                if (personObj.containsKey("uri"))
                                    personRelation.setType("person");
                                personRelation.setUri(personObj.getString("uri"));
                                personList.add(personRelation);
                            }
                            relations.setHasPerson(1);
                            relations.setRelationPersonList(personList);
                        }
                    }
                    //hasRelation
                    if((relations.getHasPerson()!=0)||(relations.getHasWork()!=0)){
                        hisBuilding.setHasRelation(1);
                        hisBuilding.setBuildingRelation(relations);
                    }
                }
            }

        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        return hisBuilding;
    }


}
