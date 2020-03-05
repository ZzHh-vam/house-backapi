package com.team.house.housebackapi.service;

import com.team.house.housebackapi.pojo.Street;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname DistrictService
 * @Description TODO
 * @Date: Created in 2020/2/25 16:36
 * @Create By IntelliJ IDEA
 **/

public interface StreetService {
    //根据街道编号查询街道信息
    List<Street> getAllStreet(Integer districtId);
}
