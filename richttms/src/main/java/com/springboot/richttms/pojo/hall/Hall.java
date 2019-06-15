package com.springboot.richttms.pojo.hall;

public class Hall {

    private Integer HallId;
    private  Integer CId;

    private String hallDescription;

    public Hall(Integer hallId, Integer CId, String hallDescription) {
        HallId = hallId;
        this.CId = CId;
        this.hallDescription = hallDescription;
    }

    public Integer getHallId() {
        return HallId;
    }

    public void setHallId(Integer hallId) {
        HallId = hallId;
    }

    public Integer getCId() {
        return CId;
    }

    public void setCId(Integer CId) {
        this.CId = CId;
    }

    public String getHallDescription() {
        return hallDescription;
    }

    public void setHallDescription(String hallDescription) {
        this.hallDescription = hallDescription;
    }
}
