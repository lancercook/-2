package com.example.asus.eduaction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
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
import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class registerActivity extends AppCompatActivity {
     Button button;
    EditText name;
    EditText password;
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private Spinner spinner1;
    String[] nItem=new String[19];
    private List<String> allItems;
    private ArrayAdapter<String> adapter;
    int count=0;
    private String urlStr = "http://39.97.176.139:8080/insert";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        button=(Button)findViewById(R.id.button2);
        name=(EditText)findViewById(R.id.c_name);
        password=(EditText)findViewById(R.id.password);
        spinner1=(Spinner) findViewById(R.id.spinner7);
        dbHelper = new MyDatabaseHelper(getApplication(), "gaokao.db", null, 1);
        db = dbHelper.getWritableDatabase();
        //insertInto("123","123");
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
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(TextUtils.isEmpty(name.getText())){
                    Toast.makeText(getApplicationContext(),"请输入用户名",Toast.LENGTH_LONG).show();
                }else{
                    if(TextUtils.isEmpty(password.getText())){
                        Toast.makeText(getApplicationContext(),"请输入密码",Toast.LENGTH_LONG).show();
                    }else{

                            insertInto(name.getText().toString(), password.getText().toString());
                           upgrate(nItem[count]);
                    }
                }
            }
        });
    }
    private void upgrate(String fen){
        Cursor c3 = db.query("normal", null, null, null, null, null, null);
        if (c3.moveToFirst()) {
            ContentValues values = new ContentValues();
            values.put("province", fen);
            db.update("normal", values, "province=?", new String[]{c3.getString(c3.getColumnIndex("province"))});
        }
    }
    private void insertInto(String name,String password){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("name",name);
        builder.add("password",password);
        final Request request = new Request.Builder()
                .url("http://39.97.176.139:8080/insert")
                .post(builder.build())
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {//这是Activity的方法，会在主线程执行任务
                    @Override
                    public void run() {
                        Toast.makeText(registerActivity.this, "注册失败，请检查网络", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //String responseStr = response.body().string();
                runOnUiThread(new Runnable() {//这是Activity的方法，会在主线程执行任务
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_LONG).show();
                        Intent intentSimple = new Intent();
                        intentSimple.setClass(registerActivity.this,LoginActivity.class);
                        startActivity(intentSimple);
                        finish();
                    }
                });
            }
        });
    }
}
