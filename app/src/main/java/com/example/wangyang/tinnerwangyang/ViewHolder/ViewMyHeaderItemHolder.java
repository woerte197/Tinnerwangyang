package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.MyBean;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.LayoutMyBinding;
import com.lib.Intent.Intentclass;
import com.squareup.picasso.Picasso;

/**
 * Created by wangyang on 23/1/18.
 */

public class ViewMyHeaderItemHolder extends BaseRecyclerHolder<MyBean, LayoutMyBinding> {
    public ViewMyHeaderItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(MyBean model, int position, BaseRecyclerAdapter adapter) {
        if (SharePrefUtils.getInstance().isLogin()) {
            bindView.setMy(model);
            Picasso.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516702396822&di=6018dea695aece784996649560cd9860&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd8f9d72a6059252de39131f2359b033b5ab5b945.jpg")
                    .into(bindView.myImage);
            bindView.linearLogin.setVisibility(View.GONE);
        } else {
            bindView.textName.setText("点击登录");
            bindView.setP(() -> {
                Intentclass.IntentLoginActivity(context);
            });
        }
    }
}
