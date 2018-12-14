package com.angga.rsgm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutUs extends Activity {
    /** Called when the activity is first created. */
    private WebView fweBview;
    Context con;
    String url = ComInfo.aboutUs;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.about_us);
        con = this;
        try {
            updateWebView(url);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private class HelloWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && fweBview.canGoBack()) {
            fweBview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

    private void updateWebView(String url) {
        // TODO Auto-generated method stub

        fweBview = (WebView) findViewById(R.id.auswebView);
        fweBview.getSettings().setJavaScriptEnabled(true);

        fweBview.getSettings().setDomStorageEnabled(true);
        fweBview.setWebViewClient(new HelloWebViewClient());
        fweBview.loadUrl(url);
    }

    public void btnHome(View v) {

        Intent next = new Intent(con, RsgmProfileActivity.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);

    }

    public void btnBack(View v) {
        finish();

    }


}
