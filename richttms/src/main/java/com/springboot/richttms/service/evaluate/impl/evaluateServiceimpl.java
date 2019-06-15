package com.springboot.richttms.service.evaluate.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.evaluate.evaluateMapper;
import com.springboot.richttms.pojo.evaluate.Evaluate;
import com.springboot.richttms.service.evaluate.evaluateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class evaluateServiceimpl implements evaluateService {

    @Autowired
    evaluateMapper evaluateMapper;

    @Override
    public int save(String json) {
        int result=0;
        if(StringUtils.isNotEmpty(json)){
            Evaluate movie= JSONObject.parseObject(json, Evaluate.class);
            result= evaluateMapper.save(movie);
        }
        return result;
    }

    @Override
    public int delete(Integer id) {
        if(id!=null)
            return evaluateMapper.delete(id);
        return 0;
    }

    @Override
    public List<Evaluate> queryBycId(Integer cId) {
        if(cId!=null)
            return evaluateMapper.queryBycId(cId);
        return null;
    }

    @Override
    public List<Evaluate> queryBymId(Integer cId) {
        if(cId!=null)
            return evaluateMapper.queryBymId(cId);
        return null;
    }


}
