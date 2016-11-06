package com.be.msu.resto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.be.msu.resto.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Spinner mSpinnerService;
    private Button mBtnCreateAccount;
    private Button mBtnLogin;
    private EditText mEdTxtUsername;
    private EditText mEdtxtPassword;
    private String mUsername = "";
    private String mPassword = "";
    private String service = "";
    private String result1;
    private String bookingDetails;
    private String deleteData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setToolbar();


        mSpinnerService = (Spinner) findViewById(R.id.spinner_service);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                LoginActivity.this,
                android.R.layout.simple_dropdown_item_1line, getServiceList());
        mSpinnerService.setAdapter(adapter);
        mSpinnerService.setOnItemSelectedListener(mServiceSelectListener);

        mEdTxtUsername = (EditText) findViewById(R.id.edTxt_uname);
        mEdtxtPassword = (EditText) findViewById(R.id.edTxt_password);

        mBtnCreateAccount = (Button) findViewById(R.id.btn_createAccount);
        mBtnCreateAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();

            }
        });

        mBtnLogin = (Button) findViewById(R.id.btn_signup);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }


    /**
     * Listen Login button click
     */
    private final View.OnClickListener mLoginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mUsername = mEdTxtUsername.getText().toString();
            mPassword = mEdtxtPassword.getText().toString();
        }
    };

    private final OnItemSelectedListener mServiceSelectListener = new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {
            // TODO Auto-generated method stub
            service = mSpinnerService.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // TODO Auto-generated method stub

        }
    };

    /**
     * Set Toolbar
     */
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_login);
        toolbar.setTitle(getString(R.string.login));
        setSupportActionBar(toolbar);
    }

    /**
     * This method is used to get list of services.
     *
     * @return List of services.
     */
    private ArrayList<String> getServiceList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Admin");
        list.add("Owner");
        list.add("Manager");
        list.add("Cook");
        list.add("Waiter");
        return list;
    }
}
