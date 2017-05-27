package com.example.a15041867.visitormanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 15041867 on 8/5/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    // Start version with 1
    // increment by 1 whenever db schema changes.
    private static final int DATABASE_VER = 1;
    // Filename of the database
    // Table com.example.a15041867.visitormanagementsystem.Visitor

    private static final String DATABASE_NAME = "VisitorInfoManagement.db";
    private static final String TABLE_VISITOR = "Visitor";
    private static final String VISITOR_COLUMN_NRIC = "Visitor_NRIC";
    private static final String VISITOR_COLUMN_HOST_NRIC = "Host_NRIC";
    private static final String VISITOR_COLUMN_NAME = "Name";
    private static final String VISITOR_COLUMN_PHONE_NUMBER = "Phone_Number";
    private static final String VISITOR_COLUMN_EMAIL = "Email";

    //Table Visit Info
    private static final String TABLE_VISIT_INFO = "Visit_Info";
    private static final String VISIT_INFO_COLUMN_ID = "ID";
    private static final String VISIT_INFO_COLUMN_VISITOR_NRIC = "Visitor_NRIC";
    private static final String VISIT_INFO_COLUMN_TIME_IN = "Time_In";
    private static final String VISIT_INFO_COLUMN_DATE_IN = "Date_In";
    private static final String VISIT_INFO_COLUMN_DATETIME_OUT = "Datetime_Out";

    //Table User
    private static final String TABLE_USER = "User";
    private static final String USER_COLUMN_User_NRIC = "User_NRIC";
    private static final String USER_COLUMN_USERNAME = "UserName";
    private static final String USER_COLUMN_PASSWORD = "User_Password";
    private static final String USER_COLUMN_PHONE_NUMBER = " User_Phone_Number";
    private static final String USER_COLUMN_EMAIL = "User_Email";
    private static final String USER_COLUMN_POSITION = "User_Position";
    private static final String USER_COLUMN_Host_Unit = "Host_Unit";


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
                + VISIT_INFO_COLUMN_DATE_IN + " DATE," + VISIT_INFO_COLUMN_TIME_IN + " TIME," + VISIT_INFO_COLUMN_DATETIME_OUT + " DATETIME)";

        String createTableSqlUser = "CREATE TABLE " + TABLE_USER +  "("
                + USER_COLUMN_User_NRIC + " TEXT," + USER_COLUMN_USERNAME + " TEXT," + USER_COLUMN_PASSWORD + " TEXT,"
                + USER_COLUMN_PHONE_NUMBER + " INTEGER," + USER_COLUMN_EMAIL + " TEXT," + USER_COLUMN_POSITION + " TEXT," + USER_COLUMN_Host_Unit + " TEXT)";
        db.execSQL(createTableSqlVisitor);
        db.execSQL(createTableSqlVisitInfo);
        db.execSQL(createTableSqlUser);
        Log.i("info" ,"created tables");

        ContentValues values1 = new ContentValues();
        ContentValues values2 = new ContentValues();
        ContentValues values3 = new ContentValues();
        values1.put(USER_COLUMN_User_NRIC, "admin");
        values1.put(USER_COLUMN_USERNAME, "manager");
        values1.put(USER_COLUMN_PASSWORD, "manager1234");
        values1.put(USER_COLUMN_PHONE_NUMBER, 88888888);
        values1.put(USER_COLUMN_EMAIL, "manager@gmail.com");
        values1.put(USER_COLUMN_Host_Unit, "No");
        values1.put(USER_COLUMN_POSITION, "Manager");

        values2.put(USER_COLUMN_User_NRIC, "security");
        values2.put(USER_COLUMN_USERNAME, "security ");
        values2.put(USER_COLUMN_PASSWORD, "security1234");
        values2.put(USER_COLUMN_PHONE_NUMBER, 88888888);
        values2.put(USER_COLUMN_EMAIL, "security@gmail.com");
        values2.put(USER_COLUMN_Host_Unit, "No");
        values2.put(USER_COLUMN_POSITION, "Security Staff");

        values3.put(USER_COLUMN_User_NRIC, "host");
        values3.put(USER_COLUMN_USERNAME, "host");
        values3.put(USER_COLUMN_PASSWORD, "host1234");
        values3.put(USER_COLUMN_PHONE_NUMBER, 12345678);
        values3.put(USER_COLUMN_EMAIL, "host@gmail.com");
        values3.put(USER_COLUMN_Host_Unit, "Blk108 #01-23");
        values3.put(USER_COLUMN_POSITION, "Host");
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_USER, null, values1);
        db.insert(TABLE_USER, null, values2);
        db.insert(TABLE_USER, null, values3);

        Log.i("info", "dummy records inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISIT_INFO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Create table(s) again
        onCreate(db);
    }

    public void insertUser(String userNRIC, String userName,String password, int userPhoneNumber, String userEmail,String userUnitNo, String userPosition) {
        //TODO insert the data into the database
        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        values.put(USER_COLUMN_User_NRIC, userNRIC);
        values.put(USER_COLUMN_USERNAME, userName);
        values.put(USER_COLUMN_PASSWORD, password);
        values.put(USER_COLUMN_PHONE_NUMBER, userPhoneNumber);
        values.put(USER_COLUMN_EMAIL, userEmail);
        values.put(USER_COLUMN_Host_Unit, userUnitNo);
        values.put(USER_COLUMN_POSITION, userPosition);
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_USER, null, values);
        // Close the database connection
        db.close();
    }

    public void insertRegisterVisitor(String registerNRIC, String registerName, int registerHP, String registerEmail) {
        //TODO insert the data into the database
        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        values.put(VISITOR_COLUMN_NRIC, registerNRIC);
        values.put(VISITOR_COLUMN_NAME, registerName);
        values.put(VISITOR_COLUMN_PHONE_NUMBER, registerHP);
        values.put(VISITOR_COLUMN_EMAIL, registerEmail);
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_USER, null, values);
        // Close the database connection
        db.close();
    }

    public void insertVisitor(String visitorNRIC, String visitorNAME,int visitorNUMBER,String visitorEMAIL) {
        //TODO insert the data into the database
        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        values.put(VISITOR_COLUMN_NRIC, visitorNRIC);
        values.put(VISITOR_COLUMN_NAME, visitorNAME);
        values.put(VISITOR_COLUMN_PHONE_NUMBER, visitorNUMBER);
        values.put(VISITOR_COLUMN_EMAIL, visitorEMAIL);
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_VISITOR, null, values);
        // Close the database connection
        db.close();
    }
    public void insertVisitInfo(String visitorNRIC, String datein, String timein){
        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        values.put(VISIT_INFO_COLUMN_VISITOR_NRIC, visitorNRIC);
        values.put(VISIT_INFO_COLUMN_DATE_IN, datein);
        values.put(VISIT_INFO_COLUMN_TIME_IN, timein);
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_VISIT_INFO, null, values);
        // Close the database connection
        db.close();
    }

    public ArrayList<Visitor> getAllVisitors() {
        //TODO return records in Java objects
        ArrayList<Visitor> tasks = new ArrayList<Visitor>();
        String selectQuery = "SELECT " + VISITOR_COLUMN_NRIC + ", "
                + VISITOR_COLUMN_NAME + ", "
                + VISITOR_COLUMN_PHONE_NUMBER + ", "
                + VISITOR_COLUMN_EMAIL
                + " FROM " + TABLE_VISITOR;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String nric = cursor.getString(0);
                String name = cursor.getString(1);
                String phone_number = cursor.getString(2);
                String email = cursor.getString(3);
                Visitor obj = new Visitor(nric, name, phone_number, email);
                tasks.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }


    public boolean checkLoginUser(String NRIC, String password){
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from  " + TABLE_USER + " where " +
                USER_COLUMN_User_NRIC + " = " + "'"+NRIC+"'" + " and " + USER_COLUMN_PASSWORD + " = " + "'"+password+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }

    public boolean getAllUser(){
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from  " + TABLE_USER ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }

//    public boolean checkUser(){
//        //HashMap<String, String> user = new HashMap<String, String>();
//        String selectQuery ="select * from  " + TABLE_USER + " where " + USER_COLUMN_POSITION + " = " + null;
//
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        // Move to first row
//        cursor.moveToFirst();
//        if (cursor.getCount() > 0) {
//
////            return true;
//        }
//        cursor.close();
//        db.close();
//
//        return false;
//    }

    public String getUserPosition(String NRIC){
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select " +USER_COLUMN_POSITION +" from " + TABLE_USER + " WHERE " + USER_COLUMN_User_NRIC + " = '"+NRIC+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);
        String position = "";
        // moveToFirst() moves to first row
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  0 in getString(0) return the data in the first
                //  column in the Cursor object. getString(1)
                //  return second column data and so on.
                //  Use getInt(0) if data is an int
                position = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();
        return position;
    }

    public int deleteVisitor(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        //WHERE id=1 ** THIS IS AN EXAMPPLE **
        // ^ IT IS WHAT IT IS IN DATABASE
        String condition = VISITOR_COLUMN_NRIC + "= ?";
        String[] args = {String.valueOf(id)};
        //UNTIL HERE
        int result = db.delete(TABLE_VISITOR, condition, args);
        db.close();
        return result;
    }

}
