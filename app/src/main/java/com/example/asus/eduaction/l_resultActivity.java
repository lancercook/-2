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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class l_resultActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    AlertDialog.Builder builder;
    private  MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    ArrayList<String> name;
    ArrayList<Integer> count;
    Comparator<College> comparator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_result);
        name=new ArrayList<String>();
        count=new ArrayList<Integer>();
        builder = new AlertDialog.Builder(this);
        Intent intent = getIntent();
        name=intent.getStringArrayListExtra("name");
        count=intent.getIntegerArrayListExtra("count");
        dbHelper = new MyDatabaseHelper(getApplication(), "gaokao.db", null, 1);
        db = dbHelper.getWritableDatabase();
         comparator = new Comparator<College>() {
            public int compare(College s1, College s2) {

                if (s1.getCount() != s2.getCount()) {
                    return s2.getCount() - s1.getCount();
                }
                else
                    return 0;
            }
        };
        recyclerView = findViewById(R.id.linee);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);       //线性布局
        recyclerView.setLayoutManager(layoutManager);                               //RecyclerView加载线性布局
        l_resultActivity.CollegeAdapter adapter = new l_resultActivity.CollegeAdapter(selectCollege());                //创建课程类适配器，参数为刚查询到的存有课程信息的CourseList
        recyclerView.setAdapter(adapter);
    }
    public class CollegeAdapter extends RecyclerView.Adapter< l_resultActivity.CollegeAdapter.ViewHolder>{

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
        public  l_resultActivity.CollegeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_view, parent, false);
            final  l_resultActivity.CollegeAdapter.ViewHolder holder = new  l_resultActivity.CollegeAdapter.ViewHolder(view);
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

        /**
         * 将课程信息显示在textView上
         */
        public void onBindViewHolder( l_resultActivity.CollegeAdapter.ViewHolder holder, int position) {
            College college = collegeList.get(position);
            holder.CollegeInfo.setText(college.getName());
            holder.CollegeInfo2.setText("城市："+college.getCity()+"   概率："+college.getCount()/10+"."+college.getCount()%10+"%");
        }

        @Override
        public int getItemCount() {
            return collegeList.size();
        }

    }
    public List<College> selectCollege(){
        List<College> collegeList = new ArrayList<College>();
        Cursor c = db.query("college", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
               for(int i=0;i<name.size();i++){
                   if(c.getString(c.getColumnIndex("school")).equals(name.get(i))){
                       College college = new College();
                       int change = 0;
                       college.setName(c.getString(c.getColumnIndex("school")));
                       college.setCity(c.getString(c.getColumnIndex("province")));
                       college.setCount(count.get(i));
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
                Collections.sort(collegeList,comparator);
            } while (c.moveToNext());
        }
        upgrate(collegeList.get(0).getName());
        return collegeList;
    }
    private void upgrate(String fen){
        Cursor c3 = db.query("normal", null, null, null, null, null, null);
        if (c3.moveToFirst()) {
            ContentValues values = new ContentValues();
            values.put("f_school", fen);
            db.update("normal", values, "province=?", new String[]{c3.getString(c3.getColumnIndex("province"))});
        }
    }
    public void onBackPressed() {
        Intent intentSimple = new Intent();
        intentSimple.setClass( l_resultActivity.this,lineActivity.class);
        startActivity(intentSimple);
        finish();
    }
}
