package com.team.house.housebackapi.mapper;

import com.team.house.housebackapi.pojo.Street;
import com.team.house.housebackapi.pojo.StreetExample;
import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
}