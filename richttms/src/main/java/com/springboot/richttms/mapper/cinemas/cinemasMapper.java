package com.springboot.richttms.mapper.cinemas;

import com.springboot.richttms.pojo.cinemas.Cinemas;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Mapper
public interface cinemasMapper {
    @Insert("insert into cinemas values(#{cinemaId},#{cinemaName},#{cityId})")
    int save(Cinemas cinemas);

    @Select("select * from cinemas")
    List<Cinemas> query();

    @Select("select * from cinemas where cinema_id=#{id}")
    Cinemas queryById(Integer id);
//    Integer cinemaId, String cinemaName, String cinemaCity, String cinemaCommuity, String cinemaAddress
    @Update("update cinemas set cinema_name = #{cinemaName},city_id=#{cityId} where cinema_id = #{cinemaId}")
    int update(Cinemas cinemas);

    @Select("select * from cinemas where city_id=#{cityId}")
    List<Cinemas> querybyCity(Integer id);

    @Select("select cinema_name from cinemas where cinema_id=#{cId}")
    String queryname(Integer cId);
}
