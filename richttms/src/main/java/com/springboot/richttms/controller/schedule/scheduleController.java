package com.springboot.richttms.controller.schedule;

//import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.richttms.pojo.data.Data;
import com.springboot.richttms.pojo.movie.Movie;
import com.springboot.richttms.pojo.schedule.Schedule;
import com.springboot.richttms.service.schedule.scheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/scheduleController")
public class scheduleController {

    @Autowired
    scheduleService scheduleService;


    /**
     * 传入影院Id查出该影院演出的电影
     */

    @GetMapping("/schedule/{cId}")
    @ResponseBody
    public Data  queryBycId(@PathVariable("cId") Integer cId){
        List<Movie>list=scheduleService.queryBycId(cId);
        System.out.println("影院Id"+cId);
//        System.out.println(list);
        Map map=new HashMap();
        map.put("movie",list);
        Data data=new Data(map);
        return data;
    }


    /**
     *
     * 根据电影Id和影院Id查询安排
     * @param
     * @return
     */
    @RequestMapping ("/schedule")
    public ResponseEntity<Map<String,List<Schedule>>> queryMovieSchedulr(Integer cId, Integer mId){
        List<Schedule>list=null;
        list=scheduleService.queryMovieSchedulr(cId,mId);
        System.out.println(list);
        Map<String,List<Schedule>> map=new HashMap();
        map.put("data",list);
        return ResponseEntity.ok(map);
    }

//    @PostMapping("/schedule")
//    public ResponseEntity<Void> save(@RequestBody String json){
//       if(scheduleService.save(json)!=0){
//           return ResponseEntity.ok().build();
//       }
//       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }


//    @GetMapping("/schedule")
//    public ResponseEntity<List<Schedule>>query(){
//        List<Schedule>list=scheduleService.query();
//        return ResponseEntity.ok(list);
//    }





    /**
     * 传入影厅Id删除
     * @param id
     * @return
     */
//    @DeleteMapping("/schedule")
//    public ResponseEntity<Void> deleteByhallId(@RequestParam Integer id){
//        if(scheduleService.deleteByHallId(id)!=0){
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }

    /**
     * 传入电影ID
     */

//    @GetMapping("/schedulemannger/{mId}")
//    public ResponseEntity<List<Schedule>> queryBymId(@PathVariable("mId") Integer mId){
//        List<Schedule>list=scheduleService.queryBymId(mId);
//        return ResponseEntity.ok(list);
//    }


//    @PutMapping("/schedule")
//    public ResponseEntity<Void> update(@RequestBody String json){
//        if(scheduleService.update(json)!=0){
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }





}
