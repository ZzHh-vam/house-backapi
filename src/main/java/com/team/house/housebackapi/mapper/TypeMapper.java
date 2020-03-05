package com.team.house.housebackapi.mapper;

import com.team.house.housebackapi.pojo.Type;
import com.team.house.housebackapi.pojo.TypeExample;
import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}