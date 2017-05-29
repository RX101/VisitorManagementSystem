package com.example.a15041867.visitormanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etLoginNRIC, etLoginPassword;
    private Session session;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin =(Button)findViewById(R.id.buttonLogin);
        etLoginNRIC = (EditText)findViewById(R.id.editTextloginNRIC);
        etLoginPassword = (EditText)findViewById(R.id.editTextloginPassword);
        session = new Session(this);
        db = new DBHelper(MainActivity.this);



        //        if(session.loggedin()){
//            startActivity(new Intent(MainActivity.this,SecondActivity.class));
//            finish();
//        }



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginNRIC = etLoginNRIC.getText().toString();
                String loginPassword = etLoginPassword.getText().toString();


                if(db.checkLoginUser(loginNRIC,loginPassword)){
                    String position = db.getUserPosition(loginNRIC);
                    if(position.equals("Host")) {
//                        session.setLoggedin(true);
                        startActivity(new Intent(MainActivity.this, PreRegisterActivity.class));
                        Toast.makeText(MainActivity.this,position,Toast.LENGTH_LONG).show();
                    }else if (position.equals("Manager")){
//                        session.setLoggedin(true);
                        startActivity(new Intent(MainActivity.this, ManagerActivity.class));
                        Toast.makeText(MainActivity.this,position,Toast.LENGTH_LONG).show();
                    }else if (position.equals("Security Staff")){
//                        session.setLoggedin(true);
                        startActivity(new Intent(MainActivity.this, SignInActivity.class));
                        Toast.makeText(MainActivity.this,position,Toast.LENGTH_LONG).show();
                    } else{
                        Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                }else if(loginNRIC.isEmpty()){
                    etLoginNRIC.setError("NRIC field is empty");
                }
                else if(loginNRIC.length() > 9){
                    etLoginNRIC.setError("Maximum NRIC character is 9, Please try again.");
                } else if(loginPassword.isEmpty()){
                    etLoginNRIC.setError("Password field is empty");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    db.close();

    }
}
