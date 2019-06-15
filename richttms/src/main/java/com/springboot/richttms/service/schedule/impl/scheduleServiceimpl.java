package com.springboot.richttms.service.schedule.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.movie.movieMapper;
import com.springboot.richttms.mapper.schedule.scheduleMapper;
import com.springboot.richttms.pojo.movie.Movie;
import com.springboot.richttms.pojo.schedule.Schedule;
import com.springboot.richttms.service.schedule.scheduleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheManager = "cacheManager")
public class scheduleServiceimpl implements scheduleService {


    @Autowired
    scheduleMapper scheduleMapper;
    @Autowired
    movieMapper movieMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //查询出所有的电影
    @Override
    @Cacheable(cacheNames = "schedule",key = "'scheduleh'+#cId")
    public List<Movie> queryBycId(Integer cId) {
        List<Integer>list= scheduleMapper.queryBycId(cId);
//        System.out.println("changdu "+list.size());
//        System.out.println("成功"+list);
        List<Movie> movies=new ArrayList<>();
        for(Integer schedule:list){
            if(schedule!=null){
                Movie movie=movieMapper.queryByID(schedule);
               if(movie!=null){
//                   movie.setImg(movieMapper.queryimg(movie.getMovieId()));
                   movies.add(movie);
//                   System.out.println("123"+movie.toString());
               }
            }
        }

        return movies;
    }


    @Override
    public List<Schedule> queryMovieSchedulr(Integer cId, Integer mId) {
        System.out.println(cId+"asd"+mId);
        List<Schedule>list=scheduleMapper.queryMovieSchedulr(cId,mId);

        return scheduleMapper.queryMovieSchedulr(cId,mId);
    }

    @Override
    public int save(String json) {
        if(StringUtils.isNotEmpty(json)){
            Schedule schedule= JSONObject.parseObject(json,Schedule.class);
           return scheduleMapper.save(schedule);
        }
        return 0;
    }

    @Override
    @Cacheable(cacheNames = "schedule",key = "'schedule'")
    public List<Schedule> query() {
        return scheduleMapper.query();
    }

    @Override
    public int deleteByHallId(Integer id) {
        stringRedisTemplate.delete("schedule:*");
        return scheduleMapper.deleteByHallId(id);
    }

    @Override
    @Cacheable(cacheNames = "schedule",key = "'schedulem'+#mId")
    public List<Schedule> queryBymId(Integer mId) {

        List<Schedule>list= scheduleMapper.queryBymId(mId);
        return list;
    }


    @Override
    public int update(String json) {
        if(StringUtils.isNotEmpty(json)){
            Schedule schedule=JSONObject.parseObject(json,Schedule.class);
            stringRedisTemplate.delete("schedule:*");
            return scheduleMapper.update(schedule);
        }
        return 0;
    }
}
