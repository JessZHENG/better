package com.example.json.GetBasicData;

import com.example.entity.BuildingBasic;
import com.example.json.HttpUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetDramaBuildingURI {
    public GetDramaBuildingURI(){}
    public List<BuildingBasic> GeDramaBuildingURI(String urlStr) {
        HttpUtil httpUtil = new HttpUtil();
        String jsonStr = httpUtil.getJsonContent(urlStr);
        List<BuildingBasic> dramaBuildingList=new ArrayList<BuildingBasic>();
        try
        {
            //将json字符串转换为json对象
            JSONObject jsonObject=JSONObject.fromObject(jsonStr);
            //得到指定json key对象的value对象
            if(jsonObject.containsKey("data")) {
                JSONArray buildingArray = jsonObject.getJSONArray("data");
                //获取对象的所有属性
                if (buildingArray.size() != 0) {
                    JSONObject buildingObj = null;
                    for (int i = 0; i < buildingArray.size(); i++) {
                        buildingObj = buildingArray.getJSONObject(i);
                        BuildingBasic buildingBasic = new BuildingBasic();
                        if (buildingObj.containsKey("nameS")) {
                            buildingBasic.setbType("drama");
                            buildingBasic.setName(buildingObj.getString("nameS"));
                        }
                        if (buildingObj.containsKey("bUri"))
                            buildingBasic.setUri(buildingObj.getString("bUri"));
                        dramaBuildingList.add(buildingBasic);
                    }

                }
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        return dramaBuildingList;
    }

}
