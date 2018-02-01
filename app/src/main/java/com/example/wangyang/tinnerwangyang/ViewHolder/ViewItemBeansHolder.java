package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Intent;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.WebActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.ItemsBean;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.databinding.LayoutItembeansBinding;
import com.example.wangyang.tinnerwangyang.databinding.LayoutNewsBinding;

import java.util.List;

/**
 * Created by wangyang on 29/12/17.
 */

public class ViewItemBeansHolder extends BaseRecyclerHolder<ItemsBean, LayoutItembeansBinding> {
    public ViewItemBeansHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setUpView(ItemsBean model, int position, BaseRecyclerAdapter adapter) {
        bindView.setKnowledges(model);
        List<String> strings = model.getTags();
        String ct = "";//定义一个字符串
        for(int i=0;i<strings.size();i++){
            ct = ct + strings.get(i);//数组拼接成字符串
            bindView.itemsBeanTextview.setText(ct);
        }

        bindView.setPersenet(Knowledges -> {
            String url = model.getUrl();
            Intent intent = new Intent();
            intent.putExtra("url", url);
            intent.setClass((BaseActivity) context, WebActivity.class);
            context.startActivity(intent);
        });

    }
}
