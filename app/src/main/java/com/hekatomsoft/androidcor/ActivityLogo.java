package com.hekatomsoft.androidcor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hekatomsoft.androidcor.bottombarfragment.googlemap.GoogleMapFragment;


public class ActivityLogo extends AppCompatActivity {

    public static ImageView imgLogo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        imgLogo = (ImageView) findViewById(R.id.imgLogo);

        Animation animate_logo = AnimationUtils.loadAnimation(ActivityLogo.this, R.anim.animate_logo);
        imgLogo.startAnimation(animate_logo);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
//                if (DataBaseHelperClass.prepareDbOnTheDevice()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(ActivityLogo.this, GoogleMapFragment.class);
                    ActivityLogo.this.startActivity(intent);
                    ActivityLogo.this.finish();
                }
//            }
        });
        thread.start();


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
//        DataBaseClassSample.currentActivity = this;
    }
}