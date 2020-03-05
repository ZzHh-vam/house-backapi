package com.team.house.housebackapi.mapper;

import com.team.house.housebackapi.pojo.House;
import com.team.house.housebackapi.pojo.HouseExample;
import com.team.house.housebackapi.util.Condition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //通过用户编号查询当前用户下的出租房
    List<House> getHouseByUserId(Integer id);

    //带条件分页查询当前用户下的所有出租房
    List<House> getHouseByCondition(Condition condition);

    //通过租房编号查询出租房信息
    List<House> getHouseById(String id);

    //分页查询所有出租房信息
    List<House> getHouseByAdmin();
}