package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.HotEventsBean;
import com.example.wangyang.tinnerwangyang.databinding.LayoutPopularActivityBinding;
import com.lib.Intent.Intentclass;

/**
 * Created by wangyang on 5/1/18.
 */

public class RecommendPopularActivityHolder extends BaseRecyclerHolder<HotEventsBean,LayoutPopularActivityBinding> {

    public RecommendPopularActivityHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(HotEventsBean model, int position, BaseRecyclerAdapter adapter) {
     bindView.setHotevent(model);
     bindView.setPresenter(() -> {
         Intentclass.IntentWebActivity(context,model.getLink_url());
     });
    }
}
