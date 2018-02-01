package com.lib.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.example.wangyang.tinnerwangyang.R;

public class FocusEditText extends EditText implements
		View.OnFocusChangeListener {
	private OnFocusChangeListener mFocusChangeListener;

	public FocusEditText(Context context) {
		super(context);
		init();
	}

	public FocusEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public FocusEditText(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	protected void init() {
		super.setOnFocusChangeListener(this);
	}

	@Override
	public void setOnFocusChangeListener(OnFocusChangeListener l) {
		this.mFocusChangeListener = l;
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		View parent = (View)getParent();
		if(hasFocus) {
			parent.setBackgroundResource(R.drawable.single_line_bg_active);
		} else {
			parent.setBackgroundResource(R.drawable.single_line_bg_normal);
		}
		if (mFocusChangeListener != null) {
			mFocusChangeListener.onFocusChange(v, hasFocus);
		}
	}
}
