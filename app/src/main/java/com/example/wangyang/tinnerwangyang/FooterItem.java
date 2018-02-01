package com.example.wangyang.tinnerwangyang;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by nanchaodong on 2017/3/8.
 */

public class FooterItem extends BaseObservable implements Wachter {
    public static final String TYPE = "FooterItem";
    private int msgId = 0; //0,加载中 1，加载失败 2，没有更多数据
    private String msg;
    private boolean showFooter = true;

    public FooterItem() {
    }


    public void setMsgId(int msgId) {
        this.msgId = msgId;
        notifyPropertyChanged(BR.msg);
        notifyPropertyChanged(BR.msgId);
    }
    @Bindable
    public int getMsgId() {
        return msgId;
    }

    @Bindable
    public String getMsg() {
        switch (msgId) {
            case 0:
                msg = "正在加载中...";
                break;
            case 1:
                msg = "加载失败,检查网络";
                break;
            case 2:
                msg = "只有这么多啦";
                break;
        }
        return msg;
    }
    @Bindable
    public boolean isShowFooter() {
        return showFooter;
    }

    public void setShowFooter(boolean showFooter) {
        this.showFooter = showFooter;
        notifyPropertyChanged(BR.showFooter);
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
