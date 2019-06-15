package com.springboot.richttms.controller.cities;

import com.springboot.richttms.pojo.cities.City;
import com.springboot.richttms.service.cities.citiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller("/citiesController")
public class citiesController {
    @Autowired
    citiesService citiesServcie;

    @PostMapping("/city")
    public ResponseEntity<Void> save(@RequestBody String json){
        if(citiesServcie.save(json)!=0){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/city")
    public ResponseEntity<List<City>> query(){
        List<City>list= citiesServcie.query();
        return ResponseEntity.ok().body(list);
    }
}
