package com.bffmedia.hour10application;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebViewActivity extends Activity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadUrl("https://www.google.com");
    }

    private class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean  shouldOverrideUrlLoading  (WebView  view, String  url){

            if (url.contains("android")){
                view.loadUrl("http://developer.android.com/develop/index.html");
                return true;
            }
            return false;
        }
    }
}
