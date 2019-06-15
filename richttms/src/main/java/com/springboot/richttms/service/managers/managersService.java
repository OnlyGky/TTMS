package com.springboot.richttms.service.managers;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface managersService {


    int registered(JSONObject jsonObject);

    Map<String, Integer> login(String json);
}
