package com.springboot.richttms.service.seat.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.seat.seatMapper;
import com.springboot.richttms.pojo.seat.Seat;
import com.springboot.richttms.service.seat.seatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.util.JAXBSource;
import java.util.List;

@Service
public class seatServiceimpl implements seatService {

    @Autowired
    seatMapper seatMapper;
    @Override
    public int save(List<Seat> list) {
//        JSONArray jsonArray=JSONArray.parseArray(json);
        if(list!=null){
            for (Seat seat : list) {
                System.out.println(seat.toString());
                seatMapper.save(seat);
            }
        }


        return 1;
    }

    @Override
    public List<Seat> query(Integer scheduleId,Integer hId) {
        List<Seat>list=null;
        if(hId!=null){
            list=seatMapper.query(hId,scheduleId);
        }
        return list;
    }

    @Override
    public boolean changeState(Integer id,Integer state) {
        if(id!=null){
            return seatMapper.changeState(id,state)!=0;
        }
        return false;
    }

    @Override
    public boolean delete(Integer seatId) {
        if(seatId!=null)
            return seatMapper.delete(seatId)!=0;
        return false;
    }
}
