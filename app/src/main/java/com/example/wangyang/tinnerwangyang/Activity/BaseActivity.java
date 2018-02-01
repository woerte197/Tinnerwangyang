package com.example.wangyang.tinnerwangyang.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.Exit.MyApplication;
import com.example.wangyang.tinnerwangyang.R;
import com.lib.Manager.EventBusManager;
import com.lib.Manager.EventMessage;
import com.lib.Manager.MessageListener;

public class BaseActivity extends AppCompatActivity implements MessageListener {
    private FragmentManager mFragmentManager;
    private MyApplication mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mFragmentManager =getSupportFragmentManager();
        mApp = ECKit.getApp();
        EventBusManager.getEventBus().register(this);
    }

    public int addFragment(int containerViewId, Fragment fragment, boolean back) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        try {
            transaction.add(containerViewId, fragment);
            if (back) {
                transaction.addToBackStack(null);
            }
        } catch (Exception e) {

        }
        return transaction.commit();

    }
    public void onEventMainThread(EventMessage msg){
        this.update(msg.getMsgId(),msg.getObject());
    }
    public void showFragmentTab(Fragment fragment) {
        FragmentTransaction trx = mFragmentManager.beginTransaction();
        trx.show(fragment).commitAllowingStateLoss();
    }
    public void hideFragmentTab(Fragment fragment) {
        try {
            FragmentTransaction trx = mFragmentManager.beginTransaction();
            trx.hide(fragment).commitAllowingStateLoss();
        }catch (Exception e){

        }
    }

    @Override
    public void update(int msg, Object args) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusManager.getEventBus().unregister(this);
    }
}
