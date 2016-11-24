package com.example.eberhard.cst2335_final;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

public class AutoMenuListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_menu_list);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Automobile Remote Control");

        listView = (ListView)findViewById(R.id.menuListView);
        adapter = new DbAdapter(this);
        adapter.open();

    }



    protected static final String ACTIVITY_NAME = "AutoMenuListActivity";
    private ListView listView;
    private DbAdapter adapter;
    private Cursor cursor;
    private SQLiteDatabase database;
    private boolean twoPane;
}
