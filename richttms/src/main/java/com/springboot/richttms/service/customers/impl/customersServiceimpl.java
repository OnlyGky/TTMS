package com.springboot.richttms.service.customers.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.customer.customersMapper;
import com.springboot.richttms.pojo.customers.Customers;
import com.springboot.richttms.service.customers.customersService;
import com.springboot.richttms.utils.MD5Utils;
import com.springboot.richttms.utils.jwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class customersServiceimpl implements customersService {

    @Autowired
    customersMapper customersmapper;
    public Map<String,String> login(Customers customers){
        String token=null;
        Map<String, String> map=new HashMap<>();
//        JSONObject jsonObject=JSONObject.parseObject(json);
//        String email=jsonObject.getString("email");
//        String password=jsonObject.getString("password");
       customers.setPassword( MD5Utils.md5(customers.getPassword()));
        int result=0;
        if(!StringUtils.isEmpty(customers.getEmail())||!StringUtils.isEmpty(customers.getPassword())){
            result=customersmapper.checkpassword(customers.getEmail(),customers.getPassword());
            token = jwtUtil.createToken(customers.getEmail(),customers.getPassword());
        }
        map.put("id",String.valueOf(result));
        map.put("token",customers.getPassword());
        return map;
    }

    public int registered(Customers customers) {

        customers.setImage("/image/Cache_-338ec6dfe398343d..jpg");
        customers.setPassword(MD5Utils.md5(customers.getPassword()));
        int result=0;
        result=customersmapper.insert(customers);
        return result;
    }

    public int check(String token){
        Map<String,String> map=jwtUtil.getAppUID(token);
        int result=0;
        if(map!=null){
            for(String temp:map.keySet()){
                String value=map.get(temp);
                value=MD5Utils.md5(value);
                System.out.println(temp+" "+value);
                result=customersmapper.checkpassword(temp,value);
            }
        }
        return result;
    }


    public Customers query(Integer json) {
        Customers customers=customersmapper.query(json);
        return customers;
    }

    public int update(String json) {
        Customers customers=JSONObject.parseObject(json,Customers.class);
        return customersmapper.update(customers);
    }
}
