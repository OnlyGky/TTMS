package com.springboot.richttms.pojo.order;

import java.util.List;

public class Order {
    private Integer orderId;
    private Integer customerId;
    private Double orderFee;
    private Integer orderState;
    private Integer scheduleId;
    private Integer cId;
    private Integer hId;
    private List<orderDetail>list;

    public Order(Integer orderId, Integer customerId, Double orderFee, Integer orderState, Integer scheduleId, Integer cId, Integer hId, List<orderDetail> list) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderFee = orderFee;
        this.orderState = orderState;
        this.scheduleId = scheduleId;
        this.cId = cId;
        this.hId = hId;
        this.list = list;
    }

    public Order() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(Double orderFee) {
        this.orderFee = orderFee;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public List<orderDetail> getList() {
        return list;
    }

    public void setList(List<orderDetail> list) {
        this.list = list;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderFee=" + orderFee +
                ", orderState=" + orderState +
                ", scheduleId=" + scheduleId +
                ", cId=" + cId +
                ", hId=" + hId +
                ", list=" + list +
                '}';
    }
}
