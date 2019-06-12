package com.example.asus.eduaction;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class firstfragment extends Fragment {
    Button button1,button2;
    private  MyDatabaseHelper dbHelper;
    SQLiteDatabase db;
    private ViewPager mViewPaper;
    private ScheduledExecutorService scheduledExecutorService;
    private List<ImageView> images;
    private List<View> dots;
    private TextView title;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    private ViewPagerAdapter adapter;
    int itemsum;
    String[] name=new String[3];
    static int usersum;
    double[][] itemsim;
    double[] itemsom,result;
    ArrayList<College> train=new ArrayList<College>();
    View view;
    TextView mTextView;
    EditText mEditText;
    private RecyclerView recyclerView;
    String ws="",fs="",ss="";
    List<College> collegeList1 = new ArrayList<College>();
    int[] mark=new int[3];
    private int[] imageIds = new int[]{
            R.drawable.niujin,
            R.drawable.bl,
            R.drawable.bt,
            R.drawable.bb,
            R.drawable.qinghuayuan
    };
    private String[] titles = new String[]{
            "",
            "",
            "",
            "",
            ""
    };
    AlertDialog.Builder builder;
    public firstfragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.activity_fristfrgment,container,false);
        dbHelper = new MyDatabaseHelper(getActivity(), "gaokao.db", null, 1);
        db = dbHelper.getWritableDatabase();
        builder = new AlertDialog.Builder(getActivity());
        setView();
        mark[0]=-1;
        mark[1]=-1;
        mark[2]=-1;
        recyclerView = view.findViewById(R.id.recycler_view);

        Cursor c = db.query("college", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                int change=0;
               College college=new College(c.getString(c.getColumnIndex("school")));
                for(int t=0;t<train.size();t++) {
                    if (train.get(t).getName().equals(college.getName())){
                        change=1;
                    }
                }
                if(change==0){
                    train.add(college);
                    itemsum++;
                }
            } while (c.moveToNext());
        }
        itemsim=new double[itemsum][itemsum];
        itemsom=new double[itemsum];
        result=new double[itemsum];
        c.close();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());       //线性布局
        recyclerView.setLayoutManager(layoutManager);                               //RecyclerView加载线性布局
        CollegeAdapter adapter = new CollegeAdapter(selectCollege());                //创建课程类适配器，参数为刚查询到的存有课程信息的CourseList
        recyclerView.setAdapter(adapter);
        button1=(Button)view.findViewById(R.id.f_button1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intentSimple = new Intent();
                intentSimple.setClass(getActivity(), first_tuActivity.class);
                startActivity(intentSimple);
            }
        });
         mTextView = (TextView) view.findViewById(R.id.t_search);
         mEditText = (EditText) view.findViewById(R.id.search);
        mTextView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //如果输入框内容为空，提示请输入搜索内容
                if(TextUtils.isEmpty(mEditText.getText().toString().trim())){
                    Toast.makeText(getActivity(),"请输入内容",Toast.LENGTH_SHORT).show();
                }else {
                    //判断cursor是否为空
                    String str = mEditText.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), s_resultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("gates", str);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    getActivity().finish();
                }


            }
        });

        button2=(Button)view.findViewById(R.id.f_button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(),test_sub.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private void setView(){
        mViewPaper = (ViewPager)view.findViewById(R.id.vp);

        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(view.findViewById(R.id.dot_0));
        dots.add(view.findViewById(R.id.dot_1));
        dots.add(view.findViewById(R.id.dot_2));
        dots.add(view.findViewById(R.id.dot_3));
        dots.add(view.findViewById(R.id.dot_4));

        title = (TextView) view.findViewById(R.id.title);
        title.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dot_yes);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_no);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }
    public class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//          super.destroyItem(container, position, object);
