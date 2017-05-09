package com.example.a15041867.visitormanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by 15039840 on 10/5/2017.
 */
public class CancelPreRegister extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        lv = (ListView)findViewById(R.id.lvCancel);

    }
}
