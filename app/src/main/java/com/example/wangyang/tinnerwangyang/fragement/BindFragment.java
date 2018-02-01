package com.example.wangyang.tinnerwangyang.fragement;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.wangyang.tinnerwangyang.databinding.FragmentBaseBinding;

import com.example.wangyang.tinnerwangyang.R;
import com.lib.view.TitleBarView;

/**
 * Created by nanchaodong on 2017/3/31.
 */

public abstract class BindFragment<SV extends ViewDataBinding> extends BaseFragment {
    protected FragmentBaseBinding fBaseBinding;
    protected SV bindView;
    public boolean hidden;
    protected boolean showError;
    private RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fBaseBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_base, null, false);
        bindView = DataBindingUtil.inflate(inflater, setLayout(), null, false);
        fBaseBinding.mybody.addView(bindView.getRoot(), lp);
        return fBaseBinding.getRoot();
    }
    protected abstract int setLayout();//布局
    public void setTitle(String msg) {
        super.setTitle(msg);
        fBaseBinding.topBar.setTitle(msg);
    }

    public void setTitle(int msg) {
        this.setTitle(getString(msg));
    }




    public void showTopBar() {
        fBaseBinding.topBar.setVisibility(View.VISIBLE);
        fBaseBinding.topBar.showView(TitleBarView.TYPE_LEFT_BUTTON, View.GONE, null, null);
    }

//    /**
//     * @param error 0,代表没有数据 100:offer还奔跑在路上，请耐心等待哦~~
//     */
//    public void showEmptyView(int error) {
//        try {
//            String msg = getString(R.string.msg_empty_tabgroup);
//            if (error == 0) {
//                fBaseBinding.mybody.setVisibility(View.GONE);
//                fBaseBinding.statusView.setVisibility(View.VISIBLE);
//                fBaseBinding.statusLayout.setVisibility(View.VISIBLE);
//                fBaseBinding.statusView.showEmpty(msg);
//            } else if (error == 100) {
//                msg = getString(R.string.msg_offer_online);
//                fBaseBinding.mybody.setVisibility(View.GONE);
//                fBaseBinding.statusView.setVisibility(View.VISIBLE);
//                fBaseBinding.statusLayout.setVisibility(View.VISIBLE);
//                fBaseBinding.statusView.showEmpty(msg);
//            } else if (error == 200) {
//                msg = getString(R.string.msg_clooect_offer_empty);
//                fBaseBinding.mybody.setVisibility(View.GONE);
//                fBaseBinding.statusView.setVisibility(View.VISIBLE);
//                fBaseBinding.statusLayout.setVisibility(View.VISIBLE);
//                fBaseBinding.statusView.showEmpty(msg);
//            } else if (error == 300) {
//                msg = getString(R.string.msg_not_yet_coloect);
//                fBaseBinding.mybody.setVisibility(View.GONE);
//                fBaseBinding.statusView.setVisibility(View.VISIBLE);
//                fBaseBinding.statusLayout.setVisibility(View.VISIBLE);
//                fBaseBinding.statusView.showEmpty(msg);
//            } else {
//                showErrorView();
//            }
//        } catch (Exception e) {
//
//        }
//
//
//    }
//
//    /**
//     * 显示错误view 隐藏 body
//     */
//    public void showErrorView() {
//        showError = true;
//        fBaseBinding.mybody.setVisibility(View.GONE);
//        fBaseBinding.statusView.setVisibility(View.VISIBLE);
//        fBaseBinding.statusLayout.setVisibility(View.VISIBLE);
//        fBaseBinding.statusView.showError();
//    }
//
//    /**
//     * 显示body 隐藏动画
//     */
//    public void hideStatusView() {
//        showError = false;
//        fBaseBinding.mybody.setVisibility(View.VISIBLE);
//        fBaseBinding.statusView.setVisibility(View.GONE);
//        fBaseBinding.statusLayout.setVisibility(View.GONE);
//        fBaseBinding.statusView.hideAll();
//    }
//
//    /**
//     * 显示加载动画view 隐藏 body
//     */
//    public void showLoadingView() {
//        showError = false;
//        fBaseBinding.mybody.setVisibility(View.GONE);
//        fBaseBinding.statusView.setVisibility(View.VISIBLE);
//        fBaseBinding.statusLayout.setVisibility(View.VISIBLE);
//        fBaseBinding.statusView.showLoading(true);
//    }
//
//    public StatusView getStatusView() {
//        return fBaseBinding.statusView;
//    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.hidden = hidden;
    }

    protected void setBlockGone() {
        fBaseBinding.block.setVisibility(View.GONE);
    }
}
