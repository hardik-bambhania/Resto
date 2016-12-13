package com.be.msu.resto.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.be.msu.resto.R;
import com.be.msu.resto.fragment.AddOrderFragment;
import com.be.msu.resto.fragment.HomeFragment;
import com.be.msu.resto.fragment.ViewMenuFragment;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getName();
    DrawerLayout mDrawerLayout;

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(mNavigationItemClickListener);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(HomeActivity.this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private final NavigationView.OnNavigationItemSelectedListener mNavigationItemClickListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            item.setChecked(true);
            switch (item.getItemId()) {
                case R.id.menu_my_order:
                    mDrawerLayout.closeDrawers();
                    HomeFragment homeFragment = new HomeFragment();
                    loadFragment(homeFragment);
                    break;
                case R.id.menu_add_order:
                    mDrawerLayout.closeDrawers();
                    AddOrderFragment addOrderFragment = new AddOrderFragment();
                    loadFragment(addOrderFragment);
                    break;
                case R.id.menu_view_menu:
                    mDrawerLayout.closeDrawers();
                    ViewMenuFragment viewMenuFragment = new ViewMenuFragment();
                    loadFragment(viewMenuFragment);
                    /*viewMenuFragment.cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ViewItemFragment viewItemFragment = new ViewItemFragment();
                            loadFragment(viewItemFragment);
                        }
                    });*/
                    break;
                case R.id.menu_feedback:
                    mDrawerLayout.closeDrawers();
                    break;
                default:
                    break;
            }
            return true;
        }
    };


    /**
     * Draw fragment in container
     *
     * @param fragment Fragment which you want to draw in container
     */
    private void loadFragment(Fragment fragment) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_container, fragment);
        fragmentTransaction.commit();
    }
}
