package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.wangyang.tinnerwangyang.Adapter.ViewpageAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Photos;
import com.example.wangyang.tinnerwangyang.Bean.UrlSettingBean;
import com.example.wangyang.tinnerwangyang.ImageReceiver;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityBigImageBinding;

import java.util.ArrayList;
import java.util.List;

public class BigImageActivity extends BaseActivity {
    private ViewPager viewPager;
    private ActivityBigImageBinding binding;
    private ViewpageAdapter adapter;
    private List<Photos> photos;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_big_image);


    }

    @Override
    protected void onStart() {
        super.onStart();
        inittoppage();
        initendpage();
    }

    private void inittoppage() {
        viewPager = binding.viewpagerImage;
        adapter = new ViewpageAdapter(BigImageActivity.this);
        photos = (List<Photos>) getIntent().getSerializableExtra("imageList");
        i = getIntent().getIntExtra("imageid", 0);
        viewPager.setAdapter(adapter);
        adapter.addData(photos);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        viewPager.setCurrentItem(i);
    }

    private void initendpage() {
        //点击底部图标
        for (int i = 0; i < adapter.getCount(); i++) {
            View tabView1 = ViewUtils.getInflater(BigImageActivity.this).inflate(R.layout.item_ind_bg, null);
            binding.imageLinearout.addView(tabView1);
            final int index = i;
            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(index);
                }
            };
            tabView1.setOnClickListener(clickListener);
        }
        onPageChangeListener.onPageSelected(0);
    }


    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < binding.imageLinearout.getChildCount(); i++) {
                if (i == viewPager.getCurrentItem()) {
                    binding.imageLinearout.getChildAt(i).findViewById(R.id.chk).setSelected(true);
                } else {
                    binding.imageLinearout.getChildAt(i).findViewById(R.id.chk).setSelected(false);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}


