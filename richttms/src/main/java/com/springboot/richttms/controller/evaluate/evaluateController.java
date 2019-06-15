package com.springboot.richttms.controller.evaluate;

import com.springboot.richttms.pojo.evaluate.Evaluate;
import com.springboot.richttms.service.evaluate.evaluateService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/evaluateController")
@Controller
public class evaluateController {
    @Autowired
    evaluateService evaluateService;

    @RequestMapping("/evaluate")
    public ResponseEntity<Void> save(@RequestBody String json){
        if(evaluateService.save(json)!=0){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @DeleteMapping("/evaluate")
    public ResponseEntity<Void> delete(@RequestParam Integer id){
        if(evaluateService.delete(id)!=0)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 根据顾客Id获得所有评论
     * @param cId
     * @return
     */
    @GetMapping("/evaluatec/{cId}")
    public ResponseEntity<List<Evaluate>> queryBycId(@PathVariable("cId") Integer cId){
        List<Evaluate>list=null;
        list=evaluateService.queryBycId(cId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/evaluatem/{mId}")
    public ResponseEntity<List<Evaluate>> queryBymId(@PathVariable("mId") Integer cId){
        List<Evaluate>list=null;
        list=evaluateService.queryBymId(cId);
        return ResponseEntity.ok(list);
    }
}
