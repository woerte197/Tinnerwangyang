package com.example.wangyang.tinnerwangyang.Adapter;

import android.content.Context;


import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.FooterItem;
import com.example.wangyang.tinnerwangyang.Wachter;

import java.util.List;

public class FootRecyclerAdapter extends BaseRecyclerAdapter {
    protected FooterItem footerItem;


    public FootRecyclerAdapter(Context context) {
        super(context);
        footerItem = new FooterItem();
    }


    @Override
    public <T extends Wachter> void addData(List<T> list) {
        this.datas.clear();
        notifyDataSetChanged();
        this.datas.addAll(list);
        this.datas.add(footerItem);
        notifyItemRangeChanged(0, this.datas.size());
    }

    public void addLoadData(List<Wachter> list) {
        this.datas.remove(footerItem);
        int startIndex = this.datas.size();
        this.datas.addAll(list);
        this.datas.add(footerItem);
        notifyItemRangeChanged(startIndex, this.datas.size() - startIndex);
    }

    @Override
    public <T extends Wachter> void addBean(T t) {
        this.datas.remove(footerItem);
        int startIndex = this.datas.size();
        this.datas.add(t);
        this.datas.add(footerItem);
        notifyItemRangeChanged(startIndex, this.datas.size() - startIndex);
    }

    public void setFooterMsgId(int msgId) {
        footerItem.setShowFooter(true);
        footerItem.setMsgId(msgId);
        if (!datas.contains(footerItem)) {
            datas.add(footerItem);
        }

    }

    @Override
    public List<Wachter> getDatas() {
        this.datas.remove(footerItem);
        return datas;
    }

    public void showFooter() {
        footerItem.setShowFooter(true);
    }

    public void hideFooter() {
        footerItem.setShowFooter(false);
    }

    public FooterItem getFooterItem() {
        return footerItem;
    }
}
