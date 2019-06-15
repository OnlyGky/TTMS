package com.springboot.richttms.controller.customers;

import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.Session;
import com.springboot.richttms.pojo.customers.Customers;
import com.springboot.richttms.pojo.result.Result;
import com.springboot.richttms.service.customers.customersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/CustomersController")
public class CustomersController {

    @Autowired
    customersService customersservice;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     *登录
     * @param
     * @return
     */
    @PostMapping(value="/customer")
    public ResponseEntity<Map<String,String>> login(Customers customers, HttpServletRequest request){
//        System.out.println("传参成功"+json);
        Map<String,String> map=null;
//        JSONObject jsonObject=JSONObject.parseObject(json);
//        String RANDOMVALIDATECODEKEY=(String) request.getSession().getAttribute("RANDOMVALIDATECODEKEY");
        String code=request.getParameter("code");
        if(code!=null&&stringRedisTemplate.hasKey("code_"+code)){
            stringRedisTemplate.delete("code_"+code);
            map=customersservice.login(customers);
            return ResponseEntity.ok(map);
        }else{
            map=new HashMap<>();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }


//        if(!code.equals(RANDOMVALIDATECODEKEY)){
//            Map<String,String> map1=new HashMap();
//            map1.put("errorcode","200");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map1);
//        }
//        System.out.println(code+" "+RANDOMVALIDATECODEKEY);

//        if(map!=null){
//            String temp=(String) map.get("token");
//                HttpSession session=request.getSession();
//                session.setAttribute("token",temp);
//        }

    }

    /**
     * 注册
     * @param
     * @return
     */
    @PostMapping(value = "/registered")
    @ResponseBody
    public Result registered(Customers customers){
        System.out.println("访问成");
        String session="";
        System.out.println(customers.toString());
        if(stringRedisTemplate.hasKey("email_"+customers.getEmail())){
//            System.out.println("123");
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            session+=operations.get("email_"+customers.getEmail());
//            System.out.println("成功"+session);
        }else{
            return new Result("nocodeerror",500);
        }

//        String checkcode=(String) request.getParameter("checkcode");
        String checkcode=String.valueOf(customers.getCheckcode());
        System.out.println(session+" "+checkcode);
//        if(!session.equals(checkcode)){
//            return new Result("checkcodeerror",500);
//
//        }
        System.out.println("访问成功"+customers.toString());
        if(customersservice.registered(customers)!=0)
            return new Result("成功",200);
        return new Result("验证码错误",500);
    }

    /**
     * 检查token
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/check")
    public ResponseEntity<Integer> check(HttpServletRequest request, HttpServletResponse response){
        String token=(String) request.getSession().getAttribute("token");
        System.out.println("token"+token);
        if(token!=null){
            int result=customersservice.check(token);
            if(result!=0){
                return ResponseEntity.ok(result);
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping("/query/{id}")
    public ResponseEntity<Customers> query(@PathVariable("id") Integer json){
       if(json!=null){
           Customers customers=customersservice.query(json);
           return ResponseEntity.ok(customers);
       }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

//    @PutMapping("/customer")
//    public ResponseEntity<Void> update(@RequestBody String json){
//        if(!StringUtils.isEmpty(json)){
//            if(customersservice.update(json)!=0){

//                return ResponseEntity.ok(null);
//            }
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//    }


}
