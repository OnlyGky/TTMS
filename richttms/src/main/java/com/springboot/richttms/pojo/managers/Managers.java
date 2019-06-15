package com.springboot.richttms.pojo.managers;

public class Managers {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String image;
    private Integer role;
    private Integer classId;



    public Managers() {
    }

    public Managers(Integer id, String name, String password, String email, String image, Integer role, Integer classId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.image = image;
        this.role = role;
        this.classId = classId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
