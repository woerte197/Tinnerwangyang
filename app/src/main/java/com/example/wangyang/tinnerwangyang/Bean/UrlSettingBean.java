package com.example.wangyang.tinnerwangyang.Bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.wangyang.tinnerwangyang.BR;
import com.example.wangyang.tinnerwangyang.Wachter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 5/1/18.
 */

public class UrlSettingBean extends BaseObservable {
    private  boolean S_ISDEBUG;
    private List<Photos> list=new ArrayList<>();
    private static UrlSettingBean instance = null;
    public synchronized static UrlSettingBean getUrlSettingBean(){

        if(instance == null){
            instance = new UrlSettingBean();
        }
        return instance;

    }
    @Bindable
    public List<Photos> getList() {
        return list;
    }

    public void setList(List<Photos> list) {
        this.list = list;
        notifyPropertyChanged(BR.list);
    }

    public UrlSettingBean() {

    }

    @Bindable
    public  boolean isS_ISDEBUG() {
        return S_ISDEBUG;
    }

    public void setS_ISDEBUG(boolean s_ISDEBUG) {
        S_ISDEBUG = s_ISDEBUG;
        notifyPropertyChanged(BR.s_ISDEBUG);
    }


}
