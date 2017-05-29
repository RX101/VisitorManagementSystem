package com.example.a15041867.visitormanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignInActivity extends AppCompatActivity {
    EditText etSignInNRIC, etSignInVisitUnit;
    TextView tvRegister;
    Button btnSignIn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etSignInNRIC = (EditText)findViewById(R.id.editTextSignInNRIC);
        etSignInVisitUnit = (EditText)findViewById(R.id.editTextSignInVisitUnit);
        tvRegister = (TextView)findViewById(R.id.textViewRegister);
        btnSignIn = (Button) findViewById(R.id.buttonSignIn);
        db = new DBHelper(SignInActivity.this);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signInNRIC = etSignInNRIC.getText().toString();
                String signInVisitUnit = etSignInVisitUnit.getText().toString();

                Calendar now = Calendar.getInstance(); //Create a Calendar object with current date/time
                String date = now.get(Calendar.DAY_OF_MONTH)+ "/"+
                        (now.get(Calendar.MONTH)+1) + "/" +
                        now.get(Calendar.YEAR);
                String time  = now.get(Calendar.HOUR_OF_DAY)+":"+
                        now.get(Calendar.MINUTE);

                if(signInNRIC.isEmpty()){
                    etSignInNRIC.setError("NRIC field is empty.");
                }else if(signInNRIC.length() != 9){
                    etSignInNRIC.setError("Invalid NRIC, please try again.");
                }else if(signInVisitUnit.isEmpty()){
                    etSignInVisitUnit.setError("Visit Unit field is empty");
                }else{
                    if(db.checkVisitUnit(signInVisitUnit) == true){
                        String hostNRIC = db.getHostNRIC(signInVisitUnit);
//                    db.updateVisitorTable(hostNRIC,signInNRIC);
                        if(db.insertVisitInfo(signInNRIC,date,time,hostNRIC)){
                            Toast.makeText(SignInActivity.this,"User Added Successful",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(SignInActivity.this,"User Added failed",Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(SignInActivity.this,"Visit Unit does not exist",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
