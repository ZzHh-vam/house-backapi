package com.team.house.housebackapi.mapper;

import com.team.house.housebackapi.pojo.Users;
import com.team.house.housebackapi.pojo.UsersExample;
import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    //查询出租户数量
    int selectRentNums(Integer rent);

    //查询超级管理员数量
    int selectNums(Integer admin);

    //查询用户数量
    int selectUsersNums();

    //查询所有出租户信息
    List<Users> selectAllUsers();
}