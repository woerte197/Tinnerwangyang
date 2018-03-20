package com.example.wangyang.tinnerwangyang.ViewModel;

import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.Result;

/**
 * Created by macmini on 2018/3/20.
 */

public interface DataPersent<T>{
    public void success(Result<T> result);
    public void ennor(String s);
}
