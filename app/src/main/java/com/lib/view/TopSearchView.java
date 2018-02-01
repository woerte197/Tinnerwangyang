package com.lib.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.databinding.TopSearchItemBinding;
import com.lib.Intent.Intentclass;


/**
 * Created by nanchaodong on 2017/4/1.
 */

public class TopSearchView extends RelativeLayout {
    private TopSearchItemBinding bindView;
    private TopSearchClickListener listener;
    private final ObservableField<String> obUrl = new ObservableField<String>();

    public TopSearchView(Context context) {
        this(context, null);
    }

    public TopSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        bindView = DataBindingUtil.inflate(inflater, R.layout.top_search_item, this, true);
        bindView.setP(() -> Intentclass.IntentQueryActivity(context));
        bindView.setImageUrl(obUrl);
        bindView.setPresenter(view -> {
            if (listener != null) {
                if (view == bindView.layoutCollect) {
                    listener.clickSearch();
                }
                if (view == bindView.searchRel) {
                    listener.clickSearch();
                }
            }
        });
    }




    public interface TopSearchClickListener {

        void clickImage();

        void clickSearch();
    }

    public void setSearchListener(TopSearchClickListener listener) {
        this.listener = listener;
    }
}
