package com.example.wangyang.tinnerwangyang;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.wangyang.tinnerwangyang.fragement.BaseFragment;


/**
 * Created by nanchaodong on 2017/12/1.
 */

public class TabBean extends BaseObservable {
    private int imageNomalRes;
    private int imageSelectedRes;
    private boolean selected;
    private PresenterNomal presenter;
    private BaseFragment fragment;
    private boolean showCircle;

    public TabBean(int imageNomalRes, int imageSelectedRes, boolean selected, BaseFragment fragment) {
        this.imageNomalRes = imageNomalRes;
        this.imageSelectedRes = imageSelectedRes;
        this.selected = selected;
        this.fragment = fragment;
        presenter = () -> {
            if (tabListener != null && !TabBean.this.selected) {
                tabListener.clickTab(this);
            }
        };
    }
    @Bindable
    public int getImageRes() {
        if (selected) {
            return imageSelectedRes;
        }
        return imageNomalRes;
    }

    @Bindable
    public boolean isShowCircle() {
        return showCircle;
    }

    public void setShowCircle(int count) {
        if (count > 0) {
            this.showCircle = true;
        } else {
            this.showCircle = false;
        }
        notifyPropertyChanged(BR.showCircle);
    }

    @Bindable
    public int getImageNomalRes() {
        return imageNomalRes;
    }

    public void setImageNomalRes(int imageNomalRes) {
        this.imageNomalRes = imageNomalRes;
        notifyPropertyChanged(BR.imageNomalRes);
    }

    @Bindable
    public int getImageSelectedRes() {
        return imageSelectedRes;
    }

    public void setImageSelectedRes(int imageSelectedRes) {
        this.imageSelectedRes = imageSelectedRes;
        notifyPropertyChanged(BR.imageSelectedRes);
    }

    @Bindable
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        notifyPropertyChanged(BR.selected);
        notifyPropertyChanged(BR.imageRes);
    }

    public PresenterNomal getPresenter() {
        return presenter;
    }

    public BaseFragment getFragment() {
        return fragment;
    }

    public void setFragment(BaseFragment fragment) {
        this.fragment = fragment;
    }

    public void setPresenter(PresenterNomal presenter) {
        this.presenter = presenter;
    }

    public interface ClickTabListener {
        void clickTab(TabBean tab);
    }

    private ClickTabListener tabListener;

    public void setTabListener(ClickTabListener tabListener) {
        this.tabListener = tabListener;
    }
}
