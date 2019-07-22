package com.example.json;

import com.example.entity.KnowledgeData.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetRedBuilding {
    public GetRedBuilding(){}
    public RedBuilding GetRedBuilding(String urlStr) {
        HttpUtil httpUtil = new HttpUtil();
        String jsonStr = httpUtil.getJsonContent(urlStr);
        RedBuilding redBuilding=new RedBuilding();
        try
        {
            //将json字符串转换为json对象
            JSONObject jsonObject=JSONObject.fromObject(jsonStr);
            //得到指定json key对象的value对象
            if(jsonObject.containsKey("data")) {
                JSONArray redBuildingArray = jsonObject.getJSONArray("data");

                //获取对象的所有属性
                JSONObject redBuildingObj = redBuildingArray.getJSONObject(0);

                if (redBuildingObj.containsKey("address"))
                    redBuilding.setAddress(redBuildingObj.getString("address"));
                //placeUri
                if (redBuildingObj.containsKey("houseNumber"))
                    redBuilding.setHousenumber(redBuildingObj.getString("houseNumber"));
                //firstImg,source,type
                if (redBuildingObj.containsKey("uri"))
                    redBuilding.setUri(redBuildingObj.getString("uri"));
                if (redBuildingObj.containsKey("nameS"))
                    redBuilding.setName(redBuildingObj.getString("nameS"));
                if (redBuildingObj.containsKey("des"))
                    redBuilding.setDes(redBuildingObj.getString("des"));
                //firstImgPath

                //road
                List<Road> roadList = new ArrayList<Road>();
                Road road=new Road();
                if (redBuildingObj.containsKey("road"))
                    road.setRoad_name(redBuildingObj.getString("road"));
                if (redBuildingObj.containsKey("roadUri")){
                    road.setRoad_uri(redBuildingObj.getString("roadUri"));
                    redBuilding.setHasRoad(1);
                    }
                roadList.add(road);
                redBuilding.setBuildingRoadList(roadList);




                //location
                List<Location> locationList = new ArrayList<Location>();
                Location location=new Location();
                if (redBuildingObj.containsKey("lat"))
                    location.setLat(redBuildingObj.getString("lat"));
                if (redBuildingObj.containsKey("long"))
                    location.setLat(redBuildingObj.getString("long"));
                locationList.add(location);
                if(locationList.size()!=0) {
                    redBuilding.setBuildingLocation(locationList);
                    redBuilding.setHasLocation(1);
                }

                    //eventList
                if(redBuildingObj.containsKey("eventList")){
                    JSONObject eventObj=null;
                    JSONArray eventArray = redBuildingObj.getJSONArray("eventList");
                    List<BuildingEvent> list = new ArrayList<BuildingEvent>();
                    if(eventArray.size()!=0) {
                        for (int i = 0; i < eventArray.size(); i++) {
                            eventObj = eventArray.getJSONObject(i);
                            BuildingEvent buildingEvent = new BuildingEvent();
                            if (eventObj.containsKey("startedAtTime"))
                                buildingEvent.setStartedAtTime(eventObj.getString("startedAtTime"));
                            if (eventObj.containsKey("description"))
                                buildingEvent.setDescription(eventObj.getString("description"));
                            list.add(buildingEvent);
                        }
                        redBuilding.setHasEvent(1);
                        redBuilding.setBuildingEventList(list);
                    }
                }

                //imageList
                if(redBuildingObj.containsKey("imageList")) {
                    JSONObject imageObj = null;
                    JSONArray imageArray = redBuildingObj.getJSONArray("imageList");
                    List<Images> imageList = new ArrayList<Images>();
                    if(imageArray.size()!=0) {
                        for (int i = 0; i < imageArray.size(); i++) {
                            imageObj = imageArray.getJSONObject(i);
                            Images buildingimage = new Images();
                            if (imageObj.containsKey("imageUri"))
                                buildingimage.setUri(imageObj.getString("imageUri"));
                            if (imageObj.containsKey("imgPath"))
                                buildingimage.setPath(imageObj.getString("imgPath"));
                            if (imageObj.containsKey("description"))
                                buildingimage.setDescription(imageObj.getString("description"));
                            imageList.add(buildingimage);
                        }
                        redBuilding.setHasFile(1);
                        redBuilding.setBuildingImageList(imageList);
                    }
                }


                //personList
                Relations relations=new Relations();
                if(redBuildingObj.containsKey("personList")){
                    JSONObject personObj=null;
                    JSONArray personArray = redBuildingObj.getJSONArray("personList");
                    List<Relation> personList = new ArrayList<Relation>();
                    if(personArray.size()!=0) {
                        for (int i = 0; i < personArray.size(); i++) {
                            personObj = personArray.getJSONObject(i);
                            Relation personRelation = new Relation();
                            if (personObj.containsKey("personName"))
                                personRelation.setName(personObj.getString("personName"));
                            if (personObj.containsKey("personUri"))
                                personRelation.setType("person");
                                personRelation.setUri(personObj.getString("personUri"));
                            personList.add(personRelation);
                        }
                        relations.setHasPerson(1);
                        relations.setRelationPersonList(personList);
                    }
                }

                //workList
                if(redBuildingObj.containsKey("workList")){
                    JSONObject workObj=null;
                    JSONArray workArray = redBuildingObj.getJSONArray("workList");
                    List<Relation> workList = new ArrayList<Relation>();
                    if(workArray.size()!=0) {
                        for (int i = 0; i < workArray.size(); i++) {
                            workObj = workArray.getJSONObject(i);
                            Relation workRelation = new Relation();
                            if (workObj.containsKey("workTitle"))
                                workRelation.setName(workObj.getString("personTitle"));
                            if (workObj.containsKey("workUri"))
                                workRelation.setType("work");
                                workRelation.setUri(workObj.getString("workUri"));
                            workList.add(workRelation);
                        }
                        relations.setHasWork(1);
                        relations.setRelationWorkList(workList);
                    }
                }

                //hasRelation
                if((relations.getHasPerson()!=0)||(relations.getHasWork()!=0)){
                    redBuilding.setHasRelation(1);
                    redBuilding.setBuildingRelation(relations);
                }





            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        return redBuilding;
    }


}
