package com.example.asus.eduaction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class resultActivity extends AppCompatActivity {
    private  MyDatabaseHelper dbHelper;
    SQLiteDatabase db;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        List<String> list = new ArrayList<String>();
        TextView t1=(TextView)findViewById(R.id.textView);
        TextView t2=(TextView)findViewById(R.id.xingge);
        TextView t3=(TextView)findViewById(R.id.zhuanye);
        Intent intent = getIntent();
        String recvData[] = intent.getStringArrayExtra("DATA") ;
        list.add(recvData[0]);
        list.add(recvData[1]);
        list.add(recvData[2]);
        list.add(recvData[3]);
        StringBuffer no = new StringBuffer();//不定长数组
        for(String s:list){
            no.append(s);
        }
        type=no.toString();
        t1.setText(type);
        switch (type){
            case "ISTJ": t2.setText("安静、严肃，通过全面性和可靠性获得成功。实际，有责任感。决定有逻辑性，并一步步地朝着目标前进，不易分心。喜欢将工作、家庭和生活都安排得井井有条。重视传统和忠诚。");
            break;
            case "ISFJ": t2.setText("安静、友好、有责任感和良知。坚定地致力于完成他们的义务。全面、勤勉、精确，忠诚、体贴，留心和记得他们重视的人的小细节，关心他人的感受。努力把工作和家庭环境营造得有序而温馨。");
                break;
            case "INFJ": t2.setText("寻求思想、关系、物质等之间的意义和联系。希望了解什么能够激励人，对人有很强的洞察力。有责任心，坚持自己的价值观。对于怎样更好的服务大众有清晰的远景。在对于目标的实现过程中有计划而且果断坚定。");
                break;
            case "INTJ": t2.setText("在实现自己的想法和达成自己的目标时有创新的想法和非凡的动力。能很快洞察到外界事物间的规律并形成长期的远景计划。一旦决定做一件事就会开始规划并直到完成为止。多疑、独立，对于自己和他人能力和表现的要求都非常高。");
                break;
            case "ISTP": t2.setText("灵活、忍耐力强，是个安静的观察者直到有问题发生，就会马上行动，找到实用的解决方法。分析事物运作的原理，能从大量的信息中很快的找到关键的症结所在。对于原因和结果感兴趣，用逻辑的方式处理问题，重视效率。");
                break;
            case "ISFP": t2.setText("安静、友好、敏感、和善。享受当前。喜欢有自己的空间，喜欢能按照自己的时间表工作。对于自己的价值观和自己觉得重要的人非常忠诚，有责任心。不喜欢争论和冲突。不会将自己的观念和价值观强加到别人身上。");
                break;
            case "INFP": t2.setText("理想主义，对于自己的价值观和自己觉得重要的人非常忠诚。希望外部的生活和自己内心的价值观是统一的。好奇心重，很快能看到事情的可能性，能成为实现想法的催化剂。寻求理解别人和帮助他们实现潜能。适应力强，灵活，善于接受，除非是有悖于自己的价值观的。");
                break;
            case "INTP": t2.setText("对于自己感兴趣的任何事物都寻求找到合理的解释。喜欢理论性的和抽象的事物，热衷于思考而非社交活动。安静、内向、灵活、适应力强。对于自己感兴趣的领域有超凡的集中精力深度解决问题的能力。多疑，有时会有点挑剔，喜欢分析。");
                break;
            case "ESTP": t2.setText("灵活、忍耐力强，实际，注重结果。觉得理论和抽象的解释非常无趣。喜欢积极地采取行动解决问题。注重当前，自然不做作，享受和他人在一起的时刻。喜欢物质享受和时尚。学习新事物最有效的方式是通过亲身感受和练习。");
                break;
            case "ESFP": t2.setText("外向、友好、接受力强。热爱生活、人类和物质上的享受。喜欢和别人一起将事情做成功。在工作中讲究常识和实用性，并使工作显得有趣。灵活、自然不做作，对于新的任何事物都能很快地适应。学习新事物最有效的方式是和他人一起尝试。");
                break;
            case "ENFP": t2.setText("热情洋溢、富有想象力。认为人生有很多的可能性。能很快地将事情和信息联系起来，然后很自信地根据自己的判断解决问题。总是需要得到别人的认可，也总是准备着给与他人赏识和帮助。灵活、自然不做作，有很强的即兴发挥的能力，言语流畅。");
                break;
            case "ENTP": t2.setText("反应快、睿智，有激励别人的能力，警觉性强、直言不讳。在解决新的、具有挑战性的问题时机智而有策略。善于找出理论上的可能性，然后再用战略的眼光分析。善于理解别人。不喜欢例行公事，很少会用相同的方法做相同的事情，倾向于一个接一个的发展新的爱好。");
                break;
            case "ESTJ": t2.setText("实际、现实主义。果断，一旦下决心就会马上行动。善于将项目和人组织起来将事情完成，并尽可能用最有效率的方法得到结果。注重日常的细节。有一套非常清晰的逻辑标准，有系统性地遵循，并希望他人也同样遵循。在实施计划时强而有力。");
                break;
            case "ESFJ": t2.setText("热心肠、有责任心、合作。希望周边的环境温馨而和谐，并为此果断地执行。喜欢和他人一起精确并及时地完成任务。事无巨细都会保持忠诚。能体察到他人在日常生活中的所需并竭尽全力帮助。希望自己和自己的所为能受到他人的认可和赏识。");
                break;
            case "ENFJ": t2.setText("热情、为他人着想、易感应、有责任心。非常注重他人的感情、需求和动机。善于发现他人的潜能，并希望能帮助他们实现。能成为个人或群体成长和进步的催化剂。忠诚，对于赞扬和批评都会积极地回应。友善、好社交。在团体中能很好地帮助他人，并有鼓舞他人的领导能力。");
                break;
            case "ENTJ": t2.setText("对于自己感兴趣的任何事物都寻求找到合理的解释。喜欢理论性的和抽象的事物，热衷于思考而非社交活动。安静、内向、灵活、适应力强。对于自己感兴趣的领域有超凡的集中精力深度解决问题的能力。多疑，有时会有点挑剔，喜欢分析。坦诚、果断，有天生的领导能力。能很快看到公司/组织程序和政策中的不合理性和低效能性，发展并实施有效和全面的系统来解决问题。善于做长期的计划和目标的设定。通常见多识广，博览群书，喜欢拓广自己的知识面并将此分享给他人。在陈述自己的想法时非常强而有力。");
                break;
        }
        dbHelper = new MyDatabaseHelper(getApplication(), "gaokao.db", null, 1);
        db = dbHelper.getWritableDatabase();
        Cursor c = db.query("mbti", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
              if(type.equals(c.getString(c.getColumnIndex("type")))){
                  t3.setText("适合"+c.getString(c.getColumnIndex("hot1"))+"、"+c.getString(c.getColumnIndex("hot2"))+"、"+c.getString(c.getColumnIndex("hot3"))+"、"+c.getString(c.getColumnIndex("hot4"))+"、"+c.getString(c.getColumnIndex("hot5"))+"等专业");
                  upgrate(c.getString(c.getColumnIndex("hot1")));
              }
            } while (c.moveToNext());
        }
    }
    private void upgrate(String fen){
        Cursor c3 = db.query("normal", null, null, null, null, null, null);
        if (c3.moveToFirst()) {
            ContentValues values = new ContentValues();
            values.put("mbti", fen);
            db.update("normal", values, "province=?", new String[]{c3.getString(c3.getColumnIndex("province"))});
        }
    }
}
