package com.example.eberhard.cst2335_final;

import java.util.ArrayList;

/**
 * Created by eberhard on 23-Nov-16.
 */

public class MenuRow {

    protected int id;
    protected String option;
    protected String description;
    protected String image;

    public MenuRow(){

    }

    public MenuRow(String option, String description, String image){
        this.option = option;
        this.description = description;
        this.image = image;
    }

    public static ArrayList<MenuRow> makeRows(){
        ArrayList<MenuRow> rows = new ArrayList<>();
        rows.add(new MenuRow("Temperature Settings","Driver & passenger side climate control",""));
        rows.add(new MenuRow("Fuel Level","Displays current fuel level, range and economy",""));
        rows.add(new MenuRow("Light","Control light settings, interior and exterior",""));
        rows.add(new MenuRow("Radio","Radio and entertainment controls",""));
        rows.add(new MenuRow("GPS Navigation","Launches Google Navigator",""));
        rows.add(new MenuRow("Start!","Push button ignition",""));
        rows.add(new MenuRow("Odometer","Displays total distance and trip info",""));
        return rows;
    }
}
