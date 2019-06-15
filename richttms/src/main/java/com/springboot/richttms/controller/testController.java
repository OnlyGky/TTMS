package com.springboot.richttms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //添加
    @GetMapping(value="/redisAdd")
    public ResponseEntity<String> saveRedis(){
        stringRedisTemplate.opsForValue().set("a","test2");
        return null;
    }

    //获取value

    @GetMapping(value="/redisGet")
    public ResponseEntity<String> getRedis(){
        return ResponseEntity.ok(stringRedisTemplate.opsForValue().get("a"));
    }
}
