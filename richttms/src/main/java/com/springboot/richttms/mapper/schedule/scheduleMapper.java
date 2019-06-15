package com.springboot.richttms.mapper.schedule;

import com.springboot.richttms.pojo.schedule.Schedule;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface scheduleMapper {
//    private Integer scheduleId;
//    private Integer mId;
//    private Integer hId;
//    private Double schedulefee;
//    private String schedulebegintime;
    @Insert("insert into ttms_schedule values(#{scheduleId},#{mId},#{hId},#{schedulefee},#{schedulebegintime})")
    int save(Schedule schedule);

    @Select("select * from ttms_schedule")
    List<Schedule> query();

    @Delete("delete from ttms_schedule where h_id=#{id}")
    int deleteByHallId(Integer id);

    @Select("select * from ttms_schedule where m_id=#{mId} ")
    List<Schedule> queryBymId(Integer mId);

    @Select("select distinct m_id from ttms_schedule where c_id=#{cId}")
    List<Integer> queryBycId(Integer cId);

    @Update("update ttms_schedule set m_id=#{mId},h_id=#{hId},schedule_fee =#{schedulefee},schedule_begintime=#{schedulebegintime} where schedule_id =#{scheduleId}")
    int update(Schedule schedule);


    /**
     *
     * @param cId
     * @param mId
     * @return
     */
    @Select("select * from ttms_schedule where c_id=#{cId} and m_id=#{mId} order by schedule_begintime")
    List<Schedule> queryMovieSchedulr(@Param("cId") Integer cId, @Param("mId") Integer mId);


    @Select("select * from ttms_schedule where schedule_id=#{scheduleId}")
    Schedule queryById(Integer scheduleId);
}
