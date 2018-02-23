package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.KnowledgesActivity;
import com.example.wangyang.tinnerwangyang.Activity.SuccessActivity;
import com.example.wangyang.tinnerwangyang.Activity.WebActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.RecommendBean;
import com.example.wangyang.tinnerwangyang.Bean.ShareBean;
import com.example.wangyang.tinnerwangyang.Bean.SlidersBean;
import com.example.wangyang.tinnerwangyang.databinding.LayoutRecommendBinnerBinding;
import com.lib.Intent.Intentclass;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangyang on 5/1/18.
 */

public class RecommendBannerHolder extends BaseRecyclerHolder<RecommendBean, LayoutRecommendBinnerBinding> {

    public RecommendBannerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(RecommendBean model, int position, BaseRecyclerAdapter adapter) {
        List<String> list = new ArrayList<>();
        List<SlidersBean> slidersBeanList = model.getSliders();
        for (SlidersBean s : slidersBeanList) {
            list.add(s.getPic_url());
        }
        bindView.banner.setIndicatorGravity(BannerConfig.CENTER);
        bindView.banner.setImages(list).setImageLoader(new GlideImageLoader()).start();
        bindView.banner.setOnBannerClickListener(position1 -> {
            String url = slidersBeanList.get(position1 - 1).getUrl();
            ShareBean shareBean = new ShareBean();
            shareBean.setUrl(url);
            shareBean.setTitle(slidersBeanList.get(position1 - 1).getTitle());
            shareBean.setImageurl(slidersBeanList.get(position1 - 1).getPic_url());
            Intentclass.IntentWebActivity(context, shareBean);
        });
        bindView.setP(() -> {
            Intent intent = new Intent();
            intent.setClass((BaseActivity) context, KnowledgesActivity.class);
            context.startActivity(intent);

        });
        bindView.setPa(() -> {
            Intent intent = new Intent();
            intent.setClass((BaseActivity) context, SuccessActivity.class);
            context.startActivity(intent);
        });
    }
}
