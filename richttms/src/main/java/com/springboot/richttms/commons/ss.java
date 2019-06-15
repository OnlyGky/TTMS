package com.springboot.richttms.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class ss {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void saveRedis(){
        stringRedisTemplate.opsForValue().set("a","test");
    }

    //获取

    public String getRedis(){
        return stringRedisTemplate.opsForValue().get("a");
    }



    public static void main(String[] args) {
       ss s= new ss();
       s.saveRedis();
        System.out.println(s.getRedis());

    }
}
