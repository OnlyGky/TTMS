package com.springboot.richttms.mapper.customer;

import com.springboot.richttms.pojo.customers.Customers;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface customersMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into customers values(#{id},#{name},#{password},#{image},#{email})")
    public int insert(Customers customers);

    @Select("select id from customers where email=#{email} and password=#{password}")
    Integer checkpassword(@Param("email") String email, @Param("password") String password);

    @Select("select * from customers where id=#{id}")
    Customers query(Integer id);
//    @Update("update customers set name=#{name},password=#{password}")
    int update(Customers customers);
}
