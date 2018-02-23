package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.wangyang.tinnerwangyang.Bean.ShareBean;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.databinding.ActivityWebBinding;
import com.lib.Manager.DialogManager;


public class WebActivity extends BaseActivity {
    WebView webView;
    ActivityWebBinding binding;
    String title;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(WebActivity.this, R.layout.activity_web);
        webView = binding.webview;
        ShareBean shareBean = (ShareBean)getIntent().getSerializableExtra("url");
        url = shareBean.getUrl();
        setSupportActionBar(binding.toolbarWebView);
        getSupportActionBar().setTitle("");
        initWebView(webView);
        binding.setPshare(() -> DialogManager.getDialogManager().sharedialog(this, shareBean));
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
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        WebChromeClient webChromeClient = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.i("ssssss", title);
                binding.textWebView.setText(title);
            }
        };
        webView.setWebChromeClient(webChromeClient);

          webView.loadUrl(url);
    }

}
