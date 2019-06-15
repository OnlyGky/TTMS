package com.springboot.richttms.mapper.order;

import com.springboot.richttms.pojo.order.Order;
import com.springboot.richttms.pojo.order.orderDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface orderMapper {

    @Insert("insert into ttms_order values(#{orderId},#{customerId},#{orderFee},#{orderState},#{cId},#{scheduleId})")
    @Options(useGeneratedKeys=true, keyProperty="orderId", keyColumn="order_id")
    int save(Order order);

    @Insert("insert into ttms_orderdetail values(#{orderDetailId},#{oId},#{seatRow},#{seatColumn})")
    void saveDetail(orderDetail orderDetail);

    @Select("select * from ttms_order where customer_id=#{customerId}")
    List<Order> queryBycId(Integer customerId);

    @Select("select * from ttms_order where schedule_id=#{sId}")
    List<Order> queryBysId(Integer sId);

    @Select("select * from ttms_orderdetail where o_id=#{oId}")
    List<orderDetail> queryDetailByoId(Integer oId);
    @Select("select * from ttms_order")
    List<Order> query();

    @Update("update ttms_order set customer_id=#{customerId},s_id=#{sId},order_fee=#{orderFee},order_buydate=#{buyDate},order_state=#{orderState} where order_id=#{orderId}")
    int update(@Param("orderId") Integer getsId, @Param("customerId") Integer customerId, @Param("sId") Integer getsId1, @Param("orderFee") Double orderFee, @Param("buyDate") String buyDate,@Param("orderState") Integer orderState);

    @Update("update ttms_orderdetail set seat_row=#{seatRow},seat_column=#{seatColumn} where o_id=#{oId} and order_detailid=#{orderDetailId}")
    void updateDetail(orderDetail orderDetail);
    @Update("update ttms_order set order_state=#{state} where order_id=#{id} ")
    int updateState(@Param("id") Integer id, @Param("state") Integer state);

    @Select("select * from ttms_order where order_id=#{id}")
    Order queryById(Integer id);
    @Delete("delete from ttms_orderdetail where o_id=#{getoId}")
    void deleteDetailByid(Integer getoId);
    @Delete("delete from ttms_order where order_id=#{order_id}")
    int delete(Integer orderId);
}
