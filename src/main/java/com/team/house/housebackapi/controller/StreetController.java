package com.team.house.housebackapi.controller;

import com.team.house.housebackapi.pojo.Street;
import com.team.house.housebackapi.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
public class StreetController {
    @Autowired
    private StreetService streetService;

    //返回所有的数据
    @RequestMapping("/getStreetByDid")
    public List<Street> getStreetByDid(Integer districtId){
        return streetService.getAllStreet(districtId);
    }
}
