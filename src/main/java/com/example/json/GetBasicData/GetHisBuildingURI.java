package com.example.json.GetBasicData;

import com.example.entity.BuildingBasic;
import com.example.json.HttpUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetHisBuildingURI {
    public GetHisBuildingURI(){}
    public List<BuildingBasic> GeHisBuildingURI(String urlStr) {
        HttpUtil httpUtil = new HttpUtil();
        String jsonStr = httpUtil.getJsonContent(urlStr);
        List<BuildingBasic> hisBuildingList=new ArrayList<BuildingBasic>();
        try
        {
            //将json字符串转换为json对象
            JSONObject jsonObject=JSONObject.fromObject(jsonStr);
            //得到指定json key对象的value对象
            if(jsonObject.containsKey("data")) {
                JSONArray buildingArray = jsonObject.getJSONArray("data");
                //获取对象的所有属性
                    if (buildingArray.size() != 0) {
                        JSONObject buildingObj=null;
                        for (int i = 0; i < buildingArray.size(); i++) {
                            buildingObj = buildingArray.getJSONObject(i);
                            BuildingBasic buildingBasic=new BuildingBasic();
                            if (buildingObj.containsKey("address")){
                                buildingBasic.setbType("his");
                                buildingBasic.setAddress(buildingObj.getString("address"));
                            }
                            if (buildingObj.containsKey("name"))
                                buildingBasic.setName(buildingObj.getString("name"));
                            if (buildingObj.containsKey("uri"))
                                buildingBasic.setUri(buildingObj.getString("uri"));

                            if(buildingObj.containsKey("location")) {
                                JSONArray locationArray = buildingObj.getJSONArray("location");
                                JSONObject locationObj =locationArray.getJSONObject(0);
                                if (locationObj.containsKey("lat"))
                                    buildingBasic.setLat(locationObj.getString("lat"));
                                if (locationObj.containsKey("long"))
                                    buildingBasic.setLon(locationObj.getString("long"));
                            }
                            hisBuildingList.add(buildingBasic);
                        }

                    }
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        return hisBuildingList;
    }

}
