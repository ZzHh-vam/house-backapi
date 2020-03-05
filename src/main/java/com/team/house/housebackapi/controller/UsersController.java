package com.team.house.housebackapi.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.pojo.Users;
import com.team.house.housebackapi.service.UsersService;
import com.team.house.housebackapi.util.PageParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZzHh
 * @Classname HouseController
 * @Description TODO
 * @Date: Created in 2020/2/25 16:41
 * @Create By IntelliJ IDEA
 **/

//全返回数据
@RestController
//解决跨域问题
@CrossOrigin(value = "*", allowCredentials = "true")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     *@Function: userReg
     *@Description: 注册控制器
     *@Param: [users]
     *@Return: com.team.house.housebackapi.pojo.Street
     **/
    @RequestMapping("/userReg")
    public String userReg(Users users){
        //调用业务
        int temp = usersService.regUser(users);  //成功1  失败0
        return "{\"result\":"+temp+"}";
    }

    /**
     *@Function: String
     *@Description: 登录控制器
     *@Param: [username, password]
     *@Return:
     **/
    @RequestMapping("/userLogin")
    public String userLogin(String username, String password, HttpSession session){
        //调用业务
        Users user = usersService.Login(username,password);  //成功1  失败0
        if(user == null){
            return "{\"result\":0}";  //登入失败
        }
        else{
            //只要登入请使用session保存登入人的信息
            session.setAttribute("userslogininfo",user);
            session.setMaxInactiveInterval(6000); //10分钟
            return "{\"result\":1}";  //登入成功
        }
    }

    /**
     *@Function: userLogin
     *@Description: 后台登录控制器
     *@Param: [username, password, session]
     *@Return: java.lang.String
     **/
    @RequestMapping("/backLogin")
    public String backLogin(String username, String password, HttpSession session){
        //调用业务
        Users user = usersService.backLogin(username,password);  //成功1  失败0
        if(user == null){
            return "{\"result\":0}";  //登入失败
        }
        else{
            //只要登入请使用session保存登入人的信息
            session.setAttribute("backlogininfo",user);
            session.setMaxInactiveInterval(6000); //10分钟
            return "{\"result\":1}";  //登入成功
        }
    }

    /**
     *@Function: superLogin
     *@Description: 超级管理员登陆控制器
     *@Param: [username, password, session]
     *@Return: java.lang.String
     **/
    @RequestMapping("/superLogin")
    public String superLogin(String username, String password, HttpSession session){
        //调用业务
        Users user = usersService.superLogin(username,password);  //成功1  失败0
        if(user == null){
            return "{\"result\":0}";  //登入失败
        }
        else{
            //只要登入请使用session保存登入人的信息
            session.setAttribute("superlogininfo",user);
            session.setMaxInactiveInterval(6000); //10分钟
            return "{\"result\":1}";  //登入成功
        }
    }

    /**
     *@Function: getAdminNums
     *@Description: 查询出租户数量
     *@Param: []
     *@Return: int
     **/
    @RequestMapping("/getRentNums")
    public int getRentNums(){
        return usersService.getRentNums(1);
    }

    /**
     *@Function: getAdminNums
     *@Description: 查询超级管理员数量
     *@Param: []
     *@Return: int
     **/
    @RequestMapping("/getAdminNums")
    public int getAdminNums(){
        return usersService.getNums(0);
    }

    /**
     *@Function: getUsersNums
     *@Description: 查询用户数量
     *@Param: []
     *@Return: int
     **/
    @RequestMapping("/getUsersNums")
    public int getUsersNums(){
        return usersService.getUserNums();
    }

    /**
     *@Function: getAllUsers
     *@Description: 查询所有出租户信息
     *@Param: [pageParameter]
     *@Return: com.github.pagehelper.PageInfo<com.team.house.housebackapi.pojo.Users>
     **/
    @RequestMapping("/getAllUsers")
    public Map<String,Object> getAllUsers(PageParameter pageParameter){
        PageInfo<Users> pageInfo = usersService.getAllUsers(pageParameter);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("totalPage",pageInfo.getPages());
        map.put("curPage",pageInfo.getPageNum());
        return map;
    }

    /**
     *@Function: loginOut
     *@Description: 退出
     *@Param: []
     *@Return: java.lang.String
     **/
    @RequestMapping("/loginOut")
    public String loginOut(Integer isadmin, HttpSession session){
        //清空session  将登录用户名清空
        if (isadmin == 0){
            session.removeAttribute("superlogininfo");
        }else if (isadmin == 1){
            session.removeAttribute("userslogininfo");
        }else if (isadmin == null){
            session.removeAttribute("backlogininfo");
        }
        return "{\"result\":1}";
    }
}
