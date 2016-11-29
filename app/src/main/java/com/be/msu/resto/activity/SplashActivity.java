package com.be.msu.resto.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.be.msu.resto.R;
import com.be.msu.resto.bl.LVCircularSmile;

/**
 * This is first activity in starting of application
 */
public class SplashActivity extends AppCompatActivity {

    LVCircularSmile mLVCircularSmile;
    private static final String TAG = SplashActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mLVCircularSmile = (LVCircularSmile) findViewById(R.id.lv_circularSmile);
        mLVCircularSmile.startAnim();
        new SyncTask().execute();
    }

    private class SyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            try {
                //Perform Sync operation here
                Thread.sleep(1500);
            } catch (Exception e) {
                Log.e(TAG, "Error in sync task : " + e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            Intent intent = new Intent(SplashActivity.this, IntroActivity.class);
            startActivity(intent);
            finish();
            super.onPostExecute(o);
        }
    }
}
