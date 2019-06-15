package com.springboot.richttms.pojo.cities;

public class City {
    private Integer id;
    private String name;
    private String pname;

    public City(Integer id, String name, String pname) {
        this.id = id;
        this.name = name;
        this.pname = pname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pname='" + pname + '\'' +
                '}';
    }
}
