package com.springboot.richttms.pojo.customers;

public class Customers {
    private Integer id;
    private String name;
    private String password;
    private String image;
    private String email;
    private String checkcode;

    public Customers(Integer id, String name, String password, String image, String email, String checkcode) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.image = image;
        this.email = email;
        this.checkcode = checkcode;
    }


    public String getCheckcode() {
        return checkcode;
    }

    public Customers(String email,String password) {
        this.email=email;
        this.password = password;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public Customers(Integer id, String name, String password, String image, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.image = image;
        this.email = email;
    }

    public Customers() {
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
