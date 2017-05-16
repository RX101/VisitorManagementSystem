package com.example.a15041867.visitormanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ListView;

public class editDeleteActivity extends AppCompatActivity {

    ListView lvUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);

        lvUserInfo = (ListView)findViewById(R.id.lvInfoUsers);

        registerForContextMenu(lvUserInfo);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Add");
        menu.add(0,1,1,"Delete");

    }

}
