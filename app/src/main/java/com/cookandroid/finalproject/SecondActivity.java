package com.cookandroid.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.cookandroid.finalproject.databinding.SecondBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondActivity extends Activity {

    private SecondBinding binding;
    Button buttonlnc;
    Button buttonDec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final RatingBar rating1, rating2, rating3;
        setContentView(R.layout.second);
        buttonlnc = (Button)findViewById(R.id.btnlnc);
        buttonDec = (Button)findViewById(R.id.btnDec);

        rating1 = (RatingBar)findViewById(R.id.rationBar1);
        rating2 = (RatingBar)findViewById(R.id.ratingBar2);
        rating3 = (RatingBar)findViewById(R.id.ratingBar3);

        buttonlnc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                rating1.setRating(rating1.getRating()+rating1.getStepSize());
                rating2.setRating(rating2.getRating()+rating2.getStepSize());
                rating3.setRating(rating3.getRating()+rating3.getStepSize());
            }
        });
        buttonDec.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                rating1.setRating(rating1.getRating()-rating1.getStepSize());
                rating2.setRating(rating2.getRating()-rating2.getStepSize());
                rating3.setRating(rating3.getRating()-rating3.getStepSize());

            }
        });
    }
}
