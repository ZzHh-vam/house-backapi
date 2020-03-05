package com.team.house.housebackapi.service;

import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.pojo.House;
import com.team.house.housebackapi.util.Condition;
import com.team.house.housebackapi.util.PageParameter;

import java.util.List;


/**
 * @Author ZzHh
 * @Classname DistrictService
 * @Description TODO
 * @Date: Created in 2020/2/25 16:36
 * @Create By IntelliJ IDEA
 **/

public interface HouseService {
    //发布房屋信息
    int addHouse(House house);

    //查询特定用户下所有出租房信息并支持分页
    PageInfo<House> getHouseByUserId(Integer uid, PageParameter pageParameter);

    //管理员查询所有出租房信息
    PageInfo<House> getHouseByAdmin(PageParameter pageParameter);

    //删除发布的出租房信息
    int deleteHouse(String id);

    //带条件分页查询当前用户下的所有出租房
    PageInfo<House> getHouseByCondition(Condition condition);

    //根据id查租房信息
    List<House> getHouseById(String id);
}
