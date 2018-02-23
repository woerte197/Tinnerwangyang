package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Intent;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.WebActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.Bean.ShareBean;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.databinding.LayoutNewsBinding;
import com.lib.Intent.Intentclass;
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
            ShareBean shareBean=new ShareBean();
            shareBean.setTitle(model.getTitle());
            shareBean.setImageurl(model.getPic_url());
            shareBean.setUrl(model.getLink_url());
             Intentclass.IntentWebActivity(context,shareBean);
        });

    }
}
