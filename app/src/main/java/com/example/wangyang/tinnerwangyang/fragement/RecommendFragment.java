package com.example.wangyang.tinnerwangyang.fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.GrassesBean;
import com.example.wangyang.tinnerwangyang.Bean.HotEventsBean;
import com.example.wangyang.tinnerwangyang.Bean.NewsTitle;
import com.example.wangyang.tinnerwangyang.Bean.RecommendBean;
import com.example.wangyang.tinnerwangyang.Http.Internet.ApiFactory;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.databinding.FragmentSuccessStoryBinding;
import com.lib.Manager.FileUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BindFragment<FragmentSuccessStoryBinding> {
    private static final String TAG = RecommendFragment.class.getSimpleName();
    BaseRecyclerAdapter adapter;
    RecommendBean recommendBean;
    Subscription subscription;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initpage();
        success(FileUtils.getRecommendData());
        // initdata();
    }

    private void initpage() {
        adapter = new BaseRecyclerAdapter(getBaseActivity());
        bindView.recycleRecommend.setLayoutManager(new LinearLayoutManager(getBaseActivity()));
        bindView.recycleRecommend.setAdapter(adapter);
        bindView.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //  initdata();
                bindView.refreshLayout.setRefreshing(false);
            }
        });
    }  

//    public void initdata() {
//        subscription = ApiFactory.ins().getNewslist("UYPxayY3SxmRRhtfoG6N",
//                "b3f61884-b31c-4320-85aa-56253204918e",
//                "6.1.1", "Android",
//                "7.0", "VTR-AL00", "boohee", "one")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe((RecommendBean) -> success(RecommendBean), throwable -> showMsg("请检查网络重试"));
//    }

    private void success(RecommendBean r) {
        List<Wachter> list = new ArrayList<>();
        recommendBean = new RecommendBean();
        recommendBean = r;
        list.add(recommendBean);
        NewsTitle newsTitle = new NewsTitle();
        List<GrassesBean> grassesBeans = recommendBean.getGrasses();
        Log.i(TAG, String.format("grassbeans" + grassesBeans));
        list.addAll(grassesBeans);
        newsTitle.setName("精彩活动");
        newsTitle.setMore("更多 >");
        list.add(newsTitle);
        List<HotEventsBean> hotEventsBeans = recommendBean.getHot_events();
        list.addAll(hotEventsBeans);
        adapter.addData(list);
        Log.i(TAG, String.format("SlidersBean" + recommendBean));
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_success_story;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
