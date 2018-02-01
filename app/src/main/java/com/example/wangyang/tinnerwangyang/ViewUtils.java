
package com.example.wangyang.tinnerwangyang;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewUtils {

    private static LayoutInflater inflater;

    public static LayoutInflater getInflater(Context ctx) {
        if (inflater == null) {
            inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        return inflater;
    }

    public static void setViewHeight(final View view, int height) {
        view.setVisibility(height == 0 ? View.GONE : View.VISIBLE);
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.invalidate();
    }

    public static void showMessage(String tag) {
//		Toaster.show(tag);
        ToasterCommon.getInstance().show(tag);
    }

//    public static void showMessage(int tag) {
//        showMessage(ECKit.getString(tag));
//    }

//    public static void showNetworkError() {
//        showMessage(R.string.msg_toast_err_network);
//    }
//
//    public static void removeItemData(SimpleBaseAdapter adapter, Object intent) {
//        if (intent != null) {
//            Intent intent1 = (Intent) intent;
//            Object obj = intent1.getSerializableExtra(Setting.KEY_DETAIL);
//            if (obj != null) {
//                List o = adapter.getData();
//                int index = o.indexOf(obj);
//                if (index != -1) {
//                    o.remove(index);
//                    adapter.notifyDataSetChanged();
//                }
//            }
//        }
//    }
//
//    public static void createImageAndTextViews(final Activity ctx, LinearLayout layout, final Article article, boolean isSelecteable) {
//        layout.removeAllViews();
//        final List<String> images = article.getImages();
//        String str = article.getContent();
//        if (!TextUtils.isEmpty(str)) {
//            LinearLayout.LayoutParams para = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            para.topMargin = 5;
//            para.bottomMargin = 5;
//            Pattern p = Pattern.compile(Setting.IMAGE_PATTER);
//            Matcher m = p.matcher(str);
//            int last = 0;
//            if (images != null) {
//                Iterator<String> ite = images.iterator();
//                while (m.find()) {
//                    int start = m.start();
//                    int end = m.end();
//                    String text = str.substring(last, start);
//                    if (!TextUtils.isEmpty(text)) {
//                        layout.addView(EmoManager.createTextView(ctx, text, isSelecteable), para);
//                    }
//                    String url = ite.next();
//                    final String url2 = url;
//                    if (!TextUtils.isEmpty(url)) {
//                        ImageView img = new ImageView(ctx);
//                        img.setAdjustViewBounds(true);
//                        img.setLayoutParams(para);
//                        img.setScaleType(ScaleType.CENTER_CROP);
//                        layout.addView(img, para);
//                        img.setOnClickListener(new OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                JumpManager.showImageDetail(ctx, article, images.indexOf(url2));
//                            }
//                        });
//                        ImageLoaderManager.displayImageOnServer(url2, img, null);
//                    }
//                    last = end;
//                }
//            }
//            String text = str.substring(last, str.length());
//            if (!TextUtils.isEmpty(text)) {
//                layout.addView(EmoManager.createTextView(ctx, text, isSelecteable), para);
//            }
//        }
//    }
//
//
//    /**
//     * 初始化登录界面相关文本框右侧按钮
//     *
//     * @param view
//     */
//    public static void initLoginRelativeView(final View view) {
//        final EditText editPass = (EditText) view.findViewById(R.id.etPass);
//        final View imgEye = view.findViewById(R.id.imgEye);
//        final View imgCancle = view.findViewById(R.id.imgCancle);
//        OnClickListener lis = new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()) {
//                    case R.id.imgEye:
//                        ImageView img = (ImageView) v;
//                        int cursorIndex = editPass.getSelectionStart();
//                        if (editPass.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
//                            editPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                            img.setImageResource(R.drawable.icon_eye_show);
//                        } else {
//                            editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                            img.setImageResource(R.drawable.icon_eye_hide);
//                        }
//                        editPass.setSelection(cursorIndex);
//                        break;
//                    case R.id.imgCancle:
//                        editPass.setText("");
//                        break;
//                }
//            }
//        };
//        editPass.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (s.length() > 0) {
//                    if (editPass.isFocused()) {
//                        imgCancle.setVisibility(View.VISIBLE);
//                    }
//                } else {
//                    imgCancle.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//        editPass.setOnFocusChangeListener(new OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    imgCancle.setVisibility(View.VISIBLE);
//                } else {
//                    imgCancle.setVisibility(View.GONE);
//                }
//            }
//        });
//        if (imgEye != null) {
//            imgEye.setOnClickListener(lis);
//            imgCancle.setOnClickListener(lis);
//        }
//    }
//

    /**
     * 更新点赞图片
     *
//     * @param img
//     * @param status
//     */
//    public static void updatePariseView(ImageView img, int status) {
//        img.setImageResource(status == MessageCode.DB_HAS_PARISED ? R.drawable.ic_zan : R.drawable.ic_nozan);
//    }
//
//    public static void initListViewFadingMode(ListView listView) {
//        try {
//            if (Build.VERSION.SDK_INT >= 9) {
//                Class<?>[] cls = new Class<?>[]{int.class};
//                Object[] params = new Object[]{2};
//                RefInvoke.invokeMethod(AbsListView.class.getName(), "setOverScrollMode", listView, cls, params);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void setLinearyLayoutManager(RecyclerView recyclerView, Activity act) {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(act) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        };
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    public static void setGridLayoutManager(RecyclerView recyclerView, Activity act) {
        GridLayoutManager mLayoutManager = new GridLayoutManager(act, 4);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    public static void setGridLayoutManager(RecyclerView recyclerView, Activity act, int cols) {
        GridLayoutManager mLayoutManager = new GridLayoutManager(act, cols);
        recyclerView.setLayoutManager(mLayoutManager);
    }
//
//    public static void setGridMeasureLayoutManager(RecyclerView recyclerView, Activity act, int cols) {
//        GridMeasureLayoutManager mLayoutManager = new GridMeasureLayoutManager(act, cols, recyclerView, cols);
//        recyclerView.setLayoutManager(mLayoutManager);
//    }
//
//    public static void initRecylerAttr(RecyclerView recyclerView, Activity act) {
//        setLinearyLayoutManager(recyclerView, act);
//        Drawable drawable = act.getResources().getDrawable(R.drawable.aera_list_item_divider);
//        ItemDecoration decor = new DividerItemDecoration(act, DividerItemDecoration.VERTICAL_LIST, drawable);
//        recyclerView.addItemDecoration(decor);
//    }
//
//    public static void initRecylerNullSepAttr(RecyclerView recyclerView, final Activity act) {
//        setLinearyLayoutManager(recyclerView, act);
////		Drawable drawable =act.getResources().getDrawable(R.drawable.aera_list_item_divider);
////		ItemDecoration decor = new DividerItemDecoration(act,DividerItemDecoration.VERTICAL_LIST,drawable);
////		recyclerView.addItemDecoration(decor);
//    }
//
//    public static void createWebView(final BaseActivity ctx, final WebView tv, final Article article) {
//        String str = article.getContent();
//        if (!TextUtils.isEmpty(str)) {
//            String newContent = "";
//            final List<String> images = article.getImages();
//            Pattern p = Pattern.compile(Setting.IMAGE_PATTER);
//            Matcher m = p.matcher(str);
//            int last = 0;
//            String imgDefault = String.format(Setting.URL_PRE_FILE + "///%s", FileUtils.getLoadingImage(ctx));
//
//            if (images != null) {
//                Iterator<String> ite = images.iterator();
//                int index = 0;
//                while (m.find()) {
//                    String text = str.substring(last, m.start());
//                    if (!TextUtils.isEmpty(text)) {
//                        newContent += "<font color='#999'>" + text + "</font>";
//                    }
//                    String url = null;
//                    if (ite.hasNext()) {
//                        url = ite.next();
//                    }
//                    if (!TextUtils.isEmpty(url)) {
//                        Picture pic = createPicture(url);
//                        String u = "";
//                        String strHeight = "";
//
//                        if (pic.getWidth() != -1 && pic.getHeight() != -1) {
//                            File f = ImageLoaderManager.getCacheFile(url);
//                            if (f.exists()) {
//                                u = ImageLoaderManager.getCacheUrl(url);
//                                strHeight = (TextUtils.isEmpty(ImageLoaderManager.getCacheUrl(url).trim()) ? String.format("height:%dpx;", pic.getFullHeight()) : "");
//                            } else {
//                                u = url;
//                            }
//                        } else {
//                            u = url;
//                        }
//                        newContent += "<div id = " + String.format("'div%s'", index) + "style='width:100%;" + strHeight +
//                                "background:#F8F8F8 url(" + imgDefault + ") no-repeat center;text-align:center' onClick='window.mobile.invokeToShowImage(\"" + URLEncoder.encode(url) + "\")'/>" +
//                                "<img id = " + String.format("'img%s'", index) + " src='" + u + "' style='width:100%;pointer-events:none' /></div>";
//
//
//                        index++;
//
//                    }
//                    last = m.end();
//                }
//            }
//            String text = str.substring(last, str.length());
//            if (!TextUtils.isEmpty(text)) {
//                newContent += "<font color='#999'>" + text + "</font>";
//            }
//            newContent = SmileUtils.getSmailString(newContent);
//            newContent = newContent.replaceAll("\r\n", "<br />");
//            newContent += getJsFunction();
//            Log.i("viewutils", "createWebView: " + newContent);
//            tv.loadDataWithBaseURL(FileUtils.getImageFolderPath(), newContent, "text/html", Setting.URL_ENCODE, "");
//        }
//
//    }
//
//    public static Picture createPicture(String url) {
//        Picture pic = new Picture();
//        if (!TextUtils.isEmpty(url)) {
//            String sizes[] = url.split(Pattern.quote("?"));
//            if (sizes.length > 1) {
//                String argstr = sizes[1];
//                if (!TextUtils.isEmpty(argstr)) {
//                    argstr = argstr.replace("amp;", "");
//                }
//                String args[] = argstr.split(Pattern.quote("&"));
//                if (args.length >= 2) {
//                    for (int i = 0; i < args.length; i++) {
//                        if (args[i].startsWith("width=")) {
//                            pic.setWidth(Integer.valueOf(args[i].split(Pattern.quote("="))[1]));
//                        } else if (args[i].startsWith("height=")) {
//                            pic.setHeight(Integer.valueOf(args[i].split(Pattern.quote("="))[1]));
//                        }
//                    }
//                }
//            }
//        }
//        return pic;
//    }
//
//    private static String getJsFunction() {
//        return "<script>  function changeImg(divid,imgid,url){" +
//                "document.getElementById(imgid).src = url;" +
//                "document.getElementById(divid).style.height='auto';" +
//                "}</script>";
//    }
//
//    public static String invokeJsChangeimg(String divid, String imgid, String url) {
//        return "javascript:changeImg('" + divid + "'" + ",'" + imgid + "','" + ImageLoaderManager.getCacheUrl(url) + "')";
//    }
//
//    @SuppressLint("NewApi")
//    public static void initStatusBarColor(Activity act, int color) {
//        SystemBarTintManager tintManager = new SystemBarTintManager(act);
//        tintManager.setStatusBarTintEnabled(true);
//        tintManager.setNavigationBarTintEnabled(true);
//        tintManager.setStatusBarTintResource(color);
//    }
//
//    public interface ArticleLoadCallBack {
//        void onSuccess(Article article);
//
//        void onFail(Result result);
//    }
//
//    public static void initUserBg(UserInfo user, ImageView img) {
//        if (user != null && user.getNation() != null) {
//            img.setBackgroundColor(ECKit.getResources().getColor(R.color.transparent));
//        }
//    }
//
//
//    public static void setFullScreen(Activity act, boolean isFull) {
//        Window win = act.getWindow();
//        WindowManager.LayoutParams params = win.getAttributes();
//        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
//        if (isFull) {
//            win.setFlags(flag, flag);
//        } else {
//            params.flags &= (~flag);
//            win.setAttributes(params);
//            win.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }
//    }
//
//    public static void initWindow(final BaseActivity act) {
//        act.getWindow().setFormat(PixelFormat.TRANSLUCENT);
//        // 在条件满足时开启硬件加速
//        try {
//            if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
//                int flag = WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED;
//                act.getWindow().setFlags(flag, flag);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void setTextCount(TextView tvCount, int count) {
        tvCount.setVisibility(count == 0 ? View.GONE : View.VISIBLE);
//        tvCount.setText(StringUtils.getUnreadCount(count));
    }


    /**
     * dp转px
     *
     * @param delv
     * @return
     */
    public static int dp2px(Context context, int delv) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, delv, context.getResources().getDisplayMetrics());
    }

    /**
     * 关注图标
     *
//     * @param isFriend
//     * @return
//     */
//    public static int getAttentRes(boolean isFriend) {
//     //   return isFriend ? R.drawable.tata_out : R.drawable.tata_add;
//    }

    public static void animVideoRecomend(final LinearLayout animLayout, int height, boolean isBack) {
        if (isBack) {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                    animLayout, "translationY", 0, height);
            objectAnimator.setDuration(200);
            objectAnimator.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimator);
            animatorSet.addListener(new Animator.AnimatorListener() {

                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {

                    animLayout.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }
            });
            animatorSet.start();
        } else {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                    animLayout, "translationY", height, 0);
            objectAnimator.setDuration(200);
            objectAnimator.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimator);
            animatorSet.addListener(new Animator.AnimatorListener() {

                @Override
                public void onAnimationStart(Animator animation) {
                    animLayout.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }
            });
            animatorSet.start();
        }
    }

    /**
     * 设置窗口透明度 用主Baseactivity
     *
     * @param win
     * @param on
     */
    public static void setTranslucentActivity(Window win, boolean on) {
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void setTableLayoutTabWidth(TabLayout tabNation, int margin) {
        Class<?> tablayout = tabNation.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tablayout.getDeclaredField("mTabStrip");

            tabStrip.setAccessible(true);
            LinearLayout ll_tab = (LinearLayout) tabStrip.get(tabNation);
            for (int i = 0; i < ll_tab.getChildCount(); i++) {
                View child = ll_tab.getChildAt(i);
                child.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                params.setMarginStart(margin);
                params.setMarginEnd(margin);
                child.setLayoutParams(params);
                child.invalidate();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void initScreenForActivity(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            //activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.color_00293A));
        }
    }

    public static void setUptablayout(TabLayout t, int width, int tabWidth) {
        Class<?> tablayout = t.getClass();
        Field mTabStrip = null;
        try {
            mTabStrip = tablayout.getDeclaredField("mTabStrip");
            mTabStrip.setAccessible(true);
            LinearLayout ll_tab = (LinearLayout) mTabStrip.get(t);
            for (int i = 0; i < ll_tab.getChildCount(); i++) {
                View child = ll_tab.getChildAt(i);
                child.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(tabWidth, LinearLayout.LayoutParams.MATCH_PARENT, 0);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//在Android  4.2系统之后，Google在Android中引入了RTL布局，更好了支持了由右到左文字布局的显示，为了更好的兼容RTL布局，google推荐使用MarginStart和MarginEnd来替代MarginLeft和MarginRight
                    params.setMarginStart(width);
                    params.setMarginEnd(width);
                }
                child.setLayoutParams(params);
                child.invalidate(); //刷新View,重新绘新的界面
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface TabSelectedListener {
        void onTabSelected(TabLayout.Tab tab);
    }

    public interface TabUnselectedListener {
        void onTabUnselected(TabLayout.Tab tab);
    }

    public interface TabReselectedListener {
        void onTabReselected(TabLayout.Tab tab);
    }
//
//    public static void setTablayoutListener(TabLayout t, TabSelectedListener tabSelectedListener, TabUnselectedListener tabUnselectedListener, TabReselectedListener tabReselectedListener) {
//        t.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                tabSelectedListener.onTabSelected(tab);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                tabUnselectedListener.onTabUnselected(tab);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                tabReselectedListener.onTabReselected(tab);
//            }
//        });
//    }
//
//    public static void showNotify(String str) {
//        Result<String> res = Constant.GSON.fromJson(str, Result.class);
//        int resultCode = res.getResult();
//        switch (resultCode) {
//            case 8000:
//                int count = SharePrefUtils.getInstance().getXmRead();
//                count++;
//                SharePrefUtils.getInstance().setXmUnread(count);
//                Result<List<Article>> Articles = Constant.GSON.fromJson(str, Constant.TYPE_RESULT_LIST_ARTICLE);
//                Article art = Articles.getData().get(0);
//                ECKit.getPM().push(MessageCode.RESULT_REPLY, art.getArticleId());
//                break;
//            case 8012:
//                Result<List<Article>> resultArticle = Constant.GSON.fromJson(str, Constant.TYPE_RESULT_LIST_ARTICLE);
//                Article article = resultArticle.getData().get(0);
//                if (article.isActivity() == 4) {
//                    int c = SharePrefUtils.getInstance().getNewsUnRead();
//                    c++;
//                    SharePrefUtils.getInstance().setNewsUnRead(c);
//                    ECKit.getPM().push(MessageCode.RESULT_REPLY, null);
//                }
//                break;
//            case 8014:
//                ECKit.getPM().push(MessageCode.RESULT_REPLY, null);
//                break;
//            case 8015:
//                int count1 = SharePrefUtils.getInstance().getActiveUnRead();
//                count1++;
//                SharePrefUtils.getInstance().setActiveUnRead(count1);
//                ECKit.getPM().push(MessageCode.RESULT_REPLY, null);
//                break;
//            case 8013:
//                ECKit.getPM().push(MessageCode.RESULT_REPLY, null);
//                break;
//            case 8016:
//                ECKit.getPM().push(MessageCode.RESULT_REPLY, null);
//                break;
//        }
//
//    }

    public static void setBg(Drawable background) {

        if (background instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) background;
            Drawable.ConstantState constantState = stateListDrawable.getConstantState();
            try {
                Method method = constantState.getClass().getMethod("getChildren");
                method.setAccessible(true);
                Object obj = method.invoke(constantState);
                Drawable[] drawables = (Drawable[]) obj;
                for (Drawable drawable : drawables) {
                    if (drawable instanceof LayerDrawable) {
                        LayerDrawable layerDrawable = (LayerDrawable) drawable;
                        int numberOfLayers = layerDrawable.getNumberOfLayers();
                        for (int i = 0; i < numberOfLayers; i++) {
                            GradientDrawable sub = (GradientDrawable) layerDrawable.getDrawable(i);
                            if (i != numberOfLayers - 1) {
                                String borderColor = "#" + ((i + 1) * 10) + "daebfc";
                                sub.setColor(Color.parseColor(borderColor));
                            }

                        }
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    public static void dismissAnim(RecyclerView recyclerview) {
        recyclerview.getItemAnimator().setAddDuration(0);
        recyclerview.getItemAnimator().setChangeDuration(0);
        recyclerview.getItemAnimator().setMoveDuration(0);
        recyclerview.getItemAnimator().setRemoveDuration(0);
    }

//    public static void initImgCloudVip(ImageView img, UserInfo user, Article article) {
//        if (user.isCloudVIP()) {//云申请
//            setCloudImg(img, R.drawable.icon_cloudvip_block);
//        } else {
//            if (article == null) {
//                img.setVisibility(View.GONE);
//            } else {
//                switch (article.getAt()) {
//                    case Article.AppType.TYPE_JIEMOWEN: //芥末问 发贴 =》 蓝色树叶
//                        setCloudImg(img, R.drawable.btn_jiemowen);
//                        break;
//                    default:
//                        //不显示
//                        img.setVisibility(View.GONE);
//                        break;
//                }
//            }
//        }
//    }

    public static void setCloudImg(ImageView img, int res) {
        img.setVisibility(View.VISIBLE);
        img.setImageResource(res);
    }

}
