package com.springboot.richttms.pojo.cinemas;

public class Cinemas {
   private Integer cinemaId;
   private String cinemaName;
   private Integer cityId;

    public Cinemas(Integer cinemaId, String cinemaName, Integer cityId) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cityId = cityId;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
