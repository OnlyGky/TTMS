package com.springboot.richttms.controller.movie;

import com.springboot.richttms.pojo.movie.Movie;
import com.springboot.richttms.service.movie.movieService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/movieController")
public class movieController {
    @Autowired
    movieService movieService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    /**
     * 保存所有影片
     * @param json
     * @return
     */
    @PostMapping ("/movie")
    public ResponseEntity<Void> save(@RequestBody String json){
        if(movieService.save(json)!=0){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 查找正在上映电影
     */
    @GetMapping("/movie/{state}")
    public ResponseEntity<List<Movie>> query(@PathVariable("state") Integer state){
        List<Movie> list=null;
        list=movieService.query(state);
        return ResponseEntity.ok(list);
    }




    /**
     * 修改电影状态
     * @param json
     * @return
     */
    @PutMapping("/movie")
    public ResponseEntity<Void> update(@RequestBody String json){
        if(movieService.update(json)!=0) {

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     *
     */

     @DeleteMapping("/movie")
    public ResponseEntity<Void> delete(@RequestParam Integer id){
         if(movieService.delete(id)!=0)
             return ResponseEntity.ok().build();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }



}
