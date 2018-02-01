package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Intent;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.WebActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.GrassesBean;
import com.example.wangyang.tinnerwangyang.Bean.SlidersBean;
import com.example.wangyang.tinnerwangyang.databinding.LayoutHealthChannelBinding;

import java.util.List;

/**
 * Created by wangyang on 5/1/18.
 */

public class RecommendHealthChannelHolder extends BaseRecyclerHolder<GrassesBean,LayoutHealthChannelBinding> {
    public RecommendHealthChannelHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(GrassesBean model, int position, BaseRecyclerAdapter adapter) {
        bindView.setGrassesbean(model);
        bindView.setP(()->{
            String url=model.getAvatar_url();
            Intent intent=new Intent();
            intent.putExtra("url",url);
            intent.setClass((BaseActivity)context, WebActivity.class);
            context.startActivity(intent);
        });


    }
}
