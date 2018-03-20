package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.wangyang.tinnerwangyang.Bean.AttachmentsBean;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.common.CustomMediaController;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityVideoPlayerBinding;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoPlayerActivity extends BaseActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnInfoListener {
    ActivityVideoPlayerBinding binding;
    private AttachmentsBean attachmentsBean;
    private Uri uri;
    private CustomMediaController customMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Vitamio.isInitialized(this);
        super.onCreate(savedInstanceState);

        initWindow();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_player);
        attachmentsBean = (AttachmentsBean) getIntent().getSerializableExtra("attachmentsBean");
        initpage();
    }

    private void initWindow() {
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window = VideoPlayerActivity.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
    }

    private void initpage() {
        customMediaController = new CustomMediaController(this, binding.videoPlayer, this);
        uri = Uri.parse(attachmentsBean.getUrl());
        binding.videoPlayer.setMediaController(customMediaController);
        binding.videoPlayer.setOnBufferingUpdateListener(this);
        binding.videoPlayer.setOnPreparedListener(this);
        binding.videoPlayer.setOnCompletionListener(this);
        binding.videoPlayer.setOnErrorListener(this);
        binding.videoPlayer.setOnSeekCompleteListener(this);
        binding.videoPlayer.setOnInfoListener(this);
        binding.videoPlayer.setVideoURI(uri);
        binding.videoPlayer.start();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        long localtime = SharePrefUtils.getInstance().getlocaltime();
        if (binding.videoPlayer != null) {
            binding.videoPlayer.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.videoPlayer.seekTo(localtime);
        }
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.videoPlayer.seekTo(localtime);
        }

        super.onConfigurationChanged(newConfig);
    }
}
