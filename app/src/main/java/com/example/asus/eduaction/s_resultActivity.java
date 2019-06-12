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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class s_resultActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String arg0;
    TextView text1;
    AlertDialog.Builder builder;
    private  MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_result);
        ArrayList<String> result_list;
        Intent intent = getIntent();
        arg0 = intent.getStringExtra("gates");
        builder = new AlertDialog.Builder(this);
        text1 = findViewById(R.id.titl);
        dbHelper = new MyDatabaseHelper(getApplication(), "gaokao.db", null, 1);
        db = dbHelper.getWritableDatabase();
        recyclerView = findViewById(R.id.recycler_view2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);       //线性布局
        recyclerView.setLayoutManager(layoutManager);                               //RecyclerView加载线性布局
        CollegeAdapter adapter = new CollegeAdapter(selectCollege());                //创建课程类适配器，参数为刚查询到的存有课程信息的CourseList
        recyclerView.setAdapter(adapter);
        text1.setText("搜索‘" + arg0 + "’结果");
    }

    public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.ViewHolder>{

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
        public CollegeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_view, parent, false);
            final CollegeAdapter.ViewHolder holder = new CollegeAdapter.ViewHolder(view);
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
        public void onBindViewHolder(CollegeAdapter.ViewHolder holder, int position) {
            College college = collegeList.get(position);
            holder.CollegeInfo.setText(college.getName());
            holder.CollegeInfo2.setText("城市："+college.getCity());
        }

        @Override
        public int getItemCount() {
            return collegeList.size();
        }

    }
    public List<College> selectCollege(){
        String tab_name="college";
        String tab_field02="school";
        int i=0;
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(getApplication(), "gaokao.db", null, 1);
        SQLiteDatabase mDatabase = dbHelper.getReadableDatabase();
        String current_sql_sel = "SELECT  * FROM "+tab_name +" where "+tab_field02+" like '%"+arg0+"%'";
        Cursor c_test = mDatabase.rawQuery(current_sql_sel, null);
        while (c_test.moveToNext()) {
            //  String name = c_test.getString(c_test.getColumnIndex(tab_field02));
            i++;
        }
        c_test.close();
        if (i > 0) {
            List<College> collegeList = new ArrayList<College>(i);
            Cursor c_test1 = mDatabase.rawQuery(current_sql_sel, null);
            while (c_test1.moveToNext()) {
                College college = new College();
                int change=0;
                college.setName(c_test1.getString(c_test1.getColumnIndex("school")));
                college.setCity(c_test1.getString(c_test1.getColumnIndex("province")));
               for(int t=0;t<collegeList.size();t++) {
                   if (collegeList.get(t).getName().equals(college.getName())){
                       change=1;
                   }
               }
                if(change==0){
                   collegeList.add(college);
                }
            }
            return collegeList;
        }
        else{
            text1.setText("无结果");
            Toast.makeText(getApplication(), "没有搜索结果" , Toast.LENGTH_SHORT).show();
            List<College> collegeList = new ArrayList<College>(0);
            return collegeList;
        }

    }
    private void upgrate(String fen){
        Cursor c3 = db.query("normal", null, null, null, null, null, null);
        if (c3.moveToFirst()) {
            ContentValues values = new ContentValues();
            values.put("s_school", fen);
            db.update("normal", values, "province=?", new String[]{c3.getString(c3.getColumnIndex("province"))});
        }
    }
    public void onBackPressed() {
        Intent intentSimple = new Intent();
        intentSimple.setClass(s_resultActivity.this,MainActivity.class);
        startActivity(intentSimple);
        finish();
    }
}
