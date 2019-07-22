package com.example.json;

import com.example.entity.KnowledgeData.DramaBuilding;
import com.example.entity.KnowledgeData.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetDramaBuilding {
    public GetDramaBuilding(){}
    public DramaBuilding GetDramaBuilding(String urlStr) {
        HttpUtil httpUtil = new HttpUtil();
        String jsonStr = httpUtil.getJsonContent(urlStr);
        DramaBuilding dramaBuilding=new DramaBuilding();
        try
        {
            //将json字符串转换为json对象
            JSONObject jsonObject=JSONObject.fromObject(jsonStr);
            //得到指定json key对象的value对象
            if(jsonObject.containsKey("data")) {
                JSONArray dramaBuildingArray = jsonObject.getJSONArray("data");

                //获取对象的所有属性
                JSONObject tdramaBuildingObj = dramaBuildingArray.getJSONObject(0);
                JSONObject dramaBuildingObj = tdramaBuildingObj.getJSONObject("building");
                JSONObject dramaBuildingObj1 = tdramaBuildingObj.getJSONObject("architecture");

                if (dramaBuildingObj.containsKey("nameS"))
                    dramaBuilding.setName(dramaBuildingObj.getString("nameS"));
                if (dramaBuildingObj.containsKey("address"))
                    dramaBuilding.setAddress(dramaBuildingObj.getString("address"));
                if (dramaBuildingObj.containsKey("house"))
                    dramaBuilding.setHousenumber(dramaBuildingObj.getString("house"));
                if (dramaBuildingObj.containsKey("nameOther"))
                    dramaBuilding.setYname(dramaBuildingObj.getString("nameOther"));
                if (dramaBuildingObj.containsKey("uri"))
                    dramaBuilding.setUri(dramaBuildingObj.getString("uri"));

                if (dramaBuildingObj1.containsKey("des"))
                    dramaBuilding.setDes(dramaBuildingObj1.getString("des"));
                //person
                if (dramaBuildingObj1.containsKey("bUri"))
                    dramaBuilding.setbUri(dramaBuildingObj1.getString("bUri"));
                //nameOtherUri,dramaName,movieName,

                //location
                List<Location> locationList = new ArrayList<Location>();
                Location location=new Location();
                if (dramaBuildingObj.containsKey("lat"))
                location.setLat(dramaBuildingObj.getString("lat"));
                if (dramaBuildingObj.containsKey("lon"))
                location.setLat(dramaBuildingObj.getString("lon"));
                locationList.add(location);
                dramaBuilding.setBuildingLocation(locationList);


                //eventList|imageUri，source
                if(dramaBuildingObj1.containsKey("eventList")){
                    JSONObject eventObj=null;
                    JSONArray eventArray = dramaBuildingObj1.getJSONArray("eventList");
                    List<BuildingEvent> list = new ArrayList<BuildingEvent>();
                    for(int i=0;i<eventArray.size();i++){
                        eventObj = eventArray.getJSONObject(i);
                        BuildingEvent buildingEvent=new BuildingEvent();
                        if(eventObj.containsKey("startedAtTime"))
                            buildingEvent.setStartedAtTime(eventObj.getString("startedAtTime"));
                        if(eventObj.containsKey("description"))
                            buildingEvent.setDescription(eventObj.getString("description"));
                        if(eventObj.containsKey("imageP")&&eventObj.getString("imageP")!="") {
                            buildingEvent.setHasImg(1);
                            buildingEvent.setImagePath(eventObj.getString("imageP"));
                        }
                        list.add(buildingEvent);
                    }
                    dramaBuilding.setHasEvent(1);
                    dramaBuilding.setBuildingEventList(list);
                }

                //imagesList
                if(dramaBuildingObj1.containsKey("imagesList")){
                    JSONObject imageObj=null;
                    JSONArray imageArray = dramaBuildingObj1.getJSONArray("imagesList");
                    List<Images> imageList = new ArrayList<Images>();
                    for(int i=0;i<imageArray.size();i++){
                        imageObj = imageArray.getJSONObject(i);
                        Images buildingimage=new Images();
                        if(imageObj.containsKey("imageUri"))
                            buildingimage.setUri(imageObj.getString("imageUri"));
                        if(imageObj.containsKey("imgP"))
                            buildingimage.setPath(imageObj.getString("imgP"));
                        if(imageObj.containsKey("description"))
                            buildingimage.setDescription(imageObj.getString("description"));
                        imageList.add(buildingimage);
                    }
                    dramaBuilding.setHasFile(1);
                    dramaBuilding.setBuildingImageList(imageList);
                }



                //personList
                Relations relations=new Relations();
                if(dramaBuildingObj1.containsKey("personList")){
                    JSONObject personObj=null;
                    JSONArray personArray = dramaBuildingObj1.getJSONArray("personList");
                    List<Relation> personList = new ArrayList<Relation>();
                    if(personArray.size()!=0) {
                        for (int i = 0; i < personArray.size(); i++) {
                            personObj = personArray.getJSONObject(i);
                            Relation personRelation = new Relation();
                            if (personObj.containsKey("pname"))
                                personRelation.setName(personObj.getString("pname"));
                            if (personObj.containsKey("puri"))
                                personRelation.setType("person");
                            personRelation.setUri(personObj.getString("puri"));
                            personList.add(personRelation);
                        }
                        relations.setHasPerson(1);
                        relations.setRelationPersonList(personList);
                    }
                }
                //hasRelation
                if((relations.getHasPerson()!=0)||(relations.getHasWork()!=0)){
                    dramaBuilding.setHasRelation(1);
                    dramaBuilding.setBuildingRelation(relations);
                }


            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        return dramaBuilding;
    }


}
