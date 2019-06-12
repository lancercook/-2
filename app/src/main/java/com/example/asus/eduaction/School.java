package com.example.asus.eduaction;

/**
 * Created by asus on 2019/5/23.
 */

public class School {
    private int id;

    private String name;

    private int score18;
    private int score17;
    private int score16;
    School(String name,int score18,int score17,int score16){
        this.name=name;
        this.score18=score18;
        this.score17=score17;
        this.score16=score16;
    }
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


    public int getScore18() {
        return score18;
    }

    public void setScore18(int score18) {
        this.score18=score18;
    }
    public int getScore17() {
        return score17;
    }

    public void setScore17(int score17) {
        this.score17=score17;
    }
    public int getScore16() {
        return score16;
    }

    public void setScore16(int score16) {
        this.score16=score16;
    }
}
