package com.team.house.housebackapi.service.impl;

import com.team.house.housebackapi.mapper.StreetMapper;
import com.team.house.housebackapi.pojo.Street;
import com.team.house.housebackapi.pojo.StreetExample;
import com.team.house.housebackapi.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname StreetServiceImpl
 * @Description TODO
 * @Date: Created in 2020/2/25 16:38
 * @Create By IntelliJ IDEA
 **/

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired(required = false)
    private StreetMapper streetMapper;

    /**
     *@Function: getAllStreet
     *@Description: 根据街道编号查询街道信息
     *@Param: [districtId]
     *@Return: java.util.List<com.team.house.housebackapi.pojo.Street>
     **/
    public List<Street> getAllStreet(Integer districtId) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        if (districtId == null){
            criteria.andDistrictIdIsNull();
        }else{
            criteria.andDistrictIdEqualTo(districtId);
        }
        return streetMapper.selectByExample(streetExample);
    }
}
