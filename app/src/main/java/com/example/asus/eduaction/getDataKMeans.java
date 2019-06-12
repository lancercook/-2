package com.example.asus.eduaction;

/**
 * Created by asus on 2019/5/23.
 */

import java.util.ArrayList;
public class getDataKMeans {
    int k=3;//k值
    //第一个中心点x,y
    static double con1_x;
    static double con1_y;
    static double con1_z;
    //第一个中心点x,y
    static double con2_x;
    static double con2_y;
    static double con2_z;
    //第一个中心点x,y
    static double con3_x;
    static double con3_y;
    static double con3_z;
    //第一个中心点x,y
    //创建5个list装各个点
    ArrayList<pointBean> list1=new ArrayList<pointBean>();
    ArrayList<pointBean> list2=new ArrayList<pointBean>();
    ArrayList<pointBean> list3=new ArrayList<pointBean>();


    public  void setData(ArrayList<pointBean> list){
        con1_x=list.get(0).point_x;
        con1_y=list.get(0).point_y;
        con1_z=list.get(0).point_z;
        con2_x=list.get(1).point_x;
        con2_y=list.get(1).point_y;
        con2_z=list.get(1).point_z;
        con3_x=list.get(2).point_x;
        con3_y=list.get(2).point_y;
        con3_z=list.get(2).point_z;
        //分别加入list中
        list1.add(list.get(0));
        list2.add(list.get(1));
        list3.add(list.get(2));

        //循环操作
        for(int i=3;i<list.size();i++){
            getLength(list.get(i));
        }
        // 打印出对应的中心点 、聚类的值
        System.out.println("-------1-------");
        System.out.println("1的中心点:"+con1_x+" "+con1_y+con1_z);
        for(int i=0;i<list1.size();i++){
            System.out.println(list1.get(i).point_x+" "+list1.get(i).point_y+" "+list1.get(i).point_z);
        }
        System.out.println("-------2-------");
        System.out.println("2的中心点:"+con2_x+" "+con2_y+con2_z);
        for(int i=0;i<list2.size();i++){
            System.out.println(list2.get(i).point_x+" "+list2.get(i).point_y+" "+list2.get(i).point_z);
        }
        System.out.println("-------3-------");
        System.out.println("3的中心点:"+con3_x+" "+con3_y+con3_z);
        for(int i=0;i<list3.size();i++){
            System.out.println(list3.get(i).point_x+" "+list3.get(i).point_y+" "+list3.get(i).point_z);
        }

    }
    /**
     * 求出每个点到中心点距离
     * @param point
     */
    public  void getLength(pointBean point) {
        int x=point.point_x;
        int y=point.point_y;
        int z=point.point_z;


        double s1=(x-con1_x)*(x-con1_x)+(y-con1_y)*(y-con1_y)+(z-con1_z)*(z-con1_z);
        double s2=(x-con2_x)*(x-con2_x)+(y-con2_y)*(y-con2_y)+(z-con2_z)*(z-con2_z);
        double s3=(x-con3_x)*(x-con3_x)+(y-con3_y)*(y-con3_y)+(z-con3_z)*(z-con3_z);


        double nn[]={s1,s2,s3};
        // 找出最小的一个
        double temp=nn[0];
        for(int i=1;i<nn.length;i++){
            if(nn[i]<=temp)
                temp=nn[i];
        }
        // 添加点
        if(temp==s1){
            list1.add(point);
            upDataPoint(list1,con1_x,con1_y,con1_z);
        }
        if(temp==s2){
            list2.add(point);
            upDataPoint(list2,con2_x,con2_x,con2_z);
        }
        if(temp==s3){
            list3.add(point);
            upDataPoint(list3,con3_x,con3_x,con3_z);
        }








    }
    /**
     * 更新中心点坐标
     * @param list
     */
    private void upDataPoint(ArrayList<pointBean> list,double x,double y,double z) {
        double up_x=0;
        double up_y=0;
        double up_z=0;
        for(int i=0;i<list.size();i++){
            up_x+=list.get(i).point_x;
            up_y+=list.get(i).point_y;
            up_z+=list.get(i).point_z;
        }
        x=up_x/(list.size());
        y=up_y/(list.size());
        z=up_z/(list.size());
    }


}

