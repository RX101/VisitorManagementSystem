package com.example.a15041867.visitormanagementsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 15041867 on 8/5/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    // Start version with 1
    // increment by 1 whenever db schema changes.
    private static final int DATABASE_VER = 1;
    // Filename of the database
    // Table Visitor
    private static final String DATABASE_NAME = "VisitorInfoManagement.db";
    private static final String TABLE_VISITOR = "Visitor";
    private static final String VISITOR_COLUMN_NRIC = "Visitor NRIC";
    private static final String VISITOR_COLUMN_HOST_NRIC = "Host NRIC";
    private static final String VISITOR_COLUMN_NAME = "Name";
    private static final String VISITOR_COLUMN_PHONE_NUMBER = "Phone Number";
    private static final String VISITOR_COLUMN_EMAIL = "Email";

    //Table Visit Info
    private static final String TABLE_VISIT_INFO = "Visit Info";
    private static final String VISIT_INFO_COLUMN_ID = "ID";
    private static final String VISIT_INFO_COLUMN_VISITOR_NRIC = "Visitor NRIC";
    private static final String VISIT_INFO_COLUMN_DATETIME_IN = "Datetime In";
    private static final String VISIT_INFO_COLUMN_DATETIME_OUT = "Datetime Out";

    //Table User
    private static final String TABLE_USER = "User";
    private static final String USER_COLUMN_User_NRIC = "User NRIC";
    private static final String USER_COLUMN_USERNAME = "UserName";
    private static final String USER_COLUMN_PHONE_NUMBER = " User Phone Number";
    private static final String USER_COLUMN_EMAIL = "User Email";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSqlVisitor= "CREATE TABLE " + TABLE_VISITOR +  "("
                + VISITOR_COLUMN_NRIC + " TEXT," + VISITOR_COLUMN_HOST_NRIC + " TEXT,"
                + VISITOR_COLUMN_NAME + " TEXT," + VISITOR_COLUMN_PHONE_NUMBER + " INTEGER," + VISITOR_COLUMN_EMAIL + " TEXT)";

        String createTableSqlVisitInfo = "CREATE TABLE " + TABLE_VISIT_INFO +  "("
                + VISIT_INFO_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + VISIT_INFO_COLUMN_VISITOR_NRIC + " TEXT,"
                + VISIT_INFO_COLUMN_DATETIME_IN + " DATETIME," + VISIT_INFO_COLUMN_DATETIME_OUT + " DATETIME)";

        String createTableSqlUser = "CREATE TABLE " + TABLE_USER +  "("
                + USER_COLUMN_User_NRIC + " TEXT," + USER_COLUMN_USERNAME + " TEXT,"
                + USER_COLUMN_PHONE_NUMBER + " INTEGER," + USER_COLUMN_EMAIL + " TEXT)";
        db.execSQL(createTableSqlVisitor);
        db.execSQL(createTableSqlVisitInfo);
        db.execSQL(createTableSqlUser);
        Log.i("info" ,"created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISIT_INFO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Create table(s) again

    }
}
