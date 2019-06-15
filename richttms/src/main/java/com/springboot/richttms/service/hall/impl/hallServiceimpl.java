package com.springboot.richttms.service.hall.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.cinemas.cinemasMapper;
import com.springboot.richttms.mapper.hall.hallMapper;
import com.springboot.richttms.pojo.cinemas.Cinemas;
import com.springboot.richttms.pojo.hall.Hall;
import com.springboot.richttms.service.hall.hallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class hallServiceimpl implements hallService {
    @Autowired
    hallMapper hallMapper;

    @Autowired
    com.springboot.richttms.mapper.cinemas.cinemasMapper cinemasMapper;
    @Override
    public int save(String json) {

        Hall hall=JSONObject.parseObject(json,Hall.class);
        int result=0;
        if(hall!=null)
            result= hallMapper.save(hall);
        return result;
    }

    @Override
    public int update(String json) {
        Hall hall=JSONObject.parseObject(json,Hall.class);
        int result=0;
        if(hall!=null)
            result= hallMapper.update(hall);
        return result;
    }

    @Override
    public List<Hall> query(Integer id) {
        List<Hall> halls=null;
       halls= hallMapper.query(id);
       return halls;
    }

    @Override
    public void insert() {
        List<Cinemas>list=cinemasMapper.query();
        for(Cinemas cinemas:list){
            for(int i=0;i<4;i++){
                hallMapper.save(new Hall(null,cinemas.getCinemaId(),"激光MAX厅"));
            }
        }
    }
}
