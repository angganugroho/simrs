package com.angga.rsgm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class RsgmProfileActivity extends Activity {
    /** Called when the activity is first created. */
    public int currentimageindex = 0;
    Timer timer;
    TimerTask task;
    ImageView slidingimage;
    private static Context con;

    //Add or Delete your slideshow images from here

    private int[] IMAGE_IDS = { R.drawable.slide1, R.drawable.slide2,
            R.drawable.slide3, R.drawable.slide4 };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home);
        final Handler mHandler = new Handler();
        RsgmProfileActivity.con = this;
        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                AnimateandSlideShow();

            }
        };

        int delay = 1000; // delay for 1 sec.

        int period = 6000; // repeat every 4 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                mHandler.post(mUpdateResults);

            }

        }, delay, period);

    }

    public void onClick(View v) {

        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * Helper method to start the animation on the splash screen
     */
    private void AnimateandSlideShow() {

        slidingimage = (ImageView) findViewById(R.id.slideShow);
        try {
            slidingimage.setImageResource(IMAGE_IDS[currentimageindex
                    % IMAGE_IDS.length]);
        } catch (Exception e) {
            // TODO: handle exception
        }
        currentimageindex++;

        Animation rotateimage = AnimationUtils.loadAnimation(this,R.anim.slide_left);

        slidingimage.startAnimation(rotateimage);

    }

    public void btnContact(View v) {

        Intent next = new Intent(con, ContactUs.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);

    }

    public void btnProfil(View v) {

        Intent next = new Intent(con, Profil.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);

    }

    public void btnLayanan(View v) {

        Intent next = new Intent(con, Layanan.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);

    }

    public void btnPoli(View v) {

        Intent next = new Intent(con, MainActivity.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);
    }

    public void btnSchedule(View v) {

        Intent next = new Intent(con, Schedule.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);

    }

    public void btnPanduan(View v) {

        Intent next = new Intent(con, Panduan.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);

    }

    public void btnLogin(View v) {

        Intent next = new Intent(con, Login.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);
    }

    public void btnFacebook(View v) {

        Intent next = new Intent(con, FacebookActivity.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);
    }

    public void btnTwitter(View v) {

        Intent next = new Intent(con, TwitterActivity.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);
    }

    public void btnAboutUs(View v) {

        Intent next = new Intent(con, AboutUs.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);
    }
}