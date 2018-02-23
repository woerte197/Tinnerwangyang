package com.example.wangyang.tinnerwangyang.fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Adapter.FootRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;
import com.example.wangyang.tinnerwangyang.Bean.UrlSettingBean;
import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.RefreshListListener;
import com.example.wangyang.tinnerwangyang.common.RefreshNewsList;
import com.example.wangyang.tinnerwangyang.common.RefreshRecyList;
import com.example.wangyang.tinnerwangyang.common.Request;
import com.example.wangyang.tinnerwangyang.databinding.FragmentWeightKnowledgeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends BindFragment<FragmentWeightKnowledgeBinding> implements RefreshListListener {
    FootRecyclerAdapter adapter;
    Request request;
    RefreshNewsList<PostsBean> refreshRecyList;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initdata();
    }

    private void initdata() {
        adapter=new FootRecyclerAdapter(getBaseActivity());
//        request=new Request(URLSetting.URL_newSelect, Constant.TYPE_RESULT_POSTSBEANS,URLSetting.URL_NewRecommend);
//        refreshRecyList=new RefreshRecyList<PostsBean>(adapter,bindView.recycleKnowledges,bindView.refreshKnowledges,request);
//        refreshRecyList.setLayoutManager(new GridLayoutManager((BaseActivity)getActivity(), 1))
//                .addButtomListener()
//                .addTopListener()
//                .setOldVersion(false)
//                .setRefreshListListener(this);
//        refreshRecyList.loadTop();
//        adapter=new FootRecyclerAdapter(getBaseActivity());
        request=new Request();
        refreshRecyList=new RefreshNewsList<PostsBean>(adapter,bindView.recycleKnowledges,bindView.refreshKnowledges,request,3);
        refreshRecyList.setLayoutManager(new GridLayoutManager((BaseActivity)getActivity(), 1))
                .addButtomListener()
                .addTopListener()
                .setOldVersion(false)
                .setRefreshListListener(this);
        refreshRecyList.loadTop();


    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_weight_knowledge;
    }

    @Override
    public void top(List list) {
     List<Wachter> list1=new ArrayList<>();
     list1.addAll(list);
     adapter.addData(list1);
    }

    @Override
    public void topError(int error) {

    }

    @Override
    public void bottom(List list) {
        List<Wachter> data = list;
        adapter.addLoadData(data);
    }

}
