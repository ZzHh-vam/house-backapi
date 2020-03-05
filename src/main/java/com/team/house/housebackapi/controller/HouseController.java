package com.team.house.housebackapi.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.pojo.House;
import com.team.house.housebackapi.pojo.Users;
import com.team.house.housebackapi.service.HouseService;
import com.team.house.housebackapi.util.Condition;
import com.team.house.housebackapi.util.FileUploadUtil;
import com.team.house.housebackapi.util.PageParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
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
public class HouseController {
    @Autowired(required = false)
    private HouseService houseService;

    //返回所有的数据
    @RequestMapping("/fabuHouse")
    public String fabuHouse(House house, HttpSession session, @RequestParam(value = "pfile",required = false) MultipartFile pfile){
        //house对象用于获取表单数据
        try {
            //2.文件上传:一个CommonsMultipartFile类的对象对应一个表单中上传的文件
            String path = "F:\\FileServer\\RentSystem\\images";  //设置文件存储位置
            String fileName = FileUploadUtil.upload(pfile,path);

            //1.调用业务将信息保存到DB
            //设置出租房的编号  时间毫秒数
            house.setId(System.currentTimeMillis() + "");
            //1.2设置所属用户
            Users users = (Users)session.getAttribute("backlogininfo");
            house.setUserId(users.getId());

            //3.设置保存文件的路径
            house.setPath(fileName);  //保存文件名即可

            houseService.addHouse(house);
            return "{\"result\":1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":0}";
    }

    //接收用户请求获取当前页的数据
    @RequestMapping("/getHouseByPage")
    public Map<String,Object> getHouseByPage(PageParameter pageParameter, HttpSession session){
        //调用业务获取数据
        //获取session中的用户id
        Users users = (Users) session.getAttribute("backlogininfo");
        PageInfo<House> pageInfo = houseService.getHouseByUserId(users.getId(),pageParameter);  //用户id
        //返回多块信息:总页数、当前页记录...
        Map<String,Object> map = new HashMap<>();
        map.put("totalPage",pageInfo.getPages());  //封装总页
        map.put("rows",pageInfo.getList());  //封装当前页的记录
        map.put("curPage",pageInfo.getPageNum());  //封装当前页码
        return map;
    }

    //删除发布的出租房信息
    @RequestMapping("/delHouse")
    public String delHouse(String id, String filename){
        //调用业务删除出租房
        int temp = houseService.deleteHouse(id);
        if (temp > 0){
            //删除图片
            File file = new File("F:\\FileServer\\RentSystem\\images\\" + filename);
            if (file.exists()){
                file.delete();  //删除
            }
            return "{\"result\":1}";
        }else{
            return "{\"result\":0}";
        }
    }

    //带条件分页查询当前用户下的所有出租房
    @RequestMapping("/getHouseByCondition")
    public Map<String,Object> getHouseByCondition(Condition condition){
        //调用业务获取数据
        PageInfo<House> pageInfo = houseService.getHouseByCondition(condition);
        Map<String,Object> map = new HashMap<>();
        map.put("totalPage",pageInfo.getPages());  //封装总页
        map.put("rows",pageInfo.getList());  //封装当前页的记录
        map.put("curPage",pageInfo.getPageNum());  //封装当前页码
        return map;
    }

    //管理员查询所有出租房信息并支持分页
    @RequestMapping("/getHouseByAdmin")
    public Map<String,Object> getHouseByAdmin(PageParameter pageParameter){
        //调用业务获取数据
        PageInfo<House> pageInfo = houseService.getHouseByAdmin(pageParameter);
        //返回多块信息:总页数、当前页记录...
        Map<String,Object> map = new HashMap<>();
        map.put("totalPage",pageInfo.getPages());  //封装总页
        map.put("rows",pageInfo.getList());  //封装当前页的记录
        map.put("curPage",pageInfo.getPageNum());  //封装当前页码
        return map;
    }

    //根据id查租房信息
    @RequestMapping("/getHouseById")
    public List<House> getHouseById(String id){
        return houseService.getHouseById(id);
    }
}
