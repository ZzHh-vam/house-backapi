package com.team.house.housebackapi.service.impl;

import com.team.house.housebackapi.mapper.TypeMapper;
import com.team.house.housebackapi.pojo.Type;
import com.team.house.housebackapi.pojo.TypeExample;
import com.team.house.housebackapi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname TypeServiceImpl
 * @Description TODO
 * @Date: Created in 2020/2/25 16:39
 * @Create By IntelliJ IDEA
 **/

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired(required = false)
    private TypeMapper typeMapper;

    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
