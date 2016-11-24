package com.example.eberhard.cst2335_final;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by eberhard on 23-Nov-16.
 */

public class AutoMenuCursorAdapter extends CursorAdapter {

    public AutoMenuCursorAdapter(Context context, Cursor cursor, int flags){
        super(context, cursor, flags);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = inflater.inflate(R.layout.option_layout, null);
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        return view ;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String item = cursor.getString(cursor.getColumnIndex(DbAdapter.OPTION));
        TextView menuViewOpton = (TextView)view.findViewById(R.id.menuViewOption);
        menuViewOpton.setText(item);
        item = cursor.getString(cursor.getColumnIndex(DbAdapter.DESCRIPTION));
        TextView menuViewDescription = (TextView)view.findViewById(R.id.menuViewDescription);
        menuViewDescription.setText(item);
        int resID = cursor.getInt(cursor.getColumnIndex(DbAdapter.IMAGE));
        ImageView menuImage = (ImageView)view.findViewById(R.id.menuImage);
        menuImage.setImageResource(resID);
    }

    private LayoutInflater inflater;
}
