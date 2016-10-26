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
import android.widget.Spinner;

import com.be.msu.resto.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private Spinner mSpinnerService;
    private Button create_account, login;
    private EditText eusername, epassword;
    String username = "", password = "", service = "", result1, bookingDetails, deleteData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setToolbar();

        mSpinnerService = (Spinner) findViewById(R.id.spinner_service);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                LoginActivity.this,
                android.R.layout.simple_dropdown_item_1line, getServicelist());
        mSpinnerService.setAdapter(adapter);
        mSpinnerService.setOnItemSelectedListener(mServiceSelectListener);

        eusername = (EditText) findViewById(R.id.input_uname);
        epassword = (EditText) findViewById(R.id.input_password);

        login = (Button) findViewById(R.id.btn_signup);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                username = eusername.getText().toString();
                password = epassword.getText().toString();

            }
        });
        create_account = (Button) findViewById(R.id.create_account);
        create_account.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

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

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_login);
        toolbar.setTitle(getString(R.string.login));
        setSupportActionBar(toolbar);
    }

    private ArrayList<String> getServicelist() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Admin");
        list.add("Owner");
        list.add("Manager");
        list.add("Cook");
        list.add("Waiter");
        return list;
    }
}
