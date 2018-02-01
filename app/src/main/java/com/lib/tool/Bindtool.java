package com.lib.tool;

import android.animation.ObjectAnimator;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.v4.util.TimeUtils;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.io.File;
import com.example.wangyang.tinnerwangyang.R;
/**
 * Created by wangyang on 29/12/17.
 */

public class Bindtool {
private  static final String TAG="Bindtool";

//    @BindingAdapter("time")
//    public static void getTime(TextView textView, long time) {
//        String a = TimeUtils.getdate(time);
//        textView.setText(a);
//    }

    @BindingAdapter("imageUrl")
    public static void showImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(!TextUtils.isEmpty(url) && !url.equals("") ? url : "a.jpg")
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)

                .config(Bitmap.Config.RGB_565)

                .into(imageView);

    }

    @BindingAdapter("materialLogo")
    public static void showMaterial(ImageView imageView, String url) {

        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {

                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 1f);
                fadeAnim.setDuration(1500);
                fadeAnim.start();
            }
        };
        Glide.with(imageView.getContext().getApplicationContext())
                .load(!TextUtils.isEmpty(url) && !url.equals("") ? url : "a.jpg")
                .placeholder(R.mipmap.icon_jiemoliuxue)
                .error(R.mipmap.icon_jiemoliuxue)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .animate(animationObject)
                .into(imageView);

    }

    @BindingAdapter("offerImageUrl")
    public static void showOfferImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(!TextUtils.isEmpty(url) && !url.equals("") ? url : "a.jpg")
                .placeholder(R.drawable.icon_offer_loading)
                .error(R.drawable.icon_offer_loading)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .config(Bitmap.Config.RGB_565)
                .into(imageView);

    }

    @BindingAdapter("headUrl")
    public static void showImageHeader(ImageView imageView, String url) {
        if (TextUtils.isEmpty(url) || url.equals("")) {
            url = "https://a.jpg";
        }
        if (url.startsWith("http")) Picasso.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.ic_defaulthead)
                .error(R.drawable.ic_defaulthead)
                .config(Bitmap.Config.RGB_565)
                .into(imageView);
        else Picasso.with(imageView.getContext())
                .load(new File(url))
                .placeholder(R.drawable.ic_defaulthead)
                .error(R.drawable.ic_defaulthead)
                .config(Bitmap.Config.RGB_565)
                .into(imageView);

    }

    @BindingAdapter("smallUrl")
    public static void showSmallImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(!TextUtils.isEmpty(url) && !url.equals("") ? url : "a.jpg")
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .config(Bitmap.Config.RGB_565)
                .noFade()
                .into(imageView);
    }

    @BindingAdapter("defaultUrl")
    public static void showNationImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(!TextUtils.isEmpty(url) && !url.equals("") ? url : "a.jpg")
                .placeholder(R.drawable.icon_person_default)
                .error(R.drawable.icon_person_default)
                .config(Bitmap.Config.RGB_565)
                .noFade()
                .into(imageView);
    }

    @BindingAdapter("drawbleId")
    public static void showDrawbleId(ImageView imageView, int mipmapId) {
        Picasso.with(imageView.getContext())
                .load(mipmapId)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .into(imageView);
    }

    @BindingAdapter("animImageUrl")
    public static void showAnimImageUrl(ImageView imageView, String url) {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {

                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
                fadeAnim.setDuration(1500);
                fadeAnim.start();
            }
        };
        Glide.with(imageView.getContext().getApplicationContext())
                .load(!TextUtils.isEmpty(url) && !url.equals("") ? url : "a.jpg")
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .animate(animationObject)
                .into(imageView);
    }

    @BindingAdapter("animOfferImageUrl")
    public static void showAnimOfferImageUrl(ImageView imageView, String url) {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {

                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 1f);
                fadeAnim.setDuration(1500);
                fadeAnim.start();
            }
        };
        Glide.with(imageView.getContext().getApplicationContext())
                .load(!TextUtils.isEmpty(url) && !url.equals("") ? url : "a.jpg")
                .placeholder(R.drawable.icon_offer_loading)
                .error(R.drawable.icon_offer_loading)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .animate(animationObject)
                .into(imageView);
    }

    @BindingAdapter("noCacheUrl")
    public static void showNOCacheImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext().getApplicationContext())
                .load(!TextUtils.isEmpty(url) && !url.equals("") ? url : "a.jpg")
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }

    @BindingAdapter("materialImageUrl")
    public static void showAnimMaterialrImageUrl(ImageView imageView, String url) {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {

                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 1f);
                fadeAnim.setDuration(1500);
                fadeAnim.start();
            }
        };
        Glide.with(imageView.getContext().getApplicationContext())
                .load(!TextUtils.isEmpty(url) && !url.equals("") ? url : "a.jpg")
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .animate(animationObject)
                .into(imageView);
    }


    @BindingAdapter("hasFile")
    public static void showMaterialIcon(ImageView imageView, int hasFile) {
        if (hasFile == 0) {
            imageView.setVisibility(View.GONE);
        } else if (hasFile == 2) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.icon_alread_passed);
        } else if (hasFile == 1) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.icon_checking);
        }
    }


