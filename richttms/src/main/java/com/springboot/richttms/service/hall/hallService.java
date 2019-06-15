package com.springboot.richttms.service.hall;

import com.springboot.richttms.pojo.hall.Hall;

import java.util.List;

public interface hallService {
    int save(String json);

    int update(String json);

    List<Hall> query(Integer id);

    void insert();
}
