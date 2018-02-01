package com.example.wangyang.tinnerwangyang.fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.MyBean;
import com.example.wangyang.tinnerwangyang.Bean.MyItem;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.MessageCode;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.FragmentTabUserBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabUserFragment extends BindFragment<FragmentTabUserBinding> {
    private BaseRecyclerAdapter adapter;
    private LinearLayoutManager manager;
    private List<Wachter> list;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initpage();
        initData();
    }

    private void initData() {
        adapter.addData(list);
        bindView.recycleMe.setLayoutManager(manager);
        bindView.recycleMe.setAdapter(adapter);
    }

    private void initpage() {
        adapter = new BaseRecyclerAdapter((BaseActivity) getActivity());
        manager = new LinearLayoutManager(getActivity());
        list = new ArrayList<>();
        MyBean myBean = new MyBean("王洋", "wangyang");
        MyItem myItem1 = new MyItem("健康习惯", false, true, R.drawable.health_icon, 0);
        MyItem myItem2 = new MyItem("饮食记录", false, false, R.drawable.food_icon, 1);
        MyItem myItem3 = new MyItem("体重记录", false, false, R.drawable.weight_icon, 2);
        MyItem myItem4 = new MyItem("运动记录", false, true, R.drawable.sport_icon, 3);
        MyItem myItem5 = new MyItem("今日步数", false, false, R.drawable.foot_icon, 4);
        MyItem myItem6 = new MyItem("退出登录", false, false, R.drawable.log_out_icon, 5);
        if (SharePrefUtils.getInstance().isLogin()) {
            list.add(myBean);
            list.add(myItem1);
            list.add(myItem2);
            list.add(myItem3);
            list.add(myItem4);
            list.add(myItem5);
            list.add(myItem6);
        }else {
            list.add(myBean);
            list.add(myItem1);
            list.add(myItem2);
            list.add(myItem3);
            list.add(myItem4);
            list.add(myItem5);
        }

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_user;
    }

    @Override
    public void update(int msg, Object args) {
        super.update(msg, args);
        switch (msg) {
            case MessageCode.RESULT_LOGOUT:
                initpage();
                initData();
                break;
    }
}}
