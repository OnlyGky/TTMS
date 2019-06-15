package com.springboot.richttms.mapper.hall;

import com.springboot.richttms.pojo.hall.Hall;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
@Repository
public interface hallMapper {

//    private Integer HallId;
//    private  Integer CId;
//    private Integer hallSeats;
//    private String hallDescription;

    @Insert("insert into ttms_hall values(#{HallId},#{CId},#{hallDescription})")
    int save(Hall hall);

    @Update("update ttms_hall set c_Id=#{CId},hall_Seats=#{hallSeats},hall_Description=#{hallDescription} where hall_Id=#{HallId}")
    int update(Hall hall);

    @Select("select * from ttms_hall where hall_Id=#{HallId}")
    List<Hall> query(Integer id);
}
