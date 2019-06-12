package com.example.asus.eduaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class first_coActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private Spinner spinner1,spinner2;
    String[] nItem=new String[19];
    AlertDialog.Builder builder;
    private List<String> allItems,allItems1;
    private ArrayAdapter<String> adapter,adapter1;
    int count=0,count1=0;
    private String[] credit = { "理科", "文科" };
    EditText t1,t2;
    List<School> listdata;
    int school_num=0;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_co);
        spinner1=(Spinner)findViewById(R.id.spinner5);
        spinner2=(Spinner)findViewById(R.id.spinner6);
        t1=(EditText)findViewById(R.id.what);
        t2=(EditText)findViewById(R.id.what1);
        builder = new AlertDialog.Builder(this);
        dbHelper = new MyDatabaseHelper(getApplication(), "gaokao.db", null, 1);
        db = dbHelper.getWritableDatabase();
        final Comparator<pointBean> comparator = new Comparator<pointBean>() {
            public int compare(pointBean s1,pointBean s2) {

                if (s1.getPoint_x() != s2.getPoint_x()) {
                    return s2.getPoint_x()- s1.getPoint_x();
                }
                else
                    return 0;
            }
        };
        int num=0;
        Cursor c = db.query("province", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                nItem[num]=c.getString(c.getColumnIndex("name"));
                if(num>=17){break;}
                num++;
            } while (c.moveToNext());
        }
        allItems = new ArrayList<String>();
        for (int i = 0; i <= 17; i++) {
            allItems.add(nItem[i]);
        }
        allItems1 = new ArrayList<String>();
        for (int i = 0; i < credit.length; i++) {
            allItems1.add(credit[i]);
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, allItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                count=arg2;
               /* citygp.setText(changeCity.getSelectedItem().toString() + "今天的团购");
                Log.i("info-----------", changeCity.getSelectedItem().toString());*/
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, allItems1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                count1=arg2;
               /* citygp.setText(changeCity.getSelectedItem().toString() + "今天的团购");
                Log.i("info-----------", changeCity.getSelectedItem().toString());*/
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        Button button=(Button)findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(TextUtils.isEmpty(t1.getText())){
                    Toast.makeText(first_coActivity.this, "请输入分数", Toast.LENGTH_SHORT).show();
                }else{
                    listdata = new ArrayList<School>();
                    Cursor c1 = db.query("college", null, null, null, null, null, null);
                    if (c1.moveToFirst()) {
                        do {
                            if(c1.getString(c1.getColumnIndex("admit")).equals(credit[count1])){
                                Cursor c2 = db.query("province", null, null, null, null, null, null);
                                if(c2.moveToFirst()){
                                    do{
                                        if(count1+1==Integer.parseInt(c2.getString(c2.getColumnIndex("credit")))&&c2.getString(c2.getColumnIndex("name")).equals("吉林")){
                                            int a=Integer.parseInt(c1.getString(c1.getColumnIndex("score_first")))-Integer.parseInt(c2.getString(c2.getColumnIndex("score71")));
                                            int b=Integer.parseInt(c1.getString(c1.getColumnIndex("score_second")))-Integer.parseInt(c2.getString(c2.getColumnIndex("score61")));
                                            int c=0;
                                            if(TextUtils.isEmpty(t2.getText())){
                                                c=Math.abs(Integer.parseInt(t1.getText().toString())-Integer.parseInt(c2.getString(c2.getColumnIndex("score81"))));
                                            }else{
                                                c=Math.abs(Integer.parseInt(t1.getText().toString())-Integer.parseInt(t2.getText().toString()));
                                            }
                                            int d=(a+b)/2;
                                            if(c>d-20&&c<d+30){
                                                School school=new School(c1.getString(c1.getColumnIndex("school")),Integer.parseInt(c1.getString(c1.getColumnIndex("score_first"))),Integer.parseInt(c1.getString(c1.getColumnIndex("score_second"))),Integer.parseInt(c1.getString(c1.getColumnIndex("score_third"))));
                                                listdata.add(school);
                                                school_num++;
                                            }
                                        }
                                    }while(c2.moveToNext());
                                }
                            }
                        }while (c1.moveToNext());
                    }
                    int num_1[]=new int[school_num];
                    int num_2[]=new int[school_num];
                    int num_3[]=new int[school_num];
                    for(int i=0;i<school_num;i++){
                        num_1[i]=listdata.get(i).getScore18();
                        num_2[i]=listdata.get(i).getScore17();
                        num_3[i]=listdata.get(i).getScore16();
                    }
                    ArrayList<pointBean> list=new ArrayList<pointBean>();
                    pointBean bean;
                    for(int i=0;i<school_num;i++){
                        bean=new pointBean();
                        bean.point_x=num_1[i];
                        bean.point_y=num_2[i];
                        bean.point_z=num_3[i];
                        list.add(bean);
                    }
                    // 执行k-means算法
                    if(school_num>=3){
                    Collections.sort(list,comparator);
                    setData(list);}
                    else{
                        Toast.makeText(first_coActivity.this, "数据不足", Toast.LENGTH_SHORT).show();
                    }
                    school_num=0;
                    listdata.clear();
                }
            }
        });
    }
    public  void setData(ArrayList<pointBean> list){
        int p=school_num/2;
        con1_x=list.get(0).point_x;
        con1_y=list.get(0).point_y;
        con1_z=list.get(0).point_z;
        con2_x=list.get(p).point_x;
        con2_y=list.get(p).point_y;
        con2_z=list.get(p).point_z;
        con3_x=list.get(school_num-1).point_x;
        con3_y=list.get(school_num-1).point_y;
        con3_z=list.get(school_num-1).point_z;
        //分别加入list中
        list1.add(list.get(0));
        list2.add(list.get(p));
        list3.add(list.get(school_num-1));

        //循环操作
        for(int i=3;i<list.size();i++){
            getLength(list.get(i));
        }
        // 打印出对应的中心点 、聚类的值
       ArrayList<String> name1=new ArrayList<String>();
        ArrayList<String> name2=new ArrayList<String>();
        ArrayList<String> name3=new ArrayList<String>();
        Cursor c1 = db.query("college", null, null, null, null, null, null);
        if (c1.moveToFirst()) {
            do {
                for(int i=0;i<list1.size();i++) {
                    if (list1.get(i).point_x == Integer.parseInt(c1.getString(c1.getColumnIndex("score_first"))) && list1.get(i).point_y == Integer.parseInt(c1.getString(c1.getColumnIndex("score_second"))) && list1.get(i).point_z == Integer.parseInt(c1.getString(c1.getColumnIndex("score_third")))) {
                        name1.add(c1.getString(c1.getColumnIndex("school")));
                    }
                }
                for(int t=0;t<list2.size();t++) {
                        if (list2.get(t).point_x ==Integer.parseInt(c1.getString(c1.getColumnIndex("score_first")))&&list2.get(t).point_y==Integer.parseInt(c1.getString(c1.getColumnIndex("score_second")))&&list2.get(t).point_z==Integer.parseInt(c1.getString(c1.getColumnIndex("score_third"))))
                        {
                            name2.add(c1.getString(c1.getColumnIndex("school")));
                        }
                }
                for(int t=0;t<list3.size();t++) {
                    if (list3.get(t).point_x ==Integer.parseInt(c1.getString(c1.getColumnIndex("score_first")))&&list3.get(t).point_y==Integer.parseInt(c1.getString(c1.getColumnIndex("score_second")))&&list3.get(t).point_z==Integer.parseInt(c1.getString(c1.getColumnIndex("score_third"))))
                    {
                        name3.add(c1.getString(c1.getColumnIndex("school")));
                    }
                }
            } while (c1.moveToNext());
        }
        double a=(con1_x+con1_y+con1_z)/3;
        double b=(con2_x+con2_y+con2_z)/3;
        double c=(con3_x+con3_y+con3_z)/3;

        if(a>b&&a>c&&b>c){
            Intent intent = new Intent();
            intent.setClass(getApplication(), emptyActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("wen",name2);
            bundle.putStringArrayList("chong",name1);
            bundle.putStringArrayList("bao",name3);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        if(a>b&&a>c&&c>b){
            Intent intent = new Intent();
            intent.setClass(getApplication(), emptyActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("wen",name3);
            bundle.putStringArrayList("chong",name1);
            bundle.putStringArrayList("bao",name2);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        if(b>a&&b>c&&c>a){
            Intent intent = new Intent();
            intent.setClass(getApplication(),emptyActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("wen",name3);
            bundle.putStringArrayList("chong",name2);
            bundle.putStringArrayList("bao",name1);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        if(b>a&&b>c&&a>c){
            Intent intent = new Intent();
            intent.setClass(getApplication(), emptyActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("wen",name1);
            bundle.putStringArrayList("chong",name2);
            bundle.putStringArrayList("bao",name3);
            intent.putExtras(bundle);
            startActivity(intent);
        }
       if(c>a&&c>b&&a>b){
           Intent intent = new Intent();
           intent.setClass(getApplication(),emptyActivity.class);
           Bundle bundle = new Bundle();
           bundle.putStringArrayList("wen",name1);
           bundle.putStringArrayList("chong",name3);
           bundle.putStringArrayList("bao",name2);
           intent.putExtras(bundle);
           startActivity(intent);
       }
        if(c>a&&c>b&&b>a){
            Intent intent = new Intent();
            intent.setClass(getApplication(), emptyActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("wen",name2);
            bundle.putStringArrayList("chong",name3);
            bundle.putStringArrayList("bao",name1);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        list1.clear();
        list2.clear();
        list3.clear();
        list.clear();
        name1.clear();
        name2.clear();
        name3.clear();
        /*System.out.println("-------1-------");
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
        }*/

    }
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