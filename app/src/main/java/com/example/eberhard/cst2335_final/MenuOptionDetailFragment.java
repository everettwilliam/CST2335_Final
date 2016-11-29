package com.example.eberhard.cst2335_final;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by eberhard on 27-Nov-16.
 */

public class MenuOptionDetailFragment extends Fragment implements View.OnClickListener {

    public MenuOptionDetailFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(ACTIVITY_NAME, "In onCreate()");

        if(getArguments().containsKey(ITEM_ID)){
            item = getArguments().getString(ITEM_ID);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            btnStart = (ImageButton)savedInstanceState.getSerializable(MenuOptionDetailActivity.AUTO_FRAGMENT);
            textStart = (TextView) savedInstanceState.getSerializable(MenuOptionDetailActivity.AUTO_FRAGMENT);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedState){
        super.onSaveInstanceState(savedState);
        savedState.putSerializable(MenuOptionDetailActivity.AUTO_FRAGMENT, (Serializable)btnStart);
        savedState.putSerializable(MenuOptionDetailActivity.AUTO_FRAGMENT, (Serializable)textStart);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.i(ACTIVITY_NAME, "In onCreateView()");


        if(item != null){
            switch(item){
                case "Temperature Settings":
                    Snackbar.make(container, "Temperature Settings", Snackbar.LENGTH_SHORT).show();
                    break;
                case "Fuel Level":
                    Snackbar.make(container, "Fuel Level", Snackbar.LENGTH_SHORT).show();
                    break;
                case "Light":
                    Snackbar.make(container, "Light", Snackbar.LENGTH_SHORT).show();
                    return inflater.inflate(R.layout.activity_automobile_main, container, false);
                case "Radio":
                    Snackbar.make(container, "Radio", Snackbar.LENGTH_SHORT).show();
                    break;
                case "GPS Navigation":
                    Snackbar.make(container, "GPS Navigation", Snackbar.LENGTH_SHORT).show();
                    break;
                case "Start!":
                    Snackbar.make(container, "Start!", Snackbar.LENGTH_SHORT).show();
                    View start =  inflater.inflate(R.layout.option_start_car, container, false);
                    textStart = (TextView)start.findViewById(R.id.textStart);
                    textRunning = (TextView)start.findViewById(R.id.textRunning);
                    btnStart = (ImageButton)start.findViewById(R.id.btn_start);
                    btnStart.setOnClickListener(this);
                    return start;
                case "Odometer":
                    Snackbar.make(container, "Odometer", Snackbar.LENGTH_SHORT).show();
                    break;
            }
        }
        return null;

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btn_start:
                if(textStart.getText().equals("Engine Stop")){
                    btnStart.setImageResource(R.drawable.start_red);
                    textStart.setText("Engine Start");
                    textRunning.setText("");
                    Toast.makeText(getContext(), "The engine has been stopped", Toast.LENGTH_SHORT).show();
                }else{
                    btnStart.setImageResource(R.drawable.start_green);
                    textStart.setText("Engine Stop");
                    textRunning.setText("Engine Running");
                    Toast.makeText(getContext(), "The engine has been started", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    protected static final String ACTIVITY_NAME = "DetailFragment";
    public static final String ITEM_ID = "item_id";
    private String item;
    private ImageButton btnStart;
    private TextView textStart;
    private TextView textRunning;
}
