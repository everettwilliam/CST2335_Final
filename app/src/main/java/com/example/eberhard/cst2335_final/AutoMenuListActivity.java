package com.example.eberhard.cst2335_final;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

public class AutoMenuListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_menu_list);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        listView = (ListView)findViewById(R.id.menuListView);
        adapter = new DbAdapter(this);
        adapter.open();
        adapter.add();
        cursor = adapter.getRows();
        listView.setAdapter(new AutoMenuCursorAdapter(this, cursor, 0));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
        if(cursor != null){
            cursor.close();
        }
        if(adapter != null){
            adapter.close();
        }
    }

    protected static final String ACTIVITY_NAME = "AutoMenuListActivity";
    private ListView listView;
    private DbAdapter adapter;
    private Cursor cursor;
    private boolean twoPane;
}
