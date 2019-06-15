package com.springboot.richttms.pojo.order;

import com.springboot.richttms.pojo.seat.Seat;

import java.util.List;

public class finalOrder {
    private String cinemaName;
    private String hall;
    private String starttime;
    private String endtime;
    private String movieName;
    private List<orderDetail> seats;

    public finalOrder(String cinemaName, String hall, String starttime, String endtime, String movieName, List<orderDetail> seats) {
        this.cinemaName = cinemaName;
        this.hall = hall;
        this.starttime = starttime;
        this.endtime = endtime;
        this.movieName = movieName;
        this.seats = seats;
    }

    public finalOrder() {

    }

    @Override
    public String toString() {
        return "finalOrder{" +
                "cinemaName='" + cinemaName + '\'' +
                ", hall='" + hall + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", movieName='" + movieName + '\'' +
                ", seats=" + seats +
                '}';
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<orderDetail> getSeats() {
        return seats;
    }

    public void setSeats(List<orderDetail> seats) {
        this.seats = seats;
    }
}
