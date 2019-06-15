package com.springboot.richttms.controller.cinemas;

import com.springboot.richttms.pojo.cinemas.Cinemas;
import com.springboot.richttms.service.cimemas.cinemasService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cinemasController")
public class cinemasController {

    @Autowired
    cinemasService cinemasService;

    @PostMapping("/cinemas")
    public ResponseEntity<Void> save(Cinemas cinemas){
//        if(StringUtils.isNotEmpty(json)){
        cinemasService.save(cinemas);
               return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping("/cinemas")
    public ResponseEntity<List<Cinemas>> query(){
        List<Cinemas> list=null;
        list=cinemasService.query();
        if(list!=null)
            return ResponseEntity.ok(list);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     *查询单个影厅
     * @param id
     * @return
     */
    @GetMapping("/cinemasById/{id}")
    public ResponseEntity<Cinemas> queryById(@PathVariable("id") Integer id){
        Cinemas cinemas=null;
        if(id!=null){
            System.out.println("成功"+id);
            cinemas=cinemasService.queryById(id);
            System.out.println("成功"+id);
            return ResponseEntity.ok(cinemas);
        }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

//    @DeleteMapping("/cimemas")
//    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
//        if(id!=null){
//            int result=cinemasService.delete(id);
//        }
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody String json){
        if(StringUtils.isNotEmpty(json)){
            cinemasService.update(json);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }



    @GetMapping("/city/{id}")
    public ResponseEntity<List<Cinemas>> querybyCity(@PathVariable("id") Integer id){
        List<Cinemas>list=null;
        list=cinemasService.querybyCity(id);
        return null;
    }
}
