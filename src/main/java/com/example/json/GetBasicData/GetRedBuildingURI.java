package com.example.json.GetBasicData;

import com.example.entity.BuildingBasic;
import com.example.json.HttpUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetRedBuildingURI {
    public GetRedBuildingURI(){}
    public List<BuildingBasic> GeRedBuildingURI(String urlStr) {
        HttpUtil httpUtil = new HttpUtil();
        String jsonStr = httpUtil.getJsonContent(urlStr);
        List<BuildingBasic> RedBuildingList=new ArrayList<BuildingBasic>();
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
                                buildingBasic.setbType("red");
                                buildingBasic.setAddress(buildingObj.getString("address"));
                            }
                            if (buildingObj.containsKey("nameS"))
                                buildingBasic.setName(buildingObj.getString("nameS"));
                            if (buildingObj.containsKey("uri"))
                                buildingBasic.setUri(buildingObj.getString("uri"));

                                if (buildingObj.containsKey("lat"))
                                    buildingBasic.setLat(buildingObj.getString("lat"));
                                if (buildingObj.containsKey("long"))
                                    buildingBasic.setLon(buildingObj.getString("long"));
                            RedBuildingList.add(buildingBasic);
                        }

                    }
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        return RedBuildingList;
    }

}
