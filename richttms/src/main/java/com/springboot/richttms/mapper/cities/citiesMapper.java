package com.springboot.richttms.mapper.cities;

import com.springboot.richttms.pojo.cities.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface citiesMapper {


    @Insert("insert into cities values(#{id},#{name},#{pname})")
    int save(City city);

    @Select("select * from cities")
    List<City> query();
}
