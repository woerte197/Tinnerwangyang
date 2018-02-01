package com.example.wangyang.tinnerwangyang.common;

import java.util.List;

/**
 * Created by wangyang on 2/1/18.
 */

public interface RefreshListListener {
    void top(List list);
    void topError(int error);
    void bottom(List list);
}
