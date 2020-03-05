package com.team.house.housebackapi.service;

import com.team.house.housebackapi.pojo.District;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname DistrictService
 * @Description TODO
 * @Date: Created in 2020/2/25 16:36
 * @Create By IntelliJ IDEA
 **/

public interface DistrictService {
    //查询所有区信息
    List<District> getAllDistrict();
}
