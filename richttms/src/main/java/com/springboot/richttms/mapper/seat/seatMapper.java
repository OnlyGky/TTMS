package com.springboot.richttms.mapper.seat;

import com.springboot.richttms.pojo.seat.Seat;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface seatMapper {


    @Insert("insert into ttms_seat values(#{seatId},#{seatRow},#{seatColumn},#{hId},#{scheduleId});")
     int save(Seat seat);

    @Select("select seat_Id,seat_row,seat_column from ttms_seat where hId=#{id} and schedule_id=#{scheduleId}")
    List<Seat> query(@Param("id")Integer id,@Param("scheduleId")Integer scheduleId);

    @Update("update ttms_seat set seat_state=#{state} where seat_Id=#{id}")
    int changeState(@Param("id") Integer id,@Param("state") Integer state);

    @Delete("delete from ttms_seat where seat_Id=#{seatId}")
    int delete(Integer seatId);

    @Select("select * from ttms_seat where schedule_id=#{scheduleId}")
    List<Seat> querybysId(Integer scheduleId);
}
