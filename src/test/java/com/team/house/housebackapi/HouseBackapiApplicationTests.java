package com.team.house.housebackapi;

import com.team.house.housebackapi.mapper.DistrictMapper;
import com.team.house.housebackapi.mapper.HouseMapper;
import com.team.house.housebackapi.mapper.StreetMapper;
import com.team.house.housebackapi.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HouseBackapiApplicationTests {
    //注入mapper对象
    @Autowired(required = false)
    private DistrictMapper districtMapper;
    @Autowired(required = false)
    private StreetMapper streetMapper;
    @Autowired(required = false)
    private HouseMapper houseMapper;

    @Test
    void contextLoads() {
        /*List<District> list = districtMapper.selectByExample(new DistrictExample());
        System.out.println("总纪录数:" + list.size());
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        Integer districtId = 1000;
        if (districtId == null){
            criteria.andDistrictIdIsNull();
        }else{
            criteria.andDistrictIdEqualTo(districtId);
        }
        List<Street> streets = streetMapper.selectByExample(streetExample);
        System.out.println("街道数:" + streets.size());*/
    }
}
