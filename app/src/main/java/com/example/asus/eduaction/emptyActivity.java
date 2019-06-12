package com.example.asus.eduaction;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class emptyActivity extends AppCompatActivity {
     ArrayList<String> chong;
    ArrayList<String> wen;
    ArrayList<String> bao;
    private  MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private RecyclerView r1,r2,r3;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        chong=new ArrayList<String>();
        wen=new ArrayList<String>();
        bao=new ArrayList<String>();
        builder = new AlertDialog.Builder(this);
        Intent intent = getIntent();
        chong=intent.getStringArrayListExtra("chong");
        wen=intent.getStringArrayListExtra("wen");
        bao=intent.getStringArrayListExtra("bao");
        dbHelper = new MyDatabaseHelper(getApplication(), "gaokao.db", null, 1);
        db = dbHelper.getWritableDatabase();
        r1 = findViewById(R.id.chong);
        r2 = findViewById(R.id.wen);
        r3= findViewById(R.id.bao);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);       //线性布局
           LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
           LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
        r1.setLayoutManager(layoutManager);                               //RecyclerView加载线性布局
        r2.setLayoutManager(layoutManager2);
        r3.setLayoutManager(layoutManager3);
        emptyActivity.CollegeAdapter adapter1 = new emptyActivity.CollegeAdapter(selectCollege1());                //创建课程类适配器，参数为刚查询到的存有课程信息的CourseList
        emptyActivity.CollegeAdapter adapter2 = new emptyActivity.CollegeAdapter(selectCollege2());
        emptyActivity.CollegeAdapter adapter3 = new emptyActivity.CollegeAdapter(selectCollege3());
        r1.setAdapter(adapter1);
        r2.setAdapter(adapter2);
        r3.setAdapter(adapter3);
    }
    public class CollegeAdapter extends RecyclerView.Adapter<emptyActivity.CollegeAdapter.ViewHolder>{

        private List<College> collegeList;

        class ViewHolder extends RecyclerView.ViewHolder {
            View CollegeView;
            TextView CollegeInfo;
            TextView CollegeInfo2;
            public ViewHolder(View view) {
                super(view);
                CollegeView = view;
                CollegeInfo = (TextView) view.findViewById(R.id.College_info);
                CollegeInfo2=(TextView)view.findViewById(R.id.College_info2);
            }
        }

        public CollegeAdapter(List collegeList) {
            this.collegeList = collegeList;
        }

        @Override
        /**
         * 点击对应部分显示toast
         */
        public emptyActivity.CollegeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_view, parent, false);
            final emptyActivity.CollegeAdapter.ViewHolder holder = new emptyActivity.CollegeAdapter.ViewHolder(view);
            holder.CollegeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    int p1=0,p2=0,p3=0,o1=0,o2=0,o3=0;
                    final College college =  collegeList.get(position);
                    Cursor c7 = db.query("college", null, null, null, null, null, null);
                    if (c7.moveToFirst()) {
                        do{
                            if(c7.getString(c7.getColumnIndex("school")).equals(college.getName())&&c7.getString(c7.getColumnIndex("admit")).equals("理科")){
                                p1=Integer.parseInt(c7.getString(c7.getColumnIndex("score_first")));
                                p2=Integer.parseInt(c7.getString(c7.getColumnIndex("score_second")));
                                p3=Integer.parseInt(c7.getString(c7.getColumnIndex("score_third")));
                            }
                            if(c7.getString(c7.getColumnIndex("school")).equals(college.getName())&&c7.getString(c7.getColumnIndex("admit")).equals("文科")){
                                o1=Integer.parseInt(c7.getString(c7.getColumnIndex("score_first")));
                                o2=Integer.parseInt(c7.getString(c7.getColumnIndex("score_second")));
                                o3=Integer.parseInt(c7.getString(c7.getColumnIndex("score_third")));
                            }
                        }while(c7.moveToNext());
                    }
                    builder.setTitle(""+college.getName()+"分数线");
                    if(o1!=0) {
                        builder.setMessage("理科\n" + "   2017年：" + p1 + "\n" + "   2016年：" + p2 + "\n" + "   2015年：" + p3 + "\n文科\n" + "   2017年：" + o1 + "\n" + "   2016年：" + o2 + "\n" + "   2015年：" + o3);
                    }else{
                        builder.setMessage("理科\n" + "   2017年：" + p1 + "\n" + "   2016年：" + p2 + "\n" + "   2015年：" + p3 + "\n文科\n" + "暂无");
                    }
                    builder.setPositiveButton("标注", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            upgrate(college.getName());

                            //Toast.makeText(s_resultActivity.this, "positive: " + which, Toast.LENGTH_SHORT).show();
                        }
                    });
                    //    设置一个NegativeButton
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {

                            //Toast.makeText(s_resultActivity.this, "negative: " + which, Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog alert=builder.create();
                    alert.show();
                }
            });
            return holder;
        }
        @Override
        /**
         * 将课程信息显示在textView上
         */
        public void onBindViewHolder(emptyActivity.CollegeAdapter.ViewHolder holder, int position) {
            College college = collegeList.get(position);
            holder.CollegeInfo.setText(college.getName());
            holder.CollegeInfo2.setText("城市："+college.getCity());
        }

        @Override
        public int getItemCount() {
            return collegeList.size();
        }

    }
    public List<College> selectCollege1(){
        List<College> collegeList = new ArrayList<College>();
        Cursor c = db.query("college", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                for(int i=0;i<chong.size();i++) {
                    if (c.getString(c.getColumnIndex("school")).equals(chong.get(i))) {
                        College college = new College();
                        int change = 0;
                        college.setName(c.getString(c.getColumnIndex("school")));
                        college.setCity(c.getString(c.getColumnIndex("province")));
                        for (int t = 0; t < collegeList.size(); t++) {
                            if (collegeList.get(t).getName().equals(college.getName())) {
                                change = 1;
                            }
                        }
                        if (change == 0) {
                            collegeList.add(college);
                        }
                    }
                }
            }while (c.moveToNext());}

            return collegeList;

    }
    public List<College> selectCollege2(){
        List<College> collegeList = new ArrayList<College>();
        Cursor c = db.query("college", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                for(int i=0;i<wen.size();i++) {
                    if (c.getString(c.getColumnIndex("school")).equals(wen.get(i))) {
                        College college = new College();
                        int change = 0;
                        college.setName(c.getString(c.getColumnIndex("school")));
                        college.setCity(c.getString(c.getColumnIndex("province")));
                        for (int t = 0; t < collegeList.size(); t++) {
                            if (collegeList.get(t).getName().equals(college.getName())) {
                                change = 1;
                            }
                        }
                        if (change == 0) {
                            collegeList.add(college);
                        }
                    }
                }
            }while (c.moveToNext());}

        return collegeList;

    }
    public List<College> selectCollege3(){
        List<College> collegeList = new ArrayList<College>();
        Cursor c = db.query("college", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                for(int i=0;i<bao.size();i++) {
                    if (c.getString(c.getColumnIndex("school")).equals(bao.get(i))) {
                        College college = new College();
                        int change = 0;
                        college.setName(c.getString(c.getColumnIndex("school")));
                        college.setCity(c.getString(c.getColumnIndex("province")));
                        for (int t = 0; t < collegeList.size(); t++) {
                            if (collegeList.get(t).getName().equals(college.getName())) {
                                change = 1;
                            }
                        }
                        if (change == 0) {
                            collegeList.add(college);
                        }
                    }
                }
            }while (c.moveToNext());}

        return collegeList;

    }
    private void upgrate(String fen){
        Cursor c3 = db.query("normal", null, null, null, null, null, null);
        if (c3.moveToFirst()) {
            ContentValues values = new ContentValues();
            values.put("w_school", fen);
            db.update("normal", values, "province=?", new String[]{c3.getString(c3.getColumnIndex("province"))});
        }
    }
}
