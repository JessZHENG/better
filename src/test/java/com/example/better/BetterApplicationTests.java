package com.example.better;

import com.example.entity.BuildingBasic;
import com.example.json.GetBasicData.GetDramaBuildingURI;
import com.example.json.GetBasicData.GetHisBuildingURI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BetterApplicationTests {
   @Resource
   private JdbcTemplate jdbcTemplate;
    /**
     * Mysql集成Spring Boot简单测试
     */
    /*
    @Test
    public void mySqlTest() {
        String sql="select id,name from hisbuildingbasic";
        List<BuildingBasic> list =( List<BuildingBasic> ) jdbcTemplate.query(sql, new RowMapper<BuildingBasic>() {// RowMapper对象可以将查询出的每一行封装成用户定义的类，这里将结果封装成AyUser类
            @Override
            public BuildingBasic mapRow(ResultSet rs, int rowNum) throws SQLException {
                BuildingBasic buildingBasic=new BuildingBasic();
                buildingBasic.setId(rs.getInt("id"));
                buildingBasic.setName(rs.getString("name"));
                buildingBasic.setUri(rs.getString("uri"));
                return buildingBasic;
            }
        });
        System.out.println("查询成功：");
        for(BuildingBasic buildingBasic:list){
            System.out.println("【id】:"+buildingBasic.getId()+"；【name】"+buildingBasic.getName());
        }
    }

     */


    @Test
    public void TestHisUri(){//void mySqlTest() {
        String url="http://jpv1.library.sh.cn/wkl/webapi/building/list?key=156c4b9ece0011b6c375cb68a8d7b0b77a0c5809";
        GetHisBuildingURI getHisBuildingURI=new GetHisBuildingURI();
        List<BuildingBasic> buildingBasicList=getHisBuildingURI.GeHisBuildingURI(url);
        BuildingBasic buildingBasic=new BuildingBasic();
        for(int i=0;i<buildingBasicList.size();i++)
        {
            buildingBasic=buildingBasicList.get(i);
            jdbcTemplate.update("INSERT INTO hisbuildingbasic(b_type,name,address,uri,lon,lat) VALUES (?,?,?,?,?,?)",
                    buildingBasic.getbType(), buildingBasic.getName(),buildingBasic.getAddress(),
                    buildingBasic.getUri(),buildingBasic.getLon(),buildingBasic.getLat());
        }
        System.out.println("Good!");
    }

    @Test
    public void TestDramaUri(){//void mySqlTest() {
        String url="http://data1.library.sh.cn/shnh/dydata/webapi/architecture/getArchitecture?key=156c4b9ece0011b6c375cb68a8d7b0b77a0c5809";
        GetDramaBuildingURI getDramaBuildingURI=new GetDramaBuildingURI();
        List<BuildingBasic> buildingBasicList=getDramaBuildingURI.GeDramaBuildingURI(url);
        BuildingBasic buildingBasic=new BuildingBasic();
        for(int i=0;i<buildingBasicList.size();i++)
        {
            buildingBasic=buildingBasicList.get(i);
            jdbcTemplate.update("INSERT INTO hisbuildingbasic(b_type,name,address,uri,lon,lat) VALUES (?,?,?,?,?,?)",
                    buildingBasic.getbType(), buildingBasic.getName(),buildingBasic.getAddress(),
                    buildingBasic.getUri(),buildingBasic.getLon(),buildingBasic.getLat());
        }
        System.out.println("Good!");
    }

    @Test
    @AutoConfigureTestDatabase
    public void contextLoads() {
    }

}
