package com.be.msu.resto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.be.msu.resto.R;
import com.be.msu.resto.bl.RegistrationDBHandler;
import com.be.msu.resto.model.RegistrationCredentials;


public class RegisterActivity extends AppCompatActivity {

    private Spinner mSpinnerService;
    private Button mBtnSignUp;
    private String mUserName = "", mPassword = "", mService = "", mContactNumber = "", mResult;
    private EditText mEdTxtUserName, mEdTxtPassword, mEdTxtContact;
    private RegistrationDBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setToolbar();
        db = new RegistrationDBHandler(this);

        //  mSpinnerService = (Spinner) findViewById(R.id.spinner_service);
      /*  ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_dropdown_item_1line, getServicelist());
        mSpinnerService.setAdapter(adapter);
        mSpinnerService.setOnItemSelectedListener(mServiceSelectListener);
*/
        mEdTxtUserName = (EditText) findViewById(R.id.edTxt_uname);
        mEdTxtPassword = (EditText) findViewById(R.id.edTxt_pwd);
        mEdTxtContact = (EditText) findViewById(R.id.edTxt_contact);


        mBtnSignUp = (Button) findViewById(R.id.btn_signup);
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mUserName = mEdTxtUserName.getText().toString();
                mPassword = mEdTxtPassword.getText().toString();
                mContactNumber = mEdTxtContact.getText().toString();
                /*
                insert data into Database
                 */
                db.addCredentials(new RegistrationCredentials(mUserName, mPassword, mContactNumber));

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

/*
    private final OnItemSelectedListener mServiceSelectListener = new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {
            mService = mSpinnerService.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // TODO Auto-generated method stub

        }
    };*/

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_register);
        toolbar.setTitle(getString(R.string.sign_up));
        setSupportActionBar(toolbar);
    }
/*
    private ArrayList<String> getServicelist() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Admin");
        list.add("Owner");
        list.add("Manager");
        list.add("Cook");
        list.add("Waiter");
        return list;
    }*/
}