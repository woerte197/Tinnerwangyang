package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Intent;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.WebActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.databinding.LayoutNewsBinding;
import com.lib.view.RoundImageview;

/**
 * Created by wangyang on 29/12/17.
 */

public class ViewNewsHolder extends BaseRecyclerHolder<Knowledges, LayoutNewsBinding> {
    public ViewNewsHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setUpView(Knowledges model, int position, BaseRecyclerAdapter adapter) {
        bindView.setKnowledges(model);
        bindView.setPersenet(Knowledges->{
            String url=model.getLink_url();
            Intent intent=new Intent();
            intent.putExtra("url",url);
            intent.setClass((BaseActivity)context, WebActivity.class);
            context.startActivity(intent);
        });

    }
}
