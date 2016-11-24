package com.example.eberhard.cst2335_final;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by eberhard on 23-Nov-16.
 */

public class AutoMainCursorAdapter extends CursorAdapter {

    public AutoMainCursorAdapter(Context context, Cursor cursor, int flags){
        super(context, cursor, flags);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = inflater.inflate(R.layout.auto_menu_list, null);
        return view ;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String item = cursor.getString(cursor.getColumnIndex(AutoMenuDatabaseHelper.OPTION));
        TextView menuViewOpton = (TextView)view.findViewById(R.id.menuViewOption);
        menuViewOpton.setText(item);
        item = cursor.getString(cursor.getColumnIndex(AutoMenuDatabaseHelper.DESCRIPTION));
        TextView menuViewDescription = (TextView)view.findViewById(R.id.menuViewDescription);
        menuViewDescription.setText(item);
        item = cursor.getString(cursor.getColumnIndex(AutoMenuDatabaseHelper.IMAGE));
        ImageView menuImage = (ImageView)view.findViewById(R.id.menuImage);


    }

    private LayoutInflater inflater;
    private ListView listView;
    private Cursor cursor;
    private SimpleCursorAdapter cursorAdapter;
}
