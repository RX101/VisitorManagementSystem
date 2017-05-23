package com.example.a15041867.visitormanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class VisitorInfoActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Visitor> visitors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_info);

        lv = (ListView)findViewById(R.id.lvVisitorInfo);

        DBHelper db = new DBHelper(VisitorInfoActivity.this);
        visitors = db.getAllVisitors();

        aa = new VisitorArrayAdapter(this, R.layout.row_visitor_info, visitors);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();
        db.close();
    }
}
