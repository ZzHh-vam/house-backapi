package com.team.house.housebackapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.mapper.UsersMapper;
import com.team.house.housebackapi.pojo.Users;
import com.team.house.housebackapi.pojo.UsersExample;
import com.team.house.housebackapi.service.UsersService;
import com.team.house.housebackapi.util.MD5Utils;
import com.team.house.housebackapi.util.PageParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname UsersServiceImpl
 * @Description TODO
 * @Date: Created in 2020/2/25 16:39
 * @Create By IntelliJ IDEA
 **/

@Service
public class UsersServiceImpl implements UsersService {
    //调用UsersMapper
    @Autowired(required = false)
    private UsersMapper usersMapper;

    /**
     *@Function: regUser
     *@Description: 注册业务实现
     *@Param: [users]
     *@Return: int
     **/
    public int regUser(Users users) {
        //密码不能以明文方式保存到DB中,不安全
        //使用md5对密码进行加密后存储到DB中
        //使用步骤:1.导入MD5工具类  2.调用MD5工具类的方法进行加密
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    /**
     *@Function: Login
     *@Description: 
     *@Param: [username, password]
     *@Return: com.team.house.housebackapi.pojo.Users
     **/
    public Users Login(String username, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //设置条件
        criteria.andNameEqualTo(username);
        criteria.andIsadminIsNull();
        //加密后与加密的内容相比
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));  //加密后与加密的内容进行比对
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list != null && list.size() == 1){
            return list.get(0);  //返回第一个对象
        }else{
            return null;
        }
    }

    /**
     *@Function: Login
     *@Description: 后台登陆
     *@Param: [username, password]
     *@Return: com.team.house.housebackapi.pojo.Users
     **/
    public Users backLogin(String username, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //设置条件
        criteria.andNameEqualTo(username);
        criteria.andIsadminEqualTo(1);
        //加密后与加密的内容相比
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));  //加密后与加密的内容进行比对
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list != null && list.size() == 1){
            return list.get(0);  //返回第一个对象
        }else{
            return null;
        }
    }

    /**
     *@Function: superLogin
     *@Description: 超级管理员登陆
     *@Param: [username, password]
     *@Return: com.team.house.housebackapi.pojo.Users
     **/
    public Users superLogin(String username, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //设置条件
        criteria.andNameEqualTo(username);
        criteria.andIsadminEqualTo(0);
        //加密后与加密的内容相比
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));  //加密后与加密的内容进行比对
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list != null && list.size() == 1){
            return list.get(0);  //返回第一个对象
        }else{
            return null;
        }
    }

    /**
     *@Function: getNums
     *@Description: 查询出租户数量
     *@Param: [admin]
     *@Return: int
     **/
    public int getRentNums(Integer rent) {
        return usersMapper.selectRentNums(rent);
    }

    /**
     *@Function: getNums
     *@Description: 查询超级管理员数量
     *@Param: [admin]
     *@Return: int
     **/
    public int getNums(Integer admin) {
        return usersMapper.selectNums(admin);
    }

    /**
     *@Function: getUserNums
     *@Description: 查询用户数量
     *@Param: []
     *@Return: int
     **/
    public int getUserNums() {
        return usersMapper.selectUsersNums();
    }

    /**
     *@Function: getAllUsers
     *@Description: 查询所有出租户信息
     *@Param: []
     *@Return: java.util.List<com.team.house.housebackapi.pojo.Users>
     **/
    public PageInfo<Users> getAllUsers(PageParameter pageParameter) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getPageSize());
        List<Users> list = usersMapper.selectAllUsers();
        return new PageInfo<>(list);
    }
}
