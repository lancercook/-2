package com.example.asus.eduaction;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Calendar;

public class secondfragment extends Fragment {

    int data;
    public secondfragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_secoondfregment,container,false);
        //进入专业测试界面
        Button test_but=view.findViewById(R.id.s_button);
        Button button1=view.findViewById(R.id.heiban);
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int a=0;
        if(year%4==0){
            a=1;
        }
        if(month==1){
            data=31-day+28+31+30+31+6+a;
        }
        if(month==2){
            data=28-day+31+30+31+6+a;
        }
        if(month==3){
            data=31-day+30+31+6;
        }
        if(month==4){
            data=30-day+31+6;
        }
        if(month==5){
            data=31-day+6;
        }
        if(month==6&&day<7){
            data=6-day;
        }
        if(month==6&&day>=7){
            data=365-day+6;
        }
        button1.setText("\n        距高考\n                还有"+data+"天");
        test_but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),first_coActivity.class);
                startActivity(intent);
            }
        });
        Button test_but1=view.findViewById(R.id.button4);
        test_but1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),lineActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }
}
