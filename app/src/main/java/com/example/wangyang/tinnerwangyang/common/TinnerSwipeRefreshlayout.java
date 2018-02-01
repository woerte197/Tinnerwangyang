package com.example.wangyang.tinnerwangyang.common;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import com.example.wangyang.tinnerwangyang.R;
/**
 * Created by wangyang on 29/12/17.
 */

public class TinnerSwipeRefreshlayout extends SwipeRefreshLayout {
    public TinnerSwipeRefreshlayout(Context context) {
        super(context);
        init();
    }

    public TinnerSwipeRefreshlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        this.setColorSchemeResources(R.color.color_5fd477);
    }

}
