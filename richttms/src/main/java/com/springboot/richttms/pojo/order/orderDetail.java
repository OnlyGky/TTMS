package com.springboot.richttms.pojo.order;

public class orderDetail {
    private Integer oId;
    private Integer seatRow;
    private Integer seatColumn;
    private Integer orderDetailId;

    public orderDetail() {

    }

//    public orderDetail(Integer oId, Integer seatRow, Integer seatColumn) {
//        this.oId = oId;
//        this.seatRow = seatRow;
//        this.seatColumn = seatColumn;
//    }

    public orderDetail(Integer oId, Integer seatRow, Integer seatColumn, Integer orderDetailId) {
        this.oId = oId;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    public Integer getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(Integer seatColumn) {
        this.seatColumn = seatColumn;
    }

    @Override
    public String toString() {
        return "orderDetail{" +
                "oId=" + oId +
                ", seatRow=" + seatRow +
                ", seatColumn=" + seatColumn +
                '}';
    }
}
