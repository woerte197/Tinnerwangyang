package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.net.Uri;
import android.view.SurfaceView;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;
import com.example.wangyang.tinnerwangyang.databinding.LayoutVideoBinding;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.utils.Log;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by wangyang on 27/2/18.
 */

public class ViewVideoItemHolder extends BaseRecyclerHolder<PostsBean, LayoutVideoBinding> {
    public ViewVideoItemHolder(View itemView) {
        super(itemView);
    }

    private SurfaceView surfaceView;
    private VideoView videoView;
    private Uri uri;

    @Override
    public void setUpView(PostsBean model, int position, BaseRecyclerAdapter adapter) {
        bindView.setUser(model.getUser());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String s = model.getCreated_at().substring(0, 10);
        bindView.videoTime.setText(s);
        bindView.setP(() -> {
            if (bindView.videoPlayer.isPlaying()) {
                bindView.videoPlayer.pause();
            } else {
                PostsBean postsBean = (PostsBean) adapter.getBean(position);
                uri = Uri.parse(postsBean.getAttachments().getUrl());
                bindView.videoPlayer.setVideoURI(uri);
            }

        });
    }

}
