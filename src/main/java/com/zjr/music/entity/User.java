package com.zjr.music.entity;

public class User {
    private String username;
    private String password;
    private String sex;
    private String introduction;
    private String area;
    private Integer dynamic_state;
    private Integer attention;
    private Integer fan;
    private String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getDynamic_state() {
        return dynamic_state;
    }

    public void setDynamic_state(Integer dynamic_state) {
        this.dynamic_state = dynamic_state;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getFan() {
        return fan;
    }

    public void setFan(Integer fan) {
        this.fan = fan;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
