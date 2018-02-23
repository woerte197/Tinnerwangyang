package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Intent;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.WebActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.GrassesBean;
import com.example.wangyang.tinnerwangyang.Bean.ShareBean;
import com.example.wangyang.tinnerwangyang.Bean.SlidersBean;
import com.example.wangyang.tinnerwangyang.databinding.LayoutHealthChannelBinding;
import com.lib.Intent.Intentclass;

import java.util.List;

/**
 * Created by wangyang on 5/1/18.
 */

public class RecommendHealthChannelHolder extends BaseRecyclerHolder<GrassesBean, LayoutHealthChannelBinding> {
    public RecommendHealthChannelHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(GrassesBean model, int position, BaseRecyclerAdapter adapter) {
        bindView.setGrassesbean(model);
        bindView.setP(() -> {
            ShareBean shareBean = new ShareBean();
            shareBean.setImageurl(model.getAvatar_url());
            shareBean.setTitle(model.getTitle());
            Intentclass.IntentWebActivity(context, shareBean);
        });


    }
}
