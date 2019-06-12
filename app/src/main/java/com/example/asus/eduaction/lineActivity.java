package com.example.asus.eduaction;

import android.content.ContentValues;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lineActivity extends AppCompatActivity {
    private  MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private ArrayAdapter<String> adapter,adapter1;
    private List<String> allItems,allItems1;
    private Spinner spinner1,spinner2;
    String[] nItem=new String[19];
    private String[] credit = { "理科", "文科" };
    AlertDialog.Builder builder;
    EditText t1;
    int count=0,count1=0;
    int number=0;
    int pop=0;
    int gai;
    int school_num=0;
    List<College> listdata;
    long startTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        builder = new AlertDialog.Builder(this);
        spinner1=(Spinner)findViewById(R.id.spinner3);
        spinner2=(Spinner)findViewById(R.id.spinner4);
        t1=(EditText)findViewById(R.id.editText);
        dbHelper = new MyDatabaseHelper(getApplication(), "gaokao.db", null, 1);
        db = dbHelper.getWritableDatabase();
        final Comparator<College> comparator = new Comparator<College>() {
            public int compare(College s1, College s2) {

                if (s1.getCount() != s2.getCount()) {
                    return s2.getCount() - s1.getCount();
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
        c.close();
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
        Button button=(Button)findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                 number=Integer.parseInt(t1.getText().toString());
                listdata = new ArrayList<College>();
                Cursor c1 = db.query("college", null, null, null, null, null, null);
                if (c1.moveToFirst()) {
                    do {
                        if(credit[count1].equals(c1.getString(c1.getColumnIndex("admit")))){
                        int a=Integer.parseInt(c1.getString(c1.getColumnIndex("potion_first")));
                        int b=Integer.parseInt(c1.getString(c1.getColumnIndex("potion_second")));
                        int c=Integer.parseInt(c1.getString(c1.getColumnIndex("potion_third")));
                        int d1,d2,d3,d4=0;
                        d1=Math.abs(a-b);
                        d2=Math.abs(a-c);
                        d3=Math.abs(b-c);
                        if(d1>d2&&d1>d3){
                            d4=((a-c)*1000/c+(b-c)*1000/c)/2;
                        }else{
                            if(d2>d1&&d2>d3){
                                d4=((a-b)*1000/b+(b-c)*1000/c)/2;
                            }else{
                                if(d3>d1&&d3>d2){
                                    d4=((a-b)*1000/b+(a-c)*1000/c)/2;
                                }
                            }
                        }
                        int res1=d4*a/1000+a;
                        int res2=0;
                        if(d4>0){res2=a-d4*a/4000;}
                        if(d4<0){res2=res1;res1=a-d4*a/4000;}
                        if(number<res1+(a/10)&&number>res2-(a/10)){
                            gai=(((res1+(a/10)-number)*1000)/(res1-res2+2*(a/10)));
                            College school=new College(c1.getString(c1.getColumnIndex("school")),gai);
                            listdata.add(school);
                            school_num++;
                        }
                        }
                    } while (c1.moveToNext());
                }
                     c1.close();
                Collections.sort(listdata,comparator);
                if(listdata.size()==0){
                    builder.setTitle("推荐");
                    builder.setMessage("对不起，由于数据原因暂无推荐");
                }
                else{
                    ArrayList<String> name= new ArrayList<String>();
                    ArrayList<Integer> count=new ArrayList<Integer>();
                    for(int i=0;i<listdata.size();i++){
                        name.add(listdata.get(i).getName());
                        count.add(listdata.get(i).getCount());
                    }
                    Intent intent = new Intent();
                    intent.setClass(getApplication(), l_resultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("name",name);
                    bundle.putIntegerArrayList("count",count);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }

                AlertDialog alert=builder.create();
                alert.show();
                school_num=0;
               /* for(int t=0;t<20;t++)
                for(int i=0;school[i+1]!=null;i++){
                    if(school[i].getCount()<school[i+1].getCount()){
                        school1=school[i];
                        school[i]=school[i+1];
                        school[i+1]=school1;
                    }
                }*/

            }
        });
    }
    public void onBackPressed() {
        Intent intentSimple = new Intent();
        intentSimple.setClass(lineActivity.this,MainActivity.class);
        startActivity(intentSimple);
        finish();
    }
    private void upgrate(String fen){
        Cursor c3 = db.query("normal", null, null, null, null, null, null);
        if (c3.moveToFirst()) {
            ContentValues values = new ContentValues();
            values.put("f_school", fen);
            db.update("normal", values, "province=?", new String[]{c3.getString(c3.getColumnIndex("province"))});
        }
    }
}
