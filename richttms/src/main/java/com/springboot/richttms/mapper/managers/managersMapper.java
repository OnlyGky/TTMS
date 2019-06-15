package com.springboot.richttms.mapper.managers;

import com.springboot.richttms.pojo.managers.Managers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface managersMapper {

    @Insert("insert into managers values(#{id},#{name},#{password},#{image},#{email},#{role},#{classId})")
    int insert(Managers managers);

    @Select("select id from managers where email=#{email} and password=#{password}")
    int checkpassword(String email, String password);



}


