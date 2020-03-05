package com.team.house.housebackapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//使用@MapperScan扫描Mapper接口
@MapperScan("com.team.house.housebackapi.mapper")
public class HouseBackapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseBackapiApplication.class, args);
    }

}
