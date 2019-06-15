package com.springboot.richttms.service.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.managers.managersMapper;
import com.springboot.richttms.pojo.managers.Managers;
import com.springboot.richttms.service.managers.managersService;
import com.springboot.richttms.utils.MD5Utils;
import com.springboot.richttms.utils.jwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class managersServiceimpl implements managersService {
    @Autowired
    managersMapper managersMapper;

    @Override
    public int registered(JSONObject jsonObject) {
        Managers managers=new Managers();
        managers.setEmail(jsonObject.getString("email"));
        managers.setImage("/image/Cache_-338ec6dfe398343d..jpg");
        managers.setPassword(MD5Utils.md5(jsonObject.getString("password")));
        managers.setName(jsonObject.getString("name"));
        managers.setRole(Integer.valueOf(jsonObject.getString("role")));
        managers.setRole(Integer.valueOf(jsonObject.getString("classId")));
        int result=0;
        result=managersMapper.insert(managers);

        return result;
    }

    @Override
    public Map<String, Integer> login(String json) {
        String token=null;
        Map<String,Integer> map=new HashMap<>();
        JSONObject jsonObject=JSONObject.parseObject(json);
        String email=jsonObject.getString("email");
        String password=jsonObject.getString("password");
        password= MD5Utils.md5(password);
        int result=0;
        if(!StringUtils.isEmpty(email)||!StringUtils.isEmpty(password)){
            result=managersMapper.checkpassword(email,password);
            token = jwtUtil.createToken(email,password);
        }
        map.put(token,result);
        return map;
    }
}
