package com.example.asus.eduaction;
import java.io.Serializable;
/**
 * Created by asus on 2019/5/22.
 */

public class College  {
    private int id;

    private String name;
    private String city;
    private int count;

    College(String name,int count){
        this.name=name;
        this.count=count;
    }
    College(String name){
        this.name=name;
    }
    public College(){}
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
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
