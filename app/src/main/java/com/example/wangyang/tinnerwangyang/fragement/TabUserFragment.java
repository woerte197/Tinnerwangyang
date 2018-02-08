package com.example.wangyang.tinnerwangyang.fragement;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.BaseUiListener;
import com.example.wangyang.tinnerwangyang.Activity.LoginActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.MyBean;
import com.example.wangyang.tinnerwangyang.Bean.MyItem;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.MessageCode;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.FragmentTabUserBinding;
import com.google.gson.Gson;
import com.lib.Intent.Intentclass;
import com.lib.Manager.TecentManager;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabUserFragment extends BindFragment<FragmentTabUserBinding> {
    private BaseRecyclerAdapter adapter;
    private LinearLayoutManager manager;
    private List<Wachter> list;
    private MyBean myBean;
    private MyItem myItem1 = new MyItem("健康习惯", false, true, R.drawable.health_icon, 0);
    private MyItem myItem2 = new MyItem("饮食记录", false, false, R.drawable.food_icon, 1);
    private MyItem myItem3 = new MyItem("体重记录", false, false, R.drawable.weight_icon, 2);
    private MyItem myItem4 = new MyItem("运动记录", false, true, R.drawable.sport_icon, 3);
    private MyItem myItem5 = new MyItem("今日步数", false, false, R.drawable.foot_icon, 4);
    private MyItem myItem6 = new MyItem("退出登录", false, false, R.drawable.log_out_icon, 5);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initpage();
    }

    private void initpage() {
        list = new ArrayList<>();
        adapter = new BaseRecyclerAdapter((BaseActivity) getActivity());
        manager = new LinearLayoutManager(getActivity());
        if (SharePrefUtils.getInstance().isLogin()) {
            if (SharePrefUtils.getInstance().getLogintype() == 1) {
                String mybean = SharePrefUtils.getInstance().getMyBean();
                Gson gson = new Gson();
                myBean = gson.fromJson(mybean, MyBean.class);
            }
            if (SharePrefUtils.getInstance().getLogintype() == 2) {
                myBean = new MyBean("王洋", "wangyang");
            }
            list.add(myBean);
            list.add(myItem1);
            list.add(myItem2);
            list.add(myItem3);
            list.add(myItem4);
            list.add(myItem5);
            list.add(myItem6);
        } else {
            myBean = new MyBean("王洋", "wangyang");
            list.add(myBean);
        }
        bindView.recycleMe.setLayoutManager(manager);
        bindView.recycleMe.setAdapter(adapter);
        adapter.addData(list);
    }

    @Override
    public void onResume() {
        super.onResume();
        initpage();
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
                break;
        }
    }
}
