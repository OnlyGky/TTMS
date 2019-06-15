package com.springboot.richttms.service.cimemas.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.cinemas.cinemasMapper;
import com.springboot.richttms.pojo.cinemas.Cinemas;
import com.springboot.richttms.pojo.customers.Customers;
import com.springboot.richttms.service.cimemas.cinemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@CacheConfig(cacheManager = "cacheManager")
public class cinemaServiceimpl implements cinemasService {
    @Autowired
   cinemasMapper cinemasMapper;

    @Override
    public int save(Cinemas cinemas) {
//        Cinemas cinemas=null;
//        System.out.println(json);
//        JSONObject jsonObject= JSONObject.parseObject(json);
        System.out.println("成功"+cinemas.toString());
       int result= cinemasMapper.save(cinemas);
       return result;
    }

    @Override
//    @Cacheable(cacheNames = "cinema",key="'Cinema'")
    public List<Cinemas> query() {
        List<Cinemas> list=cinemasMapper.query();
        System.out.println("从数据库中访问");
        return list;
    }

    /**
     * cacheNames/value:指定缓存组件的名字
     *key缓存数据时使用的key，可以用它来指定，默认是使用方法参数的值
     *keyGenerator:key的生成器；可以自己指定key的生成器的组件id
     * cacheManager:指定缓存管理器，或者指定缓存解析器cacheResolver
     * condition:指定符合条件的情况下才缓存
     * unless:否定缓存，当unless指定的条件为true,方法的返回值就不会被缓存；可以获取到结果集进行判断
     * eg:unless="#result==null"
     * sync:是否使用异步模式
     *
     */


    @Override
//    @Cacheable(cacheNames = "cinema",key = "#id",condition = "#id>0",unless = "#result==null")
    public Cinemas queryById(Integer id) {
        System.out.println(123);
        Cinemas cinemas=cinemasMapper.queryById(id);
        System.out.println(456);
        return cinemas;
    }

//    @Override
//    public int delete(Integer id) {
//
//
//    }

    @Override
//    @CachePut(cacheNames = "cinema",key="#result.cinemaId")
    public Cinemas update(String json) {
        Cinemas cinemas= JSON.parseObject(json,Cinemas.class);
        System.out.println(cinemas.toString());
        int result=cinemasMapper.update(cinemas);
        System.out.println(123);
        return cinemas;
    }

    @Override
    public List<Cinemas> querybyCity(Integer id) {

        return cinemasMapper.querybyCity(id);
    }

}
