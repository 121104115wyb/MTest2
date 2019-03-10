package com.btzh.mtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ConcurrentModificationException;
import java.util.List;

public class MyAdapter extends PagerAdapter {

    private List<View> viewList;
    private View.OnClickListener onItemClickListener;
    private Context context;
    public MyAdapter(List<View> viewList, Context context) {
        this.viewList = viewList;
        this.context = context;

    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewList.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        View curView = viewList.get(position);
        curView.setOnClickListener(new MyClickListener());
        container.addView(curView);
        return curView;
    }

    public void setOnItemClickListener(AdapterView.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.image1:

                    Toast.makeText(context, "我是image1", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.image2:
                    Toast.makeText(context, "image2", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.image3:
                    Toast.makeText(context, "我是image3", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }



}
