package com.example.asus.eduaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class first_tuActivity extends AppCompatActivity {
    private  MyDatabaseHelper dbHelper;
    SQLiteDatabase db;
    private ArrayAdapter<String> adapter,adapter1;
    private List<String> allItems,allItems1;
    private Spinner spinner1,spinner2;
    String[] nItem=new String[19];
    private String[] credit = { "理科", "文科" };
    AlertDialog.Builder builder;
    int count=0,count1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_tu);
        builder = new AlertDialog.Builder(this);
        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        dbHelper = new MyDatabaseHelper(getApplication(), "gaokao.db", null, 1);
        db = dbHelper.getWritableDatabase();
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
           Button button=(Button)findViewById(R.id.button3);
           button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               count1++;
                Cursor c1 = db.query("province", null, null, null, null, null, null);
                if (c1.moveToFirst()) {
                    do {
                        if(nItem[count].equals(c1.getString(c1.getColumnIndex("name")))&&count1==Integer.parseInt(c1.getString(c1.getColumnIndex("credit")))){
                            builder.setTitle(c1.getString(c1.getColumnIndex("name")));
                            builder.setMessage("2018年\n   一批："+c1.getString(c1.getColumnIndex("score81"))+"\n   二批："+c1.getString(c1.getColumnIndex("score82"))+
                                    "\n2017年\n   一批："+c1.getString(c1.getColumnIndex("score71"))+"\n   二批："+c1.getString(c1.getColumnIndex("score72"))+
                                    "\n2016年\n   一批："+c1.getString(c1.getColumnIndex("score61"))+"\n   二批："+c1.getString(c1.getColumnIndex("score62")) );
                            break;
                        }
                    } while (c1.moveToNext());
                    AlertDialog alert=builder.create();
                    alert.show();     }
            }
        });
    }
}
