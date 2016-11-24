package com.example.eberhard.cst2335_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by eberhard on 23-Nov-16.
 */

public class DbAdapter {

    public DbAdapter(Context context){
        this.context = context;
    }

    public DbAdapter open() throws SQLException{
        dbHelper = new AutoMenuDatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        if(dbHelper != null){
            dbHelper.close();
        }

    }

    public long insert(ContentValues initialValues){
        return database.insertWithOnConflict(AutoMenuDatabaseHelper.TABLE_NAME, null, initialValues, SQLiteDatabase.CONFLICT_IGNORE);
    }

    public Cursor getRows(){
        return database.query(AutoMenuDatabaseHelper.TABLE_NAME, AutoMenuDatabaseHelper.FIELDS,null,null,null,null,null);
    }

    public boolean update(int id, ContentValues newValues){
        String[] selectionArgs = {String.valueOf(id)};
        return database.update(AutoMenuDatabaseHelper.TABLE_NAME, newValues, AutoMenuDatabaseHelper.KEY_ID + "=?", selectionArgs) > 0;
    }

    public boolean delete(int id){
        String[] selectionArgs = {String.valueOf(id)};
        return database.delete(AutoMenuDatabaseHelper.TABLE_NAME, AutoMenuDatabaseHelper.KEY_ID + "=?", selectionArgs) > 0;
    }

    public void upgrade() throws SQLException{
        dbHelper = new AutoMenuDatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        dbHelper.onUpgrade(database, 100, 101);
    }

    private final Context context;
    private SQLiteDatabase database;
    private AutoMenuDatabaseHelper dbHelper;
}
