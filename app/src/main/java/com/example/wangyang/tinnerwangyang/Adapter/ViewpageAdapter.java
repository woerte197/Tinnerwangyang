package com.example.wangyang.tinnerwangyang.Adapter;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wangyang.tinnerwangyang.Bean.Photos;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.databinding.LayoutBigImageItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 23/1/18.
 */

public class ViewpageAdapter extends PagerAdapter {
    private Context context;
    private List<Photos> list;

    public ViewpageAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void addData(List<Photos> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {//必须实现
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//必须实现，实例化
        ImageView imageView = new ImageView(context);
        Picasso.with(context).load(list.get(position).getBig_url()).into(imageView);
        container.addView(imageView);
        return imageView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//必须实现，销毁
        container.removeView((View) object);
    }


}