//          view.removeView(view.getChildAt(position));
//          view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }

    public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.ViewHolder>{

        private List<College>  collegeList;

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
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_view, parent, false);
            final ViewHolder holder = new ViewHolder(view);
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
                    // Toast.makeText(v.getContext(), "you clicked view " + college.getName(), Toast.LENGTH_SHORT).show();

                }
            });

            return holder;
        }

        @Override
        /**
         * 将课程信息显示在textView上
         */
        public void onBindViewHolder(ViewHolder holder, int position) {
            College college = collegeList.get(position);
            holder.CollegeInfo.setText(college.getName());
            holder.CollegeInfo2.setText("城市："+college.getCity());
        }

        @Override
        public int getItemCount() {
            return collegeList.size();
        }

    }
    public List<College> selectCollege() {
        List<College> collegeList = new ArrayList<College>();
        Cursor c5 = db.query("normal", null, null, null, null, null, null);
        if (c5.moveToFirst()) {
            if (c5.getString(c5.getColumnIndex("s_school")).equals("") && c5.getString(c5.getColumnIndex("w_school")).equals("") && c5.getString(c5.getColumnIndex("f_school")).equals("")) {

                String province = c5.getString(c5.getColumnIndex("province"));
                Cursor c6 = db.query("college", null, null, null, null, null, null);
                if (c6.moveToFirst()) {
                    do {
                        if (c6.getString(c6.getColumnIndex("province")).equals("吉林")) {

                            College college = new College();
                            college.setName(c6.getString(c6.getColumnIndex("school")));
                            college.setCity(c6.getString(c6.getColumnIndex("province")));
                            int who=0;
                            for (int i = 0; i < collegeList.size(); i++) {
                                if (collegeList.get(i).getName().equals(college.getName())) {
                                    who=1;
                                }
                            }
                            if(who==0){
                                collegeList.add(college);
                            }
                        }
                    } while (c6.moveToNext());
                }
                c6.close();
                return collegeList;
            } else {
                if(ss.equals(c5.getString(c5.getColumnIndex("s_school")))&&ws.equals(c5.getString(c5.getColumnIndex("w_school")))&&fs.equals(c5.getString(c5.getColumnIndex("f_school")))){
                    return  collegeList1;
                }else {
                    ss = c5.getString(c5.getColumnIndex("s_school"));
                    ws = c5.getString(c5.getColumnIndex("w_school"));
                    fs = c5.getString(c5.getColumnIndex("f_school"));
                    getdistense();
                    int tie = 0, tie1 = 0, tie2 = 0;
                    double b1, b2, b3;
                    b1 = result[0];
                    for (int a = 1; a < itemsum; a++) {
                        if (result[a] > b1 && a != mark[0]) {
                            b1 = result[a];
                            tie = a;
                        }
                    }
                    b2 = result[0];
                    for (int a = 1; a < itemsum; a++) {
                        if (result[a] > b2 && a != mark[0] && a != tie) {
                            b2 = result[a];
                            tie1 = a;
                        }
                    }
                    b3 = result[0];
                    for (int a = 1; a < itemsum; a++) {
                        if (result[a] > b3 && a != mark[0] && a != tie && a != tie1) {
                            b3 = result[a];
                            tie2 = a;
                        }
                    }
                    if (tie == 0) {
                        return collegeList;
                    }
                    int num = 0;
                    int flag = 2;

                    Cursor c4 = db.query("college", null, null, null, null, null, null);
                    if (c4.moveToFirst()) {
                        do {
                            if (flag % 2 == 0) {
                                if (num == tie || num == tie1 || num == tie2) {
                                    College college = new College();
                                    college.setName(c4.getString(c4.getColumnIndex("school")));
                                    college.setCity(c4.getString(c4.getColumnIndex("province")));
                                    collegeList.add(college);
                                }
                                num++;
                            }
                            flag++;
                        } while (c4.moveToNext());
                    }
                    c4.close();
                    collegeList1.clear();
                    for (int i = 0; i < collegeList.size(); i++) {
                        collegeList1.add(collegeList.get(i));
                    }
                    return collegeList;
                }
            }
        }
        return collegeList;

    }




    /**
     * 图片轮播任务
     * @author liuyazhuang
     *
     */
    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        };
    };
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if(scheduledExecutorService != null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }
    private void getdistense() {
        //求大学之间的相似矩阵
        Cursor c3 = db.query("normal", null, null, null, null, null, null);
        if (c3.moveToFirst()) {
            name[0]=c3.getString(c3.getColumnIndex("s_school"));
           name[1]=c3.getString(c3.getColumnIndex("f_school"));
            name[2]=c3.getString(c3.getColumnIndex("w_school"));
        }
        for (int i = 0; i < itemsum; i++) {
            for (int j = 0; j < itemsum; j++) {
                itemsim[i][j] = Simility(train.get(i), train.get(j));
            }
        }
            int count=0;
            int flag=2;
                Cursor c2 = db.query("college", null, null, null, null, null, null);
                if (c2.moveToFirst()) {
                    do{
                        if(flag%2==0) {
                            if (c2.getString(c2.getColumnIndex("school")).equals(name[0])) {
                                itemsom[count] = 2.0;
                                mark[0] = count;
                            } else {
                                if (c2.getString(c2.getColumnIndex("school")).equals(name[1])) {
                                    itemsom[count] = 3.0;
                                    mark[1] = count;
                                } else {
                                    if (c2.getString(c2.getColumnIndex("school")).equals(name[2])) {
                                        itemsom[count] = 3.5;
                                        mark[2] = count;
                                    } else {
                                        if(count>=itemsum)
                                            break;
                                        else
                                        itemsom[count] = 0;
                                    }
                                }
                            }
                            count++;
                        }
                        flag++;
                    }while (c2.moveToNext());
                }
               for(int a = 0;a<itemsim.length;a++)
             {
      		for(int k = 0;k<itemsim.length;k++)
              {
                   result[a] += itemsim[a][k]*itemsom[k];
              }
         }


    }
    public  double Simility(College A, College B)
    {
        int comUser = 0;                   //两所大学都被用户收藏（报考）的数量
        double simility = 0.0;
        int countIa = 0;
        int countIb = 0;
        int i,ItemA,ItemB;
        Cursor c1 = db.query("history", null, null, null, null, null, null);
        if (c1.moveToFirst()) {
            do {
              if((c1.getString(c1.getColumnIndex("hot1")).equals(A.getName()))&&(c1.getString(c1.getColumnIndex("hot2")).equals(B.getName()))){
                  comUser++;
              }
                if((c1.getString(c1.getColumnIndex("hot1")).equals(A.getName()))&&(c1.getString(c1.getColumnIndex("hot3")).equals(B.getName()))){
                    comUser++;
                }
                if((c1.getString(c1.getColumnIndex("hot2")).equals(A.getName()))&&(c1.getString(c1.getColumnIndex("hot3")).equals(B.getName()))){
                    comUser++;
                }
                if((c1.getString(c1.getColumnIndex("hot2")).equals(A.getName()))&&(c1.getString(c1.getColumnIndex("hot1")).equals(B.getName()))){
                    comUser++;
                }
                if((c1.getString(c1.getColumnIndex("hot3")).equals(A.getName()))&&(c1.getString(c1.getColumnIndex("hot2")).equals(B.getName()))){
                    comUser++;
                }
                if((c1.getString(c1.getColumnIndex("hot3")).equals(A.getName()))&&(c1.getString(c1.getColumnIndex("hot1")).equals(B.getName()))){
                    comUser++;
                }
                if(c1.getString(c1.getColumnIndex("hot1")).equals(A.getName())||c1.getString(c1.getColumnIndex("hot2")).equals(A.getName())||c1.getString(c1.getColumnIndex("hot3")).equals(A.getName())){
                    countIa++;
                }
                if(c1.getString(c1.getColumnIndex("hot1")).equals(B.getName())||c1.getString(c1.getColumnIndex("hot2")).equals(B.getName())||c1.getString(c1.getColumnIndex("hot3")).equals(B.getName())){
                    countIb++;
                }
            } while (c1.moveToNext());
        }

            if(A.getName().equals(B.getName())){
                return 0;
            }
            else {
                return comUser;
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
}
