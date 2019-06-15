package com.springboot.richttms.controller.order;

import com.springboot.richttms.pojo.data.Data;
import com.springboot.richttms.pojo.order.Order;
import com.springboot.richttms.pojo.order.finalOrder;
import com.springboot.richttms.pojo.order.orderDetail;
import com.springboot.richttms.service.order.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orderController")
public class orderController {
    @Autowired
    orderService orderService;

    /**
     * 提交订单
     * @param
     * @return
     */
    @RequestMapping("/order")
    public ResponseEntity<Integer> save(HttpServletRequest req) throws IOException {

        BufferedReader reader = req.getReader();
        String input = null;
        StringBuffer requestBody = new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        System.out.println("成功"+requestBody.toString());
//        String json=request.getParameter("json");
//        String json=null;
//        System.out.println(json);
        int result=0;
        if(requestBody.toString()!=null){
            System.out.println(requestBody.toString());
            result=orderService.save(requestBody.toString());
//        System.out.println(model);
//        if(orderService.save(order)!=0)
//            return ResponseEntity.ok().build();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    if(result!=0){
        return ResponseEntity.ok().body(result);
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
    }




    /**
     * 根据顾客Id查询
     * @param customerId
     * @return
     */
    @GetMapping("/order/{customerId}")
    @ResponseBody
    public Data  queryBycId(@PathVariable(value = "customerId")Integer customerId){
        List<finalOrder>list=null;
        list=orderService.queryBycId(customerId);

        Map<String,List<finalOrder>>map=new HashMap<>();
        map.put("movie",list);
        return new Data(map);
    }


    /**
     * 根据安排Id查询所有Id
     * @param sId
     * @return
     */
    @GetMapping("/schedule/{sId}")
    public ResponseEntity<List<Order>> queryBysId(@PathVariable("sId") Integer sId){
        List<Order>list=null;
        list=orderService.queryBysId(sId);
        return ResponseEntity.ok(list);
    }

    /**
     * 查询所有订单
     * @return
     */

    @GetMapping("/allorder")
    public ResponseEntity<List<Order>> query(){
        List<Order>list=null;
        list=orderService.query();
        return ResponseEntity.ok(list);
    }

    /**
     * 更新订单
     * @param json
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody String json){
        if(orderService.update(json)!=0)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 更改订单状态
     */

    @PutMapping("/updateState")
    public ResponseEntity<Void> updateState(Integer id,Integer state){
        if(orderService.updateState(id,state)!=0)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/order")
    public ResponseEntity<Void> delete(@RequestParam Integer id){
        if(orderService.delete(id)!=0){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


}
