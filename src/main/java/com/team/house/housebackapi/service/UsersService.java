package com.team.house.housebackapi.service;

import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.pojo.Users;
import com.team.house.housebackapi.util.PageParameter;

/**
 * @Author ZzHh
 * @Classname DistrictService
 * @Description TODO
 * @Date: Created in 2020/2/25 16:36
 * @Create By IntelliJ IDEA
 **/

public interface UsersService {
    //注册业务
    int regUser(Users users);

    //登录
    Users Login(String username, String password);

    //后台登录
    Users backLogin(String username, String password);

    //超级管理员登陆
    Users superLogin(String username, String password);

    //查询出租户数量
    int getRentNums(Integer rent);

    //查询超级管理员数量
    int getNums(Integer admin);

    //查询用户数量
    int getUserNums();

    //查询所有出租户信息
    PageInfo<Users> getAllUsers(PageParameter pageParameter);
}
