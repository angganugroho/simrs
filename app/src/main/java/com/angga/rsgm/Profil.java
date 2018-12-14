package com.angga.rsgm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Profil extends Activity {

    private static Context con;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.profil);
        Profil.con = this;
    }

    public void btnVimi(View view) {

        Intent next = new Intent(con, Vimi.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);
    }

    public void btnFasilitas(View view) {

        Intent next = new Intent(con, Fasilitas.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);
    }

    public void btnHome(View view) {

        Intent next = new Intent(con, RsgmProfileActivity.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);
    }

    public void btnBack (View view){
        finish();
    }
}
