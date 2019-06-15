package com.springboot.richttms.service.movie.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.movie.movieMapper;
import com.springboot.richttms.pojo.movie.Movie;
import com.springboot.richttms.service.movie.movieService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheManager = "cacheManager")
public class movieServiceimpl implements movieService {
    @Autowired
    movieMapper movieMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Override
    public int save(String json) {
        int result=0;
        if(StringUtils.isNotEmpty(json)){
            Movie movie=JSONObject.parseObject(json, Movie.class);
           result= movieMapper.save(movie);
        }
        return result;
    }

    @Override
    @Cacheable(cacheNames = "movie",key="'movie-'+#state")
    public List<Movie> query(Integer state) {
        List<Movie>list=null;
        return movieMapper.query(state);
    }

    @Override
    public int update(String json) {
        int result=0;
        if(StringUtils.isNotEmpty(json)){
            Movie movie=JSONObject.parseObject(json, Movie.class);

            result=movieMapper.update(movie);
            stringRedisTemplate.delete("movie:*");
        }
        return result;
    }

    @Override
    public int delete(Integer id) {
        int result=0;
        if(id!=0){
            result=movieMapper.delete(id);
            if(result!=0)
            stringRedisTemplate.delete("movie:*");
        }
        return result;
    }


}
