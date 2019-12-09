package com.company;

import java.util.Date;

public class Author {
    private String name;
    private Date birth;
    private String address;
    private int sex;

    public Author(String name, Date birth, String address, int sex) {
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                '}';
    }
}
