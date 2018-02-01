package com.example.wangyang.tinnerwangyang.Bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.wangyang.tinnerwangyang.BR;
import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

import java.util.Observable;

/**
 * Created by wangyang on 5/1/18.
 */

public class NewsTitle extends BaseObservable implements Wachter {
    private String name;
    private String more;

    @Override
    public String toString() {
        return "NewsTitle{" +
                "name='" + name + '\'' +
                ", more='" + more + '\'' +
                '}';
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);//通知某个变量发生了变化
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String getType() {
        return null;
    }
}
