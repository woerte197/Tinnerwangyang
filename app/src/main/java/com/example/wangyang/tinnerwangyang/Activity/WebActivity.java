package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.databinding.ActivityWebBinding;

import java.util.ArrayList;
import java.util.List;

import static com.example.wangyang.tinnerwangyang.R.layout.activity_web;

public class WebActivity extends BaseActivity {
    WebView webView;
    ActivityWebBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(WebActivity.this, activity_web);
        webView = binding.webview;
        initWebView(webView);
        reload();
    }

    protected void reload() {
        String url = getUrl();
//        if (url.equals("https://truck.boohee.com/health_task"))
//        {
//            url="https:\\/\\/truck.boohee.com\\/health_task";
//        }
        webView.loadUrl(url);

    }

    private String getUrl() {
        Intent intent = getIntent();
        return intent.getStringExtra("url");

    }

    private void initWebView(WebView webView) {
        WebSettings webseting = webView.getSettings();
        webseting.setDomStorageEnabled(true);
        webseting.setAppCacheMaxSize(1024 * 1024 * 8);// 设置缓冲大小，我设的是8M
        String appCacheDir = webView.getContext().getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
        webseting.setAppCachePath(appCacheDir);
        webseting.setAllowFileAccess(true);
        webseting.setJavaScriptEnabled(true);
        webseting.setDatabaseEnabled(true);
        webseting.setJavaScriptCanOpenWindowsAutomatically(true);
        webseting.setAppCacheEnabled(false);
        String dbPath = webView.getContext().getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
        webseting.setDatabasePath(dbPath);

    }
}
