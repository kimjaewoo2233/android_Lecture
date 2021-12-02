package com.cookandroid.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class SixActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.six);
        String[] items = {"CSI-뉴욕","CSI-라스베가스","CSI-마이애마","Friends","Fringe","Lost"};

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String >(this,R.layout.support_simple_spinner_dropdown_item,items);
        autoCompleteTextView.setAdapter(arrayAdapter);

        MultiAutoCompleteTextView multiAutoCompleteTextView  = (MultiAutoCompleteTextView)findViewById(R.id.multAutoCompleteTextView);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setTokenizer(token);

    }


}
