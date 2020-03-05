package com.team.house.housebackapi.mapper;

import com.team.house.housebackapi.pojo.District;
import com.team.house.housebackapi.pojo.DistrictExample;
import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}