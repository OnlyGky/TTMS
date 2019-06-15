package com.springboot.richttms.service.seat;

import com.springboot.richttms.pojo.seat.Seat;

import java.util.List;

public interface seatService {


     int save(List<Seat> list);

    List<Seat> query(Integer schedule,Integer hId);

    boolean changeState(Integer id,Integer state);

    boolean delete(Integer seatId);


//    int save(Integer scheduleId, Integer hId);
}
