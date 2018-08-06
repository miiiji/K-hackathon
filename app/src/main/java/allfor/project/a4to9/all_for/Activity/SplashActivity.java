package allfor.project.a4to9.all_for.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import allfor.project.a4to9.all_for.R;

/**
 * Created by triti on 2018-08-06.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();    // 액티비티 종료
            }
        };
        handler.sendEmptyMessageDelayed(0, 1500);
    }
}