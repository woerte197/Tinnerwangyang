package com.example.wangyang.tinnerwangyang.Activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;
import com.example.wangyang.tinnerwangyang.Http.Internet.ApiFactory;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.Result;
import com.example.wangyang.tinnerwangyang.databinding.ActivityQueryBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class QueryActivity extends BaseActivity implements TextWatcher {
    ActivityQueryBinding binding;
    private BaseRecyclerAdapter adapter;
    private ObservableField<Boolean> observableResult = new ObservableField<>();
    private ObservableField<String> keywords = new ObservableField<>();
    private Subscription subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_query);
        initpage();
    }

    private void initData() {
        String body = binding.exitQuery.getText().toString();
        ApiFactory.ins().getQueryList(body, 1, "UYPxayY3SxmRRhtfoG6N",
                "b3f61884-b31c-4320-85aa-56253204918e",
                "6.1.0.1", "Android",
                "7.0", "VTR-AL00", "huawei", "one")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((postsBeanResult) ->
                        Success(postsBeanResult), throwable -> {
                    ViewUtils.showMessage("cuowu");
                });

    }

    private void Success(Result result) {
        List<Wachter> list = new ArrayList<>();
        List<PostsBean> postsBean = result.getPosts();
        list.addAll(postsBean);
        adapter.addData(list);
    }

    private void initpage() {
        adapter = new BaseRecyclerAdapter(this);
        binding.queryRecycle.setLayoutManager(new LinearLayoutManager(this));
        binding.queryRecycle.setAdapter(adapter);
        binding.setP(() -> initData());
        binding.queryRefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
                binding.queryRefreshlayout.setRefreshing(false);
            }
        });
        binding.exitQuery.addTextChangedListener(this);

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable.toString().trim())) {
            observableResult.set(false);
        }
        keywords.set(editable.toString());
        binding.exitQuery.setSelection(keywords.get().trim().length());
        if (subscribe != null && subscribe.isUnsubscribed()) {
            subscribe.unsubscribe();
        }
        subscribe = Observable.timer(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    initData();
                }, e -> {

                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscribe != null && subscribe.isUnsubscribed()) {
            subscribe.unsubscribe();
        }
    }
}
