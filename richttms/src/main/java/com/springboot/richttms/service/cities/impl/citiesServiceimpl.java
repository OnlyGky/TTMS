package com.springboot.richttms.service.cities.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.cities.citiesMapper;
import com.springboot.richttms.pojo.cities.City;
import com.springboot.richttms.service.cities.citiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class citiesServiceimpl implements citiesService {
    @Autowired
    citiesMapper citiesMapper;
    @Override
    public int save(String json) {
        City city= JSONObject.parseObject(json,City.class);
        return citiesMapper.save(city);
    }

    @Override
    public List<City> query() {
        return citiesMapper.query();
    }
}
