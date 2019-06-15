package com.springboot.richttms.pojo.schedule;

public class Schedule {
    private Integer scheduleId;
    private Integer mId;
    private Integer hId;
    private Integer cId;
    private String schedulefee;
    private String schedulebegintime;
    private String scheduleendtime;

    public Schedule(Integer scheduleId, Integer mId, Integer hId, Integer cId, String schedulefee, String schedulebegintime, String endtime) {
        this.scheduleId = scheduleId;
        this.mId = mId;
        this.hId = hId;
        this.cId = cId;
        this.schedulefee = schedulefee;
        this.schedulebegintime = schedulebegintime;
        this.scheduleendtime = endtime;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getSchedulefee() {
        return schedulefee;
    }

    public void setSchedulefee(String schedulefee) {
        this.schedulefee = schedulefee;
    }

    public String getSchedulebegintime() {
        return schedulebegintime;
    }

    public void setSchedulebegintime(String schedulebegintime) {
        this.schedulebegintime = schedulebegintime;
    }

    public String getScheduleendtime() {
        return scheduleendtime;
    }

    public void setScheduleendtime(String scheduleendtime) {
        this.scheduleendtime = scheduleendtime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", mId=" + mId +
                ", hId=" + hId +
                ", cId=" + cId +
                ", schedulefee='" + schedulefee + '\'' +
                ", schedulebegintime='" + schedulebegintime + '\'' +
                ", endtime='" + scheduleendtime + '\'' +
                '}';
    }
}
