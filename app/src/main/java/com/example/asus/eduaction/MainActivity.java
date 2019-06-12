package com.example.asus.eduaction;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;
//数据库类
/*class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_PERSON = "create table person ("
            + "name text, "
            + "sex text, "
            + "email text primary key, "
            + "password text, "
            + "preference text, "
            + "area text)";
    public static final String chengjixian = "create table xian ("
            + "admit text, "
            + "year text, "
            + "score_first text, "
            + "score_second text, "
            + "score_third text)";
    private Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }*/
//滑动栏类
class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }

}
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    long startTime = 0;
    MenuItem prevMenuItem;
    com.example.asus.eduaction.secondfragment secondfragment;
    com.example.asus.eduaction.firstfragment firstfragment;
    com.example.asus.eduaction.thirdfragment thirdfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

    }
  public void  initview(){
      viewPager = (ViewPager) findViewById(R.id.viewpager);
      bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

      bottomNavigationView.setOnNavigationItemSelectedListener(
              new BottomNavigationView.OnNavigationItemSelectedListener() {
                  @Override
                  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                      switch (item.getItemId()) {
                          case R.id.action_first:
                              viewPager.setCurrentItem(0);
                              break;
                          case R.id.action_second:
                              viewPager.setCurrentItem(1);
                              break;
                          case R.id.action_third:
                              viewPager.setCurrentItem(2);
                              break;
                      }
                      return false;
                  }
              });
      setupViewPager(viewPager);
      viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

          }

          @Override
          public void onPageSelected(int position) {
              if (prevMenuItem != null) {
                  prevMenuItem.setChecked(false);
              }
              else
              {
                  bottomNavigationView.getMenu().getItem(0).setChecked(false);
              }
              Log.d("page", "onPageSelected: "+position);
              bottomNavigationView.getMenu().getItem(position).setChecked(true);
              prevMenuItem = bottomNavigationView.getMenu().getItem(position);

          }

          @Override
          public void onPageScrollStateChanged(int state) {

          }
      });

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        firstfragment=new firstfragment();
        secondfragment=new secondfragment();
        thirdfragment=new thirdfragment();
        adapter.addFragment(firstfragment);
        adapter.addFragment(secondfragment);
        adapter.addFragment(thirdfragment);
        viewPager.setAdapter(adapter);
    }
    //双击退出程序
    public void onBackPressed() {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - startTime) >= 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
                startTime = currentTime;
            } else {
                finish();
            }
    }
}
