package com.btzh.mtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ViewPager viewPager;
    private List<View> viewList = new ArrayList<>();
    private PagerAdapter adapter;
    private MyAdapter myAdapter;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);

                    startActivity(new Intent(MainActivity.this, Main2Activity.class));

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_notificationss:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_dashboard);

        final View view1 = LayoutInflater.from(this).inflate(R.layout.viewpage1, null);
        final View view2 = LayoutInflater.from(this).inflate(R.layout.viewpage2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.viewpage3, null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        myAdapter = new MyAdapter(viewList,this);
//        myAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "我是"+position, Toast.LENGTH_SHORT).show();
//            }
//        });



//        adapter = new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return viewList.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//                return view == o;
//            }
//
//            @Override
//            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                container.removeView(viewList.get(position));
//            }
//
//            @NonNull
//            @Override
//            public Object instantiateItem(@NonNull ViewGroup container, int position) {
//                if (viewList != null && viewList.size() > 0) {
//                    container.addView(viewList.get(position));
//                }
//
//                return viewList.get(position);
//
//            }
//
//        };




        viewPager = findViewById(R.id.aaaaaaa);
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = viewPager.getCurrentItem();
                if (view1==viewList.get(current)){
                    Toast.makeText(MainActivity.this, "我是："+current, Toast.LENGTH_SHORT).show();
                }else if (view2==viewList.get(current)){
                    Toast.makeText(MainActivity.this, "我是："+current, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "我是："+current, Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            int flag = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        flag =0;
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        flag =1;
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        if (flag==0){
//                            int current = viewPager.getCurrentItem();
//                            if (view1==viewList.get(current)){
//                                Toast.makeText(MainActivity.this, "我是："+current, Toast.LENGTH_SHORT).show();
//                            }else if (view2==viewList.get(current)){
//                                Toast.makeText(MainActivity.this, "我是："+current, Toast.LENGTH_SHORT).show();
//                            }else {
//                                Toast.makeText(MainActivity.this, "我是："+current, Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        break;
                    case MotionEvent.ACTION_SCROLL:
                        flag = 8;
                        Toast.makeText(MainActivity.this, ""+flag, Toast.LENGTH_SHORT).show();
                        break;

                }

                return false;
            }
        });



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        viewPager.setAdapter(myAdapter);
    }

}
