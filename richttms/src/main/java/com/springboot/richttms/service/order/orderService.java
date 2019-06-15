package com.springboot.richttms.service.order;

import com.springboot.richttms.pojo.order.Order;
import com.springboot.richttms.pojo.order.finalOrder;

import java.util.List;

public interface orderService {

    int save(String json);

    List<finalOrder> queryBycId(Integer customerId);

    List<Order> queryBysId(Integer sId);

    List<Order> query();

    int update(String json);

    int updateState(Integer id, Integer state);

    int delete(Integer id);
}
