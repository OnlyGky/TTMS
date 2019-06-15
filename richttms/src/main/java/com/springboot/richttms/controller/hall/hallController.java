package com.springboot.richttms.controller.hall;

import com.springboot.richttms.pojo.hall.Hall;
import com.springboot.richttms.service.hall.hallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hallController")
public class hallController {


    @Autowired
    hallService hallService;

    @PostMapping("/hall")
    public ResponseEntity<Void> save(@RequestBody String json){

        hallService.insert();
//       if( hallService.save(json)!=0){

           return ResponseEntity.ok().build();

//       }
//       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/hall")
    public ResponseEntity<Void> update(@RequestBody String json){
        if(hallService.update(json)!=0){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/hall/{id}")
    public ResponseEntity<List<Hall>> query(@PathVariable("id") Integer id){
        List<Hall> halls=null;
        if(id!=null){
            halls=hallService.query(id);
            return ResponseEntity.ok(halls);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
