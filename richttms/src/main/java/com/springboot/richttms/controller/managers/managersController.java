package com.springboot.richttms.controller.managers;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.service.managers.managersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/managersController")
public class managersController {
    @Autowired
    managersService managersService;

    @PostMapping(value = "/registered")
    public ResponseEntity<String> registered(@RequestBody String json, HttpServletRequest request){
        JSONObject jsonObject=JSONObject.parseObject(json);
        String session=(String) request.getSession().getAttribute("checkCode");
        String checkcode=jsonObject.getString("checkcode");
        System.out.println(session+" "+checkcode);
        if(!session.equals(checkcode)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("验证码错误");
        }

        if(managersService.registered(jsonObject)!=0)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 登录
     * @param json
     * @param request
     * @return
     */
    @PostMapping(value="/managers")
    public ResponseEntity<Map<String,Integer>> login(@RequestBody String json, HttpServletRequest request){
        System.out.println("传参成功"+json);
        Map<String,Integer> map=null;
        JSONObject jsonObject=JSONObject.parseObject(json);
        String RANDOMVALIDATECODEKEY=(String) request.getSession().getAttribute("RANDOMVALIDATECODEKEY");
        String code=jsonObject.getString("code");
        if(!code.equals(RANDOMVALIDATECODEKEY)){
            Map<String,Integer> map1=new HashMap();
            map1.put("验证码错误",null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map1);
        }


        map=managersService.login(json);


        if(map!=null){
            for(String temp:map.keySet()){
                Integer value=(Integer) map.get(temp);
                HttpSession session=request.getSession();
                session.setAttribute("token",temp);
            }
        }
        return ResponseEntity.ok(map);
    }




}
