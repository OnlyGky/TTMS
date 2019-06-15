package com.springboot.richttms.service.evaluate;

import com.springboot.richttms.pojo.evaluate.Evaluate;

import java.util.List;

public interface evaluateService {
    int save(String json);

    int delete(Integer id);

    List<Evaluate> queryBycId(Integer cId);

    List<Evaluate> queryBymId(Integer cId);
}
