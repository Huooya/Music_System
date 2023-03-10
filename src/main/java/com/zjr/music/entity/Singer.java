package com.zjr.music.entity;

public class Singer {
    private String name;
    private String sex;
    private String introduce;
    private String area;
    private Integer dynamic_state;
    private Integer attention;
    private Integer fan;
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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
