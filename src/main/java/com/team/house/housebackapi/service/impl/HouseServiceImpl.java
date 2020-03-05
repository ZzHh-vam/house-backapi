package com.team.house.housebackapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.mapper.HouseMapper;
import com.team.house.housebackapi.pojo.House;
import com.team.house.housebackapi.service.HouseService;
import com.team.house.housebackapi.util.Condition;
import com.team.house.housebackapi.util.PageParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname HouseServiceImpl
 * @Description TODO
 * @Date: Created in 2020/2/25 16:38
 * @Create By IntelliJ IDEA
 **/

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;

    /**
     *@Function: addHouse
     *@Description: 发布房屋信息
     *@Param: [house]
     *@Return: int
     **/
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    /**
     *@Function: getHouseByUserId
     *@Description: 查询特定用户下所有出租房信息并支持分页
     *@Param: [uid, pageParameter]
     *@Return: com.github.pagehelper.PageInfo<com.team.house.housebackapi.pojo.House>
     **/
    public PageInfo<House> getHouseByUserId(Integer uid, PageParameter pageParameter) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getPageSize());
        List<House> list = houseMapper.getHouseByUserId(uid);
        return new PageInfo<>(list);
    }

    /**
     *@Function: getHouseByAdmin
     *@Description: 管理员查询所有出租房信息并支持分页
     *@Param: [pageParameter]
     *@Return: com.github.pagehelper.PageInfo<com.team.house.housebackapi.pojo.House>
     **/
    public PageInfo<House> getHouseByAdmin(PageParameter pageParameter){
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getPageSize());
        List<House> list = houseMapper.getHouseByAdmin();
        return new PageInfo<>(list);
    }

    /**
     *@Function: deleteHouse
     *@Description: 删除发布的出租房信息
     *@Param: [id]
     *@Return: int
     **/
    public int deleteHouse(String id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    /**
     *@Function: getHouseByCondition
     *@Description: 带条件分页查询当前用户下的所有出租房
     *@Param: [uid, condition]
     *@Return: com.github.pagehelper.PageInfo<com.team.house.housebackapi.pojo.House>
     **/
    public PageInfo<House> getHouseByCondition(Condition condition) {
        //开启分页
        PageHelper.startPage(condition.getPage(), condition.getPageSize());
        //调用持久化操作
        List<House> list = houseMapper.getHouseByCondition(condition);
        //获取分页信息
        return new PageInfo<>(list);
    }

    /**
     *@Function: getHouseById
     *@Description: 根据id查租房信息
     *@Param: [id]
     *@Return: com.team.house.housebackapi.pojo.House
     **/
    public List<House> getHouseById(String id) {
        return houseMapper.getHouseById(id);
    }
}
