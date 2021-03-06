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

public class ContactUs extends Activity {

    private WebView cweBview;
    Context con;
    String url = "https://maps.google.com/?q="+ComInfo.Latitude+","+ComInfo.Longitude+"";

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.contact_us);
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
        if (keyCode == KeyEvent.KEYCODE_BACK && cweBview.canGoBack()) {
            cweBview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

    private void updateWebView(String url) {
        // TODO Auto-generated method stub

        cweBview = (WebView) findViewById(R.id.conwebView);
        cweBview.getSettings().setJavaScriptEnabled(true);
        cweBview.getSettings().setDomStorageEnabled(true);

        cweBview.setWebViewClient(new HelloWebViewClient());
        cweBview.loadUrl(url);
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
