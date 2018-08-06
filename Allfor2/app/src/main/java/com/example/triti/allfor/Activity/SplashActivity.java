package com.example.triti.allfor.Activity;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.triti.allfor.MainActivity;
import com.example.triti.allfor.R;

/**
 * Created by triti on 2018-08-06.
 */

public class SplashActivity extends Activity {
    private final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1000;
    private final int SPLASH_DISPLAY_LENGTH = 1500;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        intent = new Intent(SplashActivity.this, MainActivity.class);
        if (android.os.Build.VERSION.SDK_INT >= 23) {

            int internetPermissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);

            if (internetPermissionCheck == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }


            if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_DENIED) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);

            }
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_DISPLAY_LENGTH);

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            finish();
                        }
                    }, SPLASH_DISPLAY_LENGTH);
                }
                return;
            }
        }

    }
}