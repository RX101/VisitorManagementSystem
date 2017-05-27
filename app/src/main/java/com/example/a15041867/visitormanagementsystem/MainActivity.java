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

        if(db.checkUser() != true){
            db.insertUser("admin","manager","manager1234",88888888,"manager@gmil.com","NO","Manager");
            db.insertUser("host","host","host1234",88888887,"host@gmil.com","#08-110","Host");
            db.insertUser("security","security","security1234",88888886,"security@gmil.com","NO","Security Staff");
        }
        //        if(session.loggedin()){
//            startActivity(new Intent(MainActivity.this,SecondActivity.class));
//            finish();
//        }



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginNRIC = etLoginNRIC.getText().toString();
                String loginPassword = etLoginPassword.getText().toString();
                if(db.getUser(loginNRIC,loginPassword)){
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
                        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                        Toast.makeText(MainActivity.this,position,Toast.LENGTH_LONG).show();
                    } else{
                        Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                }else if(loginNRIC.isEmpty() && loginPassword.isEmpty()){
                    Toast.makeText(MainActivity.this,"Username/password field empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    db.close();

    }
}
