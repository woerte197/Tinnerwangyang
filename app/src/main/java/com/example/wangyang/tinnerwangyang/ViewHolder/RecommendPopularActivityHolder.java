package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.HotEventsBean;
import com.example.wangyang.tinnerwangyang.Bean.ShareBean;
import com.example.wangyang.tinnerwangyang.databinding.LayoutPopularActivityBinding;
import com.lib.Intent.Intentclass;

/**
 * Created by wangyang on 5/1/18.
 */

public class RecommendPopularActivityHolder extends BaseRecyclerHolder<HotEventsBean, LayoutPopularActivityBinding> {

    public RecommendPopularActivityHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(HotEventsBean model, int position, BaseRecyclerAdapter adapter) {
        bindView.setHotevent(model);
        bindView.setPresenter(() -> {
            ShareBean shareBean = new ShareBean();
            shareBean.setUrl(model.getLink_url());
            shareBean.setImageurl(model.getBanner_url());
            shareBean.setTitle(model.getTitle());
            Intentclass.IntentWebActivity(context, shareBean);
        });
    }
}
