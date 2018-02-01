package com.lib.view;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.fragement.BaseFragment;


public class TitleBarView extends LinearLayout {
    protected View lnBack;
    protected TextView tvBack;
    private Toolbar toolbar;
    private ViewPager mPager;
    private TabLayout tabLayout;
    private TextView mTvTitle;
    private int currentIndex = 0;
    private ImageButton mImgBack;
    private BaseActivity mActivity;
    private Button mBtnRightButton;
    protected RelativeLayout mLnCenter;
    private TextView tvActionBarTitleView;
    protected ImageButton mImgRightButton1;
    protected ImageButton mImgRightButton2;
  //  private MessageTabAdapter <BaseFragment> adapter;
    private ImageView imageBg;
    public static final int TYPE_LEFT_BUTTON = 0;
    public static final int TYPE_RIGHT_BUTTON = 1;
    public static final int TYPE_IMAGE1 = 2;
    public static final int TYPE_IMAGE2 = 3;

    public TitleBarView(BaseActivity context) {
        super(context);
        init(context);
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init((BaseActivity) context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void init(BaseActivity act) {
        this.mActivity = act;
        ViewUtils.getInflater(act).inflate(R.layout.c_titlebar, this);
        lnBack = findViewById(R.id.lnBack);
        tvBack = (TextView) findViewById(R.id.tvBack);
        mTvTitle = (TextView) findViewById(R.id.tvTitle);
        mImgBack = (ImageButton) findViewById(R.id.imgBack);
        mLnCenter = (RelativeLayout) findViewById(R.id.lnCenter);
        mBtnRightButton = (Button) findViewById(R.id.btnModify);
        mImgRightButton1 = (ImageButton) findViewById(R.id.btnSearch);
        mImgRightButton2 = (ImageButton) findViewById(R.id.btnRightMenu);
        mImgBack.setOnClickListener(listener);
        tvBack.setOnClickListener(listener);
        tvBack.setVisibility(View.GONE);
        imageBg = (ImageView) findViewById(R.id.image_bg);
    }

    private void addCenterView(View view, ViewGroup.LayoutParams para) {
        mLnCenter.addView(view, para);
    }
    public void setImageBg(int vis){
        imageBg.setVisibility(vis);
    }
    public void setLeftImageResource(int res) {
        getLeftButton().setImageResource(res);
    }

    public ImageView getLeftButton() {
        return mImgBack;
    }

    public TextView getLeftText() {
        return tvBack;
    }

    public void showLeftButton(int imgRes, String txtRes, OnClickListener listener) {
        if (imgRes != -1) {
            mImgBack.setOnClickListener(listener);
            mImgBack.setPadding(0, 0, 0, 0);
            mImgBack.setVisibility(View.VISIBLE);
            mImgBack.setImageResource(imgRes);
        }
        if (!TextUtils.isEmpty(txtRes)) {
            tvBack.setOnClickListener(listener);
            tvBack.setPadding(50, 0, 20, 0);
            tvBack.setVisibility(View.VISIBLE);
            tvBack.setText(txtRes);
        }
        LayoutParams para = (LayoutParams) mImgBack.getLayoutParams();
//        para.width = ECKit.getDimensionPixelSize(R.dimen.topbar_left_button_height);
//        para.height = ECKit.getDimensionPixelSize(R.dimen.topbar_left_button_height);
        para.leftMargin = 40;

    }

    public void showView(int type, int visable, Object res, OnClickListener listener) {
        View view = null;
        switch (type) {
            case TYPE_LEFT_BUTTON:
                view = mImgBack;
                break;
            case TYPE_RIGHT_BUTTON:
                view = mBtnRightButton;
                break;
            case TYPE_IMAGE1:
                view = mImgRightButton1;
                break;
            case TYPE_IMAGE2:
                view = mImgRightButton2;
                break;
        }
        if (res != null) {
            if (view instanceof ImageButton) {
                int r = (int) res;
                if (r != -1) {
                    ((ImageButton) view).setImageResource(r);
                }

            } else if (view instanceof Button) {
                if (!TextUtils.isEmpty(String.valueOf(res))) {
                    ((Button) view).setText(String.valueOf(res));
                }
            }
        }
        if (listener != null) {
            view.setOnClickListener(listener);
            tvBack.setOnClickListener(listener);
        }
        view.setVisibility(visable);
    }

    public Button getBtnRightButton() {
        return mBtnRightButton;
    }

    /**
     * 设置标题及其样式
     *
     * @param title
     * @param center center = false:此时为正常横屏居左背影为半透明显示 center = true:为竖屏居中背影全透明显示
     */
    @SuppressLint("NewApi")
    public void setTitle(String title, boolean center) {
        if (mTvTitle != null) {
            RelativeLayout.LayoutParams para = (RelativeLayout.LayoutParams) mLnCenter.getLayoutParams();
            if (center) {
                int margin = mActivity.getResources().getDimensionPixelSize(R.dimen.d40);
                para.removeRule(RelativeLayout.RIGHT_OF);
                para.setMargins(margin, 0, margin, 0);
              //  mTvTitle.setTextColor(ECKit.getColor(R.color.white));

                mTvTitle.setEllipsize(TextUtils.TruncateAt.END);
             //   this.setBackgroundColor(ECKit.getColor(R.color.transparent));

            } else {
                para.addRule(RelativeLayout.RIGHT_OF, lnBack.getId());
              //  mTvTitle.setTextColor(ECKit.getColor(R.color.white));
                mTvTitle.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                this.setBackgroundResource(R.drawable.video_landspace_titlebar);

            }
            mTvTitle.setText(title);
        }
        if (tvActionBarTitleView != null) {
            tvActionBarTitleView.setText(title);
        }
        if (toolbar != null) {
            toolbar.setTitle(title);
            ((BaseActivity) getContext()).setSupportActionBar(toolbar);
            ((BaseActivity) getContext()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    public void setLeftTitle(String title, String backTitle, int imgRes, int color) {
        setLeftTitle(title, backTitle, imgRes, color, -1);
    }

    /**
     * 设置标题及其样式
     *
     * @param title
     */
    public void setLeftTitle(String title, String backTitle, int imgRes, int color, int bgRes) {
        if (mTvTitle != null) {
            showView(TitleBarView.TYPE_LEFT_BUTTON, View.VISIBLE, null, null);
            if (color != -1) {
            //    this.setBackgroundColor(ECKit.getColor(color));
            }
            if (bgRes != -1) {
                this.setBackgroundResource(bgRes);
            }
            tvBack.setVisibility(View.VISIBLE);
            tvBack.setText(backTitle);
            mTvTitle.setText(title);
        //    mTvTitle.setTextColor(ECKit.getColor(R.color.color_nation_title));
            try {
                if (imgRes != -1) {
                    mImgBack.setImageResource(imgRes);
                }
            } catch (Exception e) {

            }
        }
    }

    public void setTitle(String title) {
        setTitle(title, true);
        this.setBackgroundResource(R.drawable.sharp_shadow_bottom);
    }

    public static interface TabOnChangerListener {
        public void onTabSelected(int index);
    }

    public void addTab(BaseFragment fragment) {
    ///    adapter.addFragment(fragment);
     //   adapter.notifyDataSetChanged();
      //  mPager.setOffscreenPageLimit(adapter.getCount());
        Tab tab = tabLayout.newTab();
     //   tab.setText(fragment.getTitle());
        tabLayout.addTab(tab);
    }

    public int getTabSelectedIndex() {
        return currentIndex;
    }

//    public void showTabMenu(final ViewPager mPager, final MessageTabAdapter adapter, final TabOnChangerListener callback, int defaultIndex) {
//        showTabMenu(mPager, adapter, callback, defaultIndex, -1);
//    }
//
//    public void showTabMenu(final ViewPager mPager, final MessageTabAdapter adapter, final TabOnChangerListener callback, int defaultIndex, int defaultWidth) {
//        this.setBackgroundResource(R.drawable.sharp_shadow_bottom);
//
//        tabLayout = (TabLayout) ViewUtils.getInflater(getContext()).inflate(R.layout.c_titlebar_tablayout, null);
//        if (defaultWidth != -1) {
//            tabLayout.setMinimumWidth(defaultWidth);
//        }
//
//        RelativeLayout.LayoutParams para = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//        para.topMargin = (int) ECKit.getResources().getDimension(R.dimen.d12);
//        para.bottomMargin = (int) ECKit.getResources().getDimension(R.dimen.d12);
//        addCenterView(tabLayout, para);
//        final OnTabSelectedListener onTabSelectedListener = new OnTabSelectedListener() {
//
//            @Override
//            public void onTabUnselected(Tab tab) {
//            }
//
//            @Override
//            public void onTabSelected(Tab tab) {
//                currentIndex = tab.getPosition();
//                if (callback != null) {
//                    callback.onTabSelected(currentIndex);
//                }
//                mPager.setCurrentItem(currentIndex);
//                BaseFragment f = adapter.getItem(currentIndex);
//                if (f instanceof TopFragment) {
//                    TopFragment ff = (TopFragment) f;
//                    if (!ff.isSelectedFragment()) {
//                        ff.setSelected(true);
//                    }
//                }
//            }
//
//            @Override
//            public void onTabReselected(Tab arg0) {
//
//            }
//        };

//        OnPageChangeListener pageListener = new OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int index) {
//                try {
//                    onTabSelectedListener.onTabSelected(tabLayout.getTabAt(index));
//                } catch (Exception e) {
//                }
//            }

//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int arg0) {
//
//            }
//        };
//        mTvTitle.setVisibility(View.GONE);
//        this.adapter = adapter;
//        this.mPager = mPager;
//        mPager.setOnPageChangeListener(pageListener);
//        mPager.setOffscreenPageLimit(adapter.getCount());
//        mPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(mPager);
//        tabLayout.setTabsFromPagerAdapter(adapter);
//        tabLayout.setOnTabSelectedListener(onTabSelectedListener);
//        currentIndex = defaultIndex;
//        onTabSelectedListener.onTabSelected(tabLayout.getTabAt(defaultIndex));
//    }

    public void showSearchView() {
        mTvTitle.setVisibility(View.GONE);
        //View view = ViewUtils.getInflater(getContext()).inflate(R.layout.c_searchview_full, null);
        RelativeLayout.LayoutParams para = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        para.leftMargin = 200;
        para.rightMargin = 200;
       // addCenterView(view, para);
    }

    private OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
        //        SoftKeyboardManager.hideSoftKeyboard(mActivity);
                mActivity.finish();
            }
        }
    };

    public void useActionBar(BaseActivity act) {
        this.setVisibility(View.GONE);
        ActionBar actionBar = act.getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
      //  actionBar.setHomeAsUpIndicator(R.drawable.selector_back_button);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
     //   actionBar.setBackgroundDrawable(act.getResources().getDrawable(R.drawable.round_actionbar_bg));
        ActionBar.LayoutParams layout = new ActionBar.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
     //   View titleLayout = ViewUtils.getInflater(act).inflate(R.layout.c_titlebar_actionbar, null);
    //    tvActionBarTitleView = (TextView) titleLayout.findViewById(R.id.about_actionbar_title);
      //  actionBar.setCustomView(titleLayout, layout);
        if (Build.VERSION.SDK_INT >= 21) { //去除actionbar下方的阴影
            actionBar.setElevation(0);
        }
    }

    public void useToolBar() {
        this.removeAllViews();
      View view = ViewUtils.getInflater(getContext()).inflate(R.layout.c_titlebar_toolbar_layout, null);
         toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        LayoutParams para = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
       this.addView(view, para);
    }

    //	public boolean onOptionsItemSelected(MenuItem item) {
//		switch(item.getItemId()){
//			case android.R.id.home:
//				mActivity.finish();
//				break;
//	        case R.id.action_rightbutton:
//	        	if(rightButtonClickListener!=null){
//	        		rightButtonClickListener.onClick(null);
//	        	}
//	        	break;
//		}
//		return true;
//	}
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void showTitle() {
        this.setVisibility(View.VISIBLE);
        mTvTitle.setVisibility(View.VISIBLE);
        if (tabLayout != null) {
            tabLayout.setVisibility(View.GONE);
        }
    }

    public TextView getTitleView() {
        return mTvTitle;
    }
}
