package com.springboot.richttms.service.order.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.richttms.mapper.cinemas.cinemasMapper;
import com.springboot.richttms.mapper.movie.movieMapper;
import com.springboot.richttms.mapper.order.orderMapper;
import com.springboot.richttms.mapper.schedule.scheduleMapper;
import com.springboot.richttms.mapper.seat.seatMapper;
import com.springboot.richttms.pojo.order.Order;
import com.springboot.richttms.pojo.order.finalOrder;
import com.springboot.richttms.pojo.order.orderDetail;
import com.springboot.richttms.pojo.schedule.Schedule;
import com.springboot.richttms.pojo.seat.Seat;
import com.springboot.richttms.service.order.orderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class orderServiceimpl implements orderService {
    @Autowired
    orderMapper orderMapper;
    @Autowired
    seatMapper seatMapper;
    @Autowired
    cinemasMapper cinemasMapper;
    @Autowired
    com.springboot.richttms.mapper.schedule.scheduleMapper scheduleMapper;
    @Autowired
    movieMapper movieMapper;
//    @Override
    public int save(String json) {
        int result=0;

        JSONObject jsonObject=JSONObject.parseObject(json);
        String re= jsonObject.getString("json");
        System.out.println("shuju"+jsonObject);
//        System.out.println("成功"+jsonObject.getString("orderFee"));
        Order order=JSONObject.parseObject(re,Order.class);
        System.out.println("解析"+order.toString());
//        Order order=new Order();
        order.setOrderId(null);
//
//        Order order=new Order();
        /**
         * 查找该影院中已买的座位
         */

//        List<Seat>seats=seatMapper.querybysId(order.getScheduleId());
//
//        for(Seat seat:seats){
//            for(orderDetail orderDetail:order.getList()){
//                Integer seatRow=orderDetail.getSeatRow();
//                Integer seatColum=orderDetail.getSeatColumn();
//                Integer schedule=order.getScheduleId();
//                if(seat.getSeatRow()==seatRow&&seat.getSeatColumn()==seatColum&&schedule==seat.getScheduleId()){
//                    return 0;
//                }
//            }
//        }

        result= orderMapper.save(order);
        Integer qq=order.getOrderId();
        List<orderDetail>list=new ArrayList<>();
        list=order.getList();
        if(result!=0){
            if(order.getList()!=null){
                for(orderDetail aa:list){
//                    System.out.println("成功"+order.toString());
//                    System.out.println(order.getOrderId());
                    aa.setoId(qq);
                    System.out.println("细节"+aa.toString());

                    seatMapper.save(new Seat(null,aa.getSeatRow(),aa.getSeatColumn(),order.gethId(),order.getScheduleId()));
                    orderMapper.saveDetail(aa);
                }
            }
        }
        return result;
    }


    @Override
    public List<finalOrder> queryBycId(Integer customerId) {
        List<Order>list=null;

        list=orderMapper.queryBycId(customerId);
        List<finalOrder>finalOrders=new ArrayList<>();
        for(Order order:list){
            System.out.println("订单"+order.toString());
            List<orderDetail>orderDetails=null;
            finalOrder finalOrder=new finalOrder();
            //查询出电影院名
            String cinemaName=cinemasMapper.queryname(order.getcId());
            Schedule schedule=scheduleMapper.queryById(order.getScheduleId());
            System.out.println("电影名"+cinemaName);
            String hall=((schedule.gethId()+1)%4)+"号激光MAX厅";
            String movieName=movieMapper.queryName(schedule.getmId());
            finalOrder.setCinemaName(cinemaName);
            finalOrder.setHall(hall);
            finalOrder.setStarttime(schedule.getSchedulebegintime());
            finalOrder.setEndtime(schedule.getScheduleendtime());
           finalOrder.setMovieName(movieName);
            orderDetails=orderMapper.queryDetailByoId(order.getOrderId());
            order.setList(orderDetails);
            finalOrder.setSeats(orderDetails);
            finalOrders.add(finalOrder);
        }
         return finalOrders;
    }

    @Override
    public List<Order> queryBysId(Integer sId) {
        List<Order>list=null;
        list=orderMapper.queryBysId(sId);
        for(Order order:list){
            List<orderDetail>orderDetails=null;
            orderDetails=orderMapper.queryDetailByoId(order.getOrderId());
            order.setList(orderDetails);
        }
        return list;
    }

    @Override
    public List<Order> query() {
        List<Order>list=null;
        list=orderMapper.query();
        for(Order order:list){
            List<orderDetail>orderDetails=null;
//            orderDetails=orderMapper.queryDetailByoId(order.getsId());
//            order.setList(orderDetails);
        }
        return list;
    }

    @Override
    public int update(String json) {

        int result=0;
        if(StringUtils.isNotEmpty(json)){
            Order order= JSONObject.parseObject(json,Order.class);
            System.out.println(order.toString());
//            if(orderMapper.update(order.getOrderId(),order.getCustomerId(),order.getsId(),order.getOrderFee(),order.getBuyDate(),order.getOrderState())!=0){
//                if(order.getList()!=null){
//                    System.out.println("更新成功");
//                    for(orderDetail orderDetail:order.getList()){
//                        orderMapper.updateDetail(orderDetail);
//                    }
//
//                }
//            }
        }
        return result;

    }

    @Override
    public int updateState(Integer id, Integer state) {
        System.out.println(id+" "+state);
        return orderMapper.updateState(id,state);
    }

    @Override
    public int delete(Integer id) {
        Order order=orderMapper.queryById(id);
        List<orderDetail>list=null;
        list=orderMapper.queryDetailByoId(order.getOrderId());
        for(orderDetail orderDetail:list){
            orderMapper.deleteDetailByid(Integer.valueOf(orderDetail.getoId()));
        }
        int result=orderMapper.delete(order.getOrderId());
        return result;

    }
}

