package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Context;
import android.widget.ImageView;

import com.example.wangyang.tinnerwangyang.R;
import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.loader.ImageLoaderInterface;

/**
 * Created by wangyang on 5/1/18.
 */


public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Picasso.with(context).load((String) path).placeholder(R.drawable.ic_loading).error(R.drawable.ic_loading).into(imageView);

    }
}
