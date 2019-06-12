package com.example.asus.eduaction;

/**
 * Created by asus on 2019/5/23.
 */

public class pointBean {
    int point_x;
    int point_y;
    int point_z;
    public int getPoint_x() {
        return point_x;
    }
    public void setPoint_x(int point_x) {
        this.point_x = point_x;
    }
    public int getPoint_z() {
        return point_z;
    }
    public void setPoint_z(int point_z) {
        this.point_z = point_z;
    }
    public int getPoint_y() {
        return point_y;
    }
    public void setPoint_y(int point_y) {
        this.point_y = point_y;
    }
    @Override
    public String toString() {
        return "pointBean [point_x=" + point_x + ", point_y=" + point_y + ",point_z="+point_z+"]";
    }
    public pointBean(int point_x, int point_y,int point_z) {
        super();
        this.point_x = point_x;
        this.point_y = point_y;
        this.point_z = point_z;
    }
    public pointBean() {
        super();
    }


}

