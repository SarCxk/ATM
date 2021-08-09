package com.hp.bean;

import java.util.Date;

public class Student {
    private int id;
    private int age;
    private String name;
    private Date brithday;
    //是否是神
    private boolean isShen;

    public boolean isShen() {
        return isShen;
    }

    public void setShen(boolean shen) {
        isShen = shen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", brithday=" + brithday +
                ", isShen=" + isShen +
                '}';
    }
}
