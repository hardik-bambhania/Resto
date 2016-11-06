package com.be.msu.resto.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.be.msu.resto.R;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "--OnCreate(HomeFragment)--");
        setContentView(R.layout.activity_home);
        init();
    }

    /**
     * Draw Initial View
     */
    private void init() {
        final HomeFragment homeFragment = new HomeFragment();
        loadFragment(homeFragment);
    }

    /**
     * Draw fragment in container
     *
     * @param fragment Fragment which you want to draw in container
     */
    private void loadFragment(Fragment fragment) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.home_container, fragment);
        fragmentTransaction.commit();
    }
}
