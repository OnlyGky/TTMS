package com.springboot.richttms.controller.mail;


import com.springboot.richttms.pojo.result.Result;
import com.springboot.richttms.service.mail.mailService;
import com.springboot.richttms.utils.codephotoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Controller
@RequestMapping("/codeController")
public class mailController {
    @Autowired
    mailService mailService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    /**
     * 发送短信验证码
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/getCheckCode")
    @ResponseBody
    public Result getCheckCode(String email, HttpServletRequest request){
        try{
//            System.out.println(toemail);
//        JSONObject jsonObject=JSONObject.parseObject(toemail);
//        toemail=jsonObject.getString("email");
//            System.out.println(jsonObject);
            System.out.println("chenggong"+email);
        String checkCode =mailService.getCheckCode(email);
//            System.out.println("拿到session"+checkCode+" "+toemail);
//        HttpSession session=request.getSession();
//        session.setAttribute("checkCode",checkCode);
//            System.out.println(session.getAttribute("checkCode"));
            System.out.println("发送成功"+checkCode+" "+email);
        return new Result("发送成功",200);
        }catch(Exception e){
            System.out.println("访问失败");
            e.printStackTrace();
            return new Result("发送失败",500);
        }
    }

    /**
     * 生成验证码
     */
    @RequestMapping("/getCheckphoto")
    public ResponseEntity<String> getCheckphoto (HttpServletRequest request, HttpServletResponse response){
        System.out.println("访问成功");
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            codephotoUtil randomValidateCode = new codephotoUtil ();
           String code= randomValidateCode.getRandcode(request, response);//输出验证码图片方法
            ValueOperations<String,String> operations = stringRedisTemplate.opsForValue();
            operations.set("code_"+code,"code",180, TimeUnit.SECONDS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("发送失败");
        }
        System.out.println("访问结束");
        return ResponseEntity.ok().body("发送成功");
    }
}
