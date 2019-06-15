package com.springboot.richttms.service.mail.impl;

import com.springboot.richttms.service.mail.mailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class mailServiceimpl implements mailService {

    @Autowired
    public JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String form;


    @Autowired
    StringRedisTemplate stringRedisTemplate;
//    @Test


    public String getCheckCode(String toemail) {
        String checkCode=String.valueOf(new Random().nextInt(899999)+100000);
        String message ="您的注册验证码为："+checkCode+"有效时间为五分钟";
        SimpleMailMessage sendto = new SimpleMailMessage();
        sendto.setFrom(form);
        System.out.println(toemail);
        sendto.setTo(toemail);
        sendto.setSubject("验证码");
        sendto.setText(message);
        mailSender.send(sendto);
        String key = "email_" + toemail;
        if(stringRedisTemplate.hasKey(key)){
            stringRedisTemplate.delete(key);
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(key,toemail,5000,TimeUnit.SECONDS);
            System.out.println("发送成功");
            return checkCode;
        }
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(key,toemail,5000,TimeUnit.SECONDS);
        System.out.println("发送成功");
        return checkCode;

    }
}
