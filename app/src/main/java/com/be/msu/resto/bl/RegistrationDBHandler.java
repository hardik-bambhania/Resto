package com.be.msu.resto.bl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.be.msu.resto.model.RegistrationCredentials;

/**
 * Created by TANKBHAI on 17-11-2016.
 */
public class RegistrationDBHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "RegistrationDataManager";

    // Contacts table name
    private static final String TABLE_REGISTRATION = "RegistrationData";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_UNAME = "username";
    private static final String KEY_PWD = "password";
    private static final String KEY_CONTACT = "contact";

    public RegistrationDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_REGISTRATION_TABLE = "CREATE TABLE " + TABLE_REGISTRATION + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_UNAME + " TEXT,"
                + KEY_PWD + " TEXT," + KEY_CONTACT + "TEXT" + ")";
        db.execSQL(CREATE_REGISTRATION_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRATION);

        // Create tables again
        onCreate(db);
    }

    // Adding new Credentials
    public void addCredentials(RegistrationCredentials credentials) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_UNAME, credentials.getUsername()); // User Name
        values.put(KEY_PWD, credentials.getPassword()); // Password
        values.put(KEY_CONTACT, credentials.getContactNo());//contact no

        // Inserting Row
        db.insert(TABLE_REGISTRATION, null, values);
        db.close(); // Closing database connection
    }

    public Cursor getRegistrationCredentials(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select username,password from RegistrationData where username=" + username + " AND password=" + password + "", null);
        return res;
    }
}
