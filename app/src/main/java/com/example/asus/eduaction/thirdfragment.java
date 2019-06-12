package com.example.asus.eduaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class thirdfragment extends Fragment{
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    public thirdfragment() {
        // Required empty public constructor
    }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_thirdfrgment,container,false);
            dbHelper = new MyDatabaseHelper(getActivity(), "gaokao.db", null, 1);
            db = dbHelper.getWritableDatabase();
            TextView t1,t2,t3;
            t1=view.findViewById(R.id.www);
            t2=view.findViewById(R.id.ttt);
            t3=view.findViewById(R.id.sss);
            Button b1=view.findViewById(R.id.button7);
            b1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(),hotActivity.class);
                    startActivity(intent);
                }
            });
            Cursor c = db.query("normal", null, null, null, null, null, null);
            if (c.moveToFirst()) {
              if(c.getString(c.getColumnIndex("s_school")).equals("")){
                  t1.setText("   暂无");
              }else{
                  t1.setText("   "+c.getString(c.getColumnIndex("s_school")));
              }
                if(c.getString(c.getColumnIndex("f_school")).equals("")&&c.getString(c.getColumnIndex("w_school")).equals("")){
                    t2.setText("   暂无");
                }else{
                    if(c.getString(c.getColumnIndex("f_school")).equals("")){
                    t2.setText("   "+c.getString(c.getColumnIndex("w_school")));}
                    else{
                        if(c.getString(c.getColumnIndex("w_school")).equals("")){
                            t2.setText("   "+c.getString(c.getColumnIndex("f_school"))+"概率最高");
                        }else{
                            t2.setText("   "+c.getString(c.getColumnIndex("f_school"))+"概率最高");
                        }
                    }
                }
                if(c.getString(c.getColumnIndex("mbti")).equals("")){
                    t3.setText("   暂无");
                }
                else{
                    t3.setText("   "+c.getString(c.getColumnIndex("mbti")));
                }
            }
            return view;
        }
}
