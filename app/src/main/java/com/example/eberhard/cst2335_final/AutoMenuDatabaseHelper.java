package com.example.eberhard.cst2335_final;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by eberhard on 23-Nov-16.
 */

public class AutoMenuDatabaseHelper extends SQLiteOpenHelper {

    public AutoMenuDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.i(ACTIVITY_NAME, "onCreate()");
        database.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.i(ACTIVITY_NAME, "onUpgrade()");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }

    @Override
    public void onDowngrade(SQLiteDatabase database, int oldVersion, int newVersion){
        Log.i(ACTIVITY_NAME, "onDowngrade() >> oldVersion=" + oldVersion + " newVersion=" + newVersion);
    }

    public static MenuRow getRowFromCursor(Cursor cursor){
        MenuRow row = new MenuRow();
        row.id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
        row.option = cursor.getString(cursor.getColumnIndex(OPTION));
        row.description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
        row.image = cursor.getString(cursor.getColumnIndex(IMAGE));
        return row;
    }

    public static final String DATABASE_NAME = "auto_menu.db";
    public static final int DATABASE_VERSION = 001;
    public static final String TABLE_NAME = "MENU_TABLE";
    public static final String KEY_ID = "_id";
    public static final String OPTION = "option";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "image";
    public static final String[] FIELDS = new String[]{KEY_ID,OPTION,DESCRIPTION,IMAGE};
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME
            + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT"
            + OPTION + " TEXT"
            + DESCRIPTION + " TEXT"
            + IMAGE + " TEXT"
            + ");";
    protected static final String ACTIVITY_NAME = "AutoMenuDatabaseHelper";
    private SQLiteDatabase database;
}
