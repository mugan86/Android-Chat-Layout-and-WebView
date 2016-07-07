package anartzmuxika.chatmessagelayoutapp.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import anartzmuxika.chatmessagelayoutapp.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*****************************************************************
         *
         * IMPORTANT!!! To use webview to load urls necesary Internet
         * connection permission active in Manifest
         *
         *  <uses-permission android:name="android.permission.INTERNET"/>
         *****************************************************************/
        setContentView(R.layout.activity_web_view);

        myWebView = (WebView) findViewById(R.id.myWebView);
        if( savedInstanceState == null ) {
            String url =
                    getIntent().getDataString().replace("chatwebview://", "http://");
            // do something with this URL.
            loadURL(url);
        }
    }

    private void loadURL(String url)
    {
        System.out.println("Load URL: " + url);

        myWebView.loadUrl(url);
        myWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView viewx, String urlx) {
                viewx.loadUrl(urlx);
                return false;
            }
        });

        myWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onCreateWindow(WebView view, boolean dialog, boolean userGesture, android.os.Message resultMsg)
            {
                WebView.HitTestResult result = view.getHitTestResult();
                String data = result.getExtra();
                Context context = view.getContext();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
                context.startActivity(browserIntent);
                return false;
            }
        });
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
