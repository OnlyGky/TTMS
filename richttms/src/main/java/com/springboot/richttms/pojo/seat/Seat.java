package com.springboot.richttms.pojo.seat;

public class Seat {
    private Integer seatId;
    private Integer seatRow;
    private Integer seatColumn;
//    private Integer seatState;
    private Integer hId;
    private Integer scheduleId;

//    public Seat(Integer seatId, Integer seatRow, Integer seatColumn, Integer seatState, Integer hId) {
//        this.seatId = seatId;
//        this.seatRow = seatRow;
//        this.seatColumn = seatColumn;
//        this.seatState = seatState;
//        this.hId = hId;
//    }


    public Seat(Integer seatId, Integer seatRow, Integer seatColumn, Integer hId, Integer scheduleId) {
        this.seatId = seatId;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.hId = hId;
        this.scheduleId = scheduleId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public Seat(Integer seatRow, Integer seatColumn) {
        this.seatRow = seatRow;
        this.seatColumn=seatColumn;
    }

//    public Seat(Integer seatId, Integer seatRow, Integer seatColumn, Integer seatState) {
//        this.seatId = seatId;
//        this.seatRow = seatRow;
//        this.seatColumn = seatColumn;
//        this.seatState = seatState;
//    }

    public Seat() {
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

//    public Integer getSeatId() {
//        return seatId;
//    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

//    public Integer getScheduleId() {
//        return scheduleId;
//    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
}
