package com.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;

import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.databinding.TabBarLayoutBinding;


/**
 * Created by nanchaodong on 2017/12/6.
 */

public class TabBar extends ConstraintLayout {
    private TabBarLayoutBinding bindView;

    public TabBar(Context context) {
        this(context, null);
    }

    public TabBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bindView = DataBindingUtil.inflate(ViewUtils.getInflater(context), R.layout.tab_bar_layout, this, true);
        init(attrs);
    }

    private void init(AttributeSet a) {
        TypedArray t = getContext().obtainStyledAttributes(a, R.styleable.TabBar);
        String textValue = t.getString(R.styleable.TabBar_textValue);
        Drawable imageResId = t.getDrawable(R.styleable.TabBar_imgHead);
        bindView.tv0.setText(textValue);
        bindView.image0.setImageDrawable(imageResId);
    }

    public void setImgHead(Drawable imgHead) {
        bindView.image0.setImageDrawable(imgHead);
    }

    public void setShowPop(boolean isFlag) {
        bindView.tvCount.setVisibility(isFlag ? VISIBLE : GONE);
    }

    public void setSelect(boolean flag) {
       // bindView.tv0.setVisibility(flag ? View.GONE : View.VISIBLE);
        if (flag) {
            AnimationSet animationSet = new AnimationSet(false);
            ScaleAnimation scaleAnimation = new
                    ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scaleAnimation.setDuration(300);
            animationSet.addAnimation(scaleAnimation);
            animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
            bindView.image0.startAnimation(animationSet);
        }
    }
}