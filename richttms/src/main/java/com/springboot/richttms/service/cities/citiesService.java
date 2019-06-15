package com.springboot.richttms.service.cities;

import com.springboot.richttms.pojo.cities.City;

import java.util.List;

public interface citiesService {

    int save(String json);

    List<City> query();
}
