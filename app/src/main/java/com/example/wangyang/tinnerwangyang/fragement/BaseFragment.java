package com.example.wangyang.tinnerwangyang.fragement;


import android.content.Intent;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.Exit.MyApplication;
import com.example.wangyang.tinnerwangyang.Exit.SubsManager;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.lib.Manager.EventBusManager;
import com.lib.Manager.EventMessage;

import rx.Subscription;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    protected String title;
    protected MyApplication mApp;
    private BaseActivity context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBaseActivity();
        EventBusManager.getEventBus().register(this);
    }

    protected BaseActivity getBaseActivity() {
        if (context == null) {
            if (getActivity() instanceof BaseActivity) {
                context = (BaseActivity) getActivity();
                mApp = ECKit.getApp();

            }
        }
        return context;
    }
    public void onEventMainThread(EventMessage msg){
        this.update(msg.getMsgId(),msg.getObject());
    }
    public void showMsg(String msg) {
        ViewUtils.showMessage(msg);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBusManager.getEventBus().unregister(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String ti) {
        title = ti;
    }

    public void setTitle(int ti) {
        title = getString(ti);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void refresh() {

    }

    public void update(int msg, Object args) {
    }

    /**
     * 点击tab按钮后回调方法
     */
    public void onTabSelected() {

    }

    public void change() {

    }
    public int getPageSize() {
        return 0;
    }

    public boolean getEditStatus() {
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (EventManager.isRelease) {
//            if (!TextUtils.isEmpty(getPageTag()) && EventManager.isShowToast) {
//                ViewUtils.showMessage("onResume" + getPageTag());
//            }
//            MobclickAgent.onPageStart(getPageTag());
//            MobclickAgent.onEvent(getActivity(), getPageTag());
//        }

    }

    @Override
    public void onPause() {
        super.onPause();
//        if (EventManager.isRelease) {
//            MobclickAgent.onPageEnd(getPageTag());
//        }

    }

    /**
     * 获取页面标签
     *
     * @return
     */
    protected String getPageTag() {
        return null;
    }

    protected void addSub(Subscription s) {
        SubsManager.add(s);
    }
}

