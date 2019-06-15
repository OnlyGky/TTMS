package com.springboot.richttms.service.customers;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.customer.customersMapper;
import com.springboot.richttms.pojo.customers.Customers;
import com.springboot.richttms.utils.MD5Utils;
import com.springboot.richttms.utils.jwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public interface customersService {
    public Map<String,String> login(Customers customers);
    public int registered(Customers customers) ;
    public int check(String token);
    public Customers query(Integer json) ;
    public int update(String json) ;
}
