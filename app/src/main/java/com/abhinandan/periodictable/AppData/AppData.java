package com.abhinandan.periodictable.AppData;

import android.graphics.drawable.Drawable;

import com.abhinandan.periodictable.Models.Element;

import java.util.ArrayList;

public class AppData {
    private static AppData instance;
    private ArrayList<Element> list;
    private ArrayList<String> values;
    private ArrayList<String> names;
    private ArrayList<Integer> drawables;

    private AppData(){
        list = new ArrayList<>();
        values = new ArrayList<>();
        names = new ArrayList<>();
        drawables = new ArrayList<>();
    }

    public static AppData getInstance(){
        if(instance == null){
            instance = new AppData();
        }

        return instance;
    }

    public ArrayList<Element> getElement(){
        return list;
    }

    public ArrayList<String> getValues(){
        return values;
    }
    public ArrayList<String> getNames(){
        return names;
    }
    public ArrayList<Integer> getDrawables(){
        return drawables;
    }
}
