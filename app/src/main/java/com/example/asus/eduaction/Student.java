package com.example.asus.eduaction;

import java.io.Serializable;

/**
 * Created by asus on 2019/5/13.
 */

public class Student implements Serializable {

    private int id;

    private String name;

    private String age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
