package com.cookandroid.finalproject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.cookandroid.finalproject.databinding.ActivityMainBinding;
import com.cookandroid.finalproject.databinding.LoginBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoginActivity extends Activity {
    private LoginBinding binding;
    private ActivityMainBinding activityMainBinding;
    private Map<String,String> user;
    private AlertDialog dialog;
    TextView textView;
    ArrayList<String> userList;
    View view;
    String date;
    int hour;
    int min;
    int yeart = 0;
    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new HashMap<String,String>();
        binding = LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        user.put("jaewoow","1234");
        user.put("test","1234");
        user.put("jaewoo","1234");

        Iterator<String> keys = user.keySet().iterator();
        String name = keys.next();




        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.checkButton.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override

            public void onClick(View view) {
                String userUnit = binding.joinName.getText().toString();
                String passwordUnit = binding.joinPassword.getText().toString();
                   if (userUnit.equals(name)) {
                       if(passwordUnit.equals(user.get(name))) {
                           binding.slide.animateOpen();
                           binding.textView.setVisibility(View.GONE);
                           binding.joinName.setVisibility(View.GONE);
                           binding.joinPassword.setVisibility(View.GONE);
                           binding.checkButton.setVisibility(View.GONE);
                           binding.delete.setVisibility(View.GONE);
                           binding.username.setText(name + "??? ???????????????");
                       } else {
                           AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                           dialog = builder.setMessage("??????????????? ????????????").setPositiveButton("??????", null).create();
                           dialog.show();
                       }
                   } else {
                       AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                       dialog = builder.setMessage("???????????? ?????? ??????????????????.").setPositiveButton("??????", null).create();
                       dialog.show();
                   }
               }

            });
       binding.rdoCal.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
             showDate();


           }
       });
        binding.rdoTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
               showTime();
            }
        });

//        binding.calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view,int year,int month,int dayofMonth){
//                date = year + "???" +(month+1) + "???" + dayofMonth;
//
//            }
//        });
        binding.finish.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view){
                 if(yeart != 0){
                  //  Toast.makeText(getApplicationContext(),date+"???"+hour+"???"+min+"????????? ??????????????????",Toast.LENGTH_SHORT).show();
                    binding.finaltv.setText(date+"???"+hour+"???"+min+"???"+"\n"+"????????????!");
                     binding.image.setImageResource(R.drawable.bm2);
                }else if(yeart == 0){
                     AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                     builder.setTitle("??????").setMessage("????????? ????????? ??????????????????!").setPositiveButton("??????",null).create().show();

                 }


            }
        });

}

void showDate(){
    DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            date = year + "???" +(month+1) + "???" + dayOfMonth;
            yeart =year;
        }
    }, 2021, 11, 10);
               datePickerDialog.show();
}
    void showTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hour = hourOfDay;
                min = minute;
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("?????????");
        timePickerDialog.show();
    }
}