package com.angga.rsgm;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.content.Intent;

public class Splash extends AppCompatActivity {

    private final Handler mHandler = new Handler();
    private static final int duration = 3000;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);

        mHandler.postDelayed(mPendingLauncherRunnable,
                Splash.duration);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mPendingLauncherRunnable);
    }

    private final Runnable mPendingLauncherRunnable = new Runnable() {

        public void run() {
            final Intent intent = new Intent(Splash.this,
                    RsgmProfileActivity.class);
            startActivity(intent);
            finish();
        }
    };

}
