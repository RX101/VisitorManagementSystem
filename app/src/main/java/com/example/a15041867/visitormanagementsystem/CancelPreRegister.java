package com.example.a15041867.visitormanagementsystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 15039840 on 10/5/2017.
 */
public class CancelPreRegister extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Visitor> alVisitor;
    Visitor data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancelpreregister);


        lv = (ListView)findViewById(R.id.lvCancel);
        DBHelper db = new DBHelper(CancelPreRegister.this);
        alVisitor = db.getAllVisitors();
        aa = new ArrayAdapter(CancelPreRegister.this, android.R.layout.simple_list_item_1, alVisitor);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long rowId) {
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(
                        CancelPreRegister.this);
                alertdialog.setTitle("Selected Visitor");
                alertdialog.setMessage(""+parent.getItemAtPosition(position));
                alertdialog.setPositiveButton("Ok", null);
                alertdialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        alVisitor.remove(alVisitor.get(position));
                        aa.notifyDataSetChanged();
                        
                        Toast.makeText(CancelPreRegister.this,"Visitor Deleted",Toast.LENGTH_SHORT).show();

                    }
                });
                alertdialog.show();
            }
        });


    }

}