//    @BindingAdapter("status")
//    public static void showTeacherStatus(TextView textView, TeacherInfo teacherInfo) {
//        if (teacherInfo != null) {
//            textView.setText(teacherInfo.getsDescript());
//            textView.setSelected(teacherInfo.getStatus() == 1 ? true : false);
//            LinearLayout parent = (LinearLayout) textView.getParent();
//            for (int i = 0; i < parent.getChildCount(); i++) {
//                View view = parent.getChildAt(i);
//                if (view instanceof ImageView) {
//                    showTeacherUrl((ImageView) view, teacherInfo.getsHeadUrl());
//                }
//            }
//
//
//        }
//
//
//    }
//
//    public static void showTeacherUrl(ImageView imageView, String url) {
//        if (TextUtils.isEmpty(url) || url.equals("")) {
//            url = "https://a.jpg";
//        }
//        if (url.startsWith("http")) Picasso.with(imageView.getContext())
//                .load(url)
//                .placeholder(!SharePrefUtils.getInstance().isLogin() ? R.drawable.icon_teacher_default_header : R.drawable.icon_teacher_default_header_login)
//                .error(!SharePrefUtils.getInstance().isLogin() ? R.drawable.icon_teacher_default_header : R.drawable.icon_teacher_default_header_login)
//                .config(Bitmap.Config.RGB_565)
//                .into(imageView);
//        else Picasso.with(imageView.getContext())
//                .load(new File(url))
//                .placeholder(!SharePrefUtils.getInstance().isLogin() ? R.drawable.icon_teacher_default_header : R.drawable.icon_teacher_default_header_login)
//                .error(!SharePrefUtils.getInstance().isLogin() ? R.drawable.icon_teacher_default_header : R.drawable.icon_teacher_default_header_login)
//                .config(Bitmap.Config.RGB_565)
//                .into(imageView);
//    }

    /**
     * 拦截超链接
     *
     * @param tv
     */
    @BindingAdapter("html")
    public static void interceptHyperLink(TextView tv, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        tv.setText(Html.fromHtml(str));
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = tv.getText();
        if (text instanceof Spannable) {
            int end = text.length();
            Spannable spannable = (Spannable) tv.getText();
            URLSpan[] urlSpans = spannable.getSpans(0, end, URLSpan.class);
            if (urlSpans.length == 0) {
                return;
            }

            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            // 循环遍历并拦截 所有http://开头的链接
            for (URLSpan uri : urlSpans) {
                String url = uri.getURL();
                if (url.indexOf("http://") == 0) {
//                    StringUtils.CustomUrlSpan customUrlSpan = new StringUtils.CustomUrlSpan(tv.getContext(), url);
//                    spannableStringBuilder.setSpan(customUrlSpan, spannable.getSpanStart(uri),
        //                    spannable.getSpanEnd(uri), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                }
            }
            tv.setText(spannableStringBuilder);
        }
    }

    // (textView.getWidth() -
//         textView.getPaddingRight() - textView.getPaddingLeft())
//    @BindingAdapter(value = {"article"})
//    public static void showDrawText(TextView textView, Article article) {
//        int width=0;
//        if (article != null) {
//            width= ECKit.getScreenWidth() + textView.getContext().getResources().getDimensionPixelOffset(R.dimen.d75);
//            if (TextUtils.isEmpty(article.getContent())){
//                textView.setVisibility(View.GONE);
//            }else {
//                textView.setVisibility(View.VISIBLE);
//            }
//            EmoManager.addSupportEmo(textView.getContext(), article.getContent(), textView);
//            if (textView.getPaint().measureText(textView.getText().toString()) > 3 * width) {
//                if (!article.isClick()) {
//                    article.setExpand(true);
//                } else {
//                    article.setExpand(false);
//                }
//            } else {
//                article.setExpand(false);
//
//            }
//
//
//        }
//
//
//    }

}

