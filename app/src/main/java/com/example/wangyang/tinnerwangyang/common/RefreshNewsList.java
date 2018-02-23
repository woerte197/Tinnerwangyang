package com.example.wangyang.tinnerwangyang.common;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;


import com.example.wangyang.tinnerwangyang.Activity.KnowledgesActivity;
import com.example.wangyang.tinnerwangyang.Adapter.FootRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Http.HttpString;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.lib.Manager.FileUtils;

import java.io.File;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/10.
 */

public class RefreshNewsList<T> {
    protected FootRecyclerAdapter mAdapter;
    protected Context context;
    protected RecyclerView recyclerView;
    protected SwipeRefreshLayout refreshLayout;
    protected HttpString post;
    protected Request mRequest;
    protected int startIndex = 0;
    protected List<Wachter> datas;
    protected RefreshListListener listener;
    protected GridLayoutManager manager;
    protected boolean loading = false;
    protected boolean oldVersion;
    private boolean isBottom;
    protected Result<T> result = new Result();
    private List records;
    private boolean hasMore;
    private int a;

    public RefreshNewsList(FootRecyclerAdapter adapter, RecyclerView r, SwipeRefreshLayout s, Request request, int a) {
        mAdapter = adapter;
        this.context = adapter.getmCtx();
        this.recyclerView = r;
        this.refreshLayout = s;
        mRequest = request;
        this.a = a;
        recyclerView.setAdapter(mAdapter);
        createPost();

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        mAdapter.hideFooter();
        request.updateRequestStart(0, null);
    }

    public RefreshNewsList setOldVersion(boolean oldVersion) {
        this.oldVersion = oldVersion;
        return this;
    }

    public RefreshNewsList setLayoutManager(GridLayoutManager manager) {
        this.manager = manager;
        recyclerView.setLayoutManager(manager);
        return this;
    }

    public RefreshNewsList setRefreshListListener(RefreshListListener listener) {
        this.listener = listener;
        return this;
    }

    protected void createPost() {
        if (a == 1) {
            result = FileUtils.getKnowledgesData();
            records = result.getArticles();
        } else if (a == 2) {
            result = FileUtils.getSuccessData();
            records = result.getItems();
        } else if (a == 3) {
            result = FileUtils.getPostsData();
            records = result.getPosts();
        } else if (a == 4) {
            result = FileUtils.getPrincipleData();
            records = result.getArticles();
        } else if (a == 5) {
            result = FileUtils.getResultSportsData();
            records = result.getArticles();
        }
        loading = false;
        hasMore = records != null && records.size() > 0;
        Log.i("mRequest", String.valueOf(mRequest.isFirstPage()));
        if (mRequest.isFirstPage() && hasMore) {//如果是第一页并且返回数据
            //Todo 请求下一页 显示加载下一页 但不显示脚布局
            if (oldVersion) {
                mRequest.updateRequestStart(records);
            } else {
                mRequest.updateRequest(records);
            }

            mAdapter.addData(records);
            mAdapter.setFooterMsgId(0);
            mAdapter.hideFooter();
        } else if (mRequest.isFirstPage() && !hasMore) {//如果是第一页并且没有返回数据
            if (oldVersion) {
                mRequest.updateRequestStart(records);
            } else {
                mRequest.updateRequest(records);
            }
            listener.topError(0);
        } else if (!mRequest.isFirstPage() && hasMore) {//如果不是第一页并且有返回数据
            //Todo 请求下一页
            if (result.getPage() != 0) {
                if (oldVersion) {
                    mRequest.updateRequestStart(records);
                } else {
                    mRequest.updateRequest(records);
                }
                mAdapter.addData(records);
                mAdapter.setFooterMsgId(0);
                mAdapter.hideFooter();
            } else {
                if (oldVersion) {
                    mRequest.updateRequestStart(records);
                } else {
                    mRequest.updateRequest(records);
                }
                mAdapter.setFooterMsgId(2);
                loading = true;
            }
        } else if (!mRequest.isFirstPage() && !hasMore) {//如果不是第一页并且没有返回数据
            //Todo 将请求置0
            if (oldVersion) {
                mRequest.updateRequestStart(records);
            } else {
                mRequest.updateRequest(records);
            }
            mAdapter.setFooterMsgId(2);
            loading = true;
        }
        refreshLayout.setRefreshing(false);
    }

    public void loadTop() {
        mAdapter.hideFooter();
        if (oldVersion) {
            mRequest.updateRequestStart(null);
        } else {
            mRequest.updateRequest(null);
        }
        //发送网络请求
        createPost();
    }

    protected void loadBottom() {
        if (!loading) {
            loading = true;
            mAdapter.showFooter();
            createPost();

        }


    }

    public RefreshNewsList addButtomListener() {
        if (!isBottom) {
            recyclerView.addOnScrollListener(scrollListener);
            isBottom = true;
        }
        return this;
    }

    public RefreshNewsList removeButtomListener() {
        if (isBottom) {
            recyclerView.removeOnScrollListener(scrollListener);
            isBottom = false;
        }
        return this;
    }

    private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int lastVisibleItem = manager.findLastVisibleItemPosition();
            int totalItemCount = manager.getItemCount();
            if (lastVisibleItem >= totalItemCount - 1 && dy > 0) {
                loadBottom();
            }
        }
    };

    public RefreshNewsList addTopListener() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadTop();
            }
        });
        return this;
    }


}
