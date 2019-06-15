package com.springboot.richttms.service.cimemas;

import com.springboot.richttms.pojo.cinemas.Cinemas;
import com.springboot.richttms.pojo.customers.Customers;

import java.util.List;

public interface cinemasService {
    int save(Cinemas cinemas);

    List<Cinemas> query();

    Cinemas queryById(Integer id);

//    int delete(Integer id);

    Cinemas update(String json);

    List<Cinemas> querybyCity(Integer id);
}
