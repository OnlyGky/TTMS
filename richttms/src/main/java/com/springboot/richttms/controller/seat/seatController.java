package com.springboot.richttms.controller.seat;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.pojo.seat.Seat;
import com.springboot.richttms.service.seat.seatService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seatController")
public class seatController {
    @Autowired
    seatService seatService;



//    @PostMapping("/seat")
//    public ResponseEntity<Void> save(Integer scheduleId,Integer hId){
//        if(seatService.save(scheduleId,hId)!=0){
//
//        }
//            return ResponseEntity.ok().build();
//
//    }
//
//    /**
//     *
//     * @param id
//     * @return
//     */
    @RequestMapping ("/seat")
    @ResponseBody
    public Map<String,List<Seat>> query(Integer scheduleId, Integer hId){
        List<Seat>list=null;
//        System.out.println(scheduleId+" "+hId);
        list=seatService.query(scheduleId,hId);

        System.out.println(list);
        Map map=new HashMap();
        map.put("data",list);
        return map;
    }
//
//    @PutMapping("/seat")
//    public ResponseEntity<Integer> changeSeat(@RequestBody String json){
//        JSONObject jsonObject=JSONObject.parseObject(json);
//        Integer id=jsonObject.getInteger("id");
//        Integer state=jsonObject.getInteger("state");
//        if(seatService.changeState(id,state)){
//            return ResponseEntity.ok(id);
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//    }
//
//    @DeleteMapping("/seat")
//    public ResponseEntity<Void> delete(@RequestParam Integer seatId){
//        if(seatService.delete(seatId))
//            return ResponseEntity.ok().build();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }

}
