package com.cookandroid.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FiveActivity extends Activity {
    EditText editText1,editText2;
    Button button1, button2, buttonCar;
    TextView tv1, tv2;
    String colorCar,tempStr;
    String speedCar;
    Car myCar1;
    Button btnReturn;

    public class Car {
        String color;
        int speed=0;

        Car(String color, int speed) {
            this.color = color;
            this.speed = speed;
        }

        void upSpeed(int value) {
            if (speed + value >= 200)
                speed = 200;
            else
                speed = speed + value;
        }

        void downSpeed(int value) {
            if (speed - value <= 0)
                speed = 0;
            else
                speed = speed - value;
        }


        int getSpeed() {
            return speed;
        }

        String getColor() {
            return color;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five);
        setTitle("초간단계산기");

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        buttonCar = (Button) findViewById(R.id.buttonCar);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);

        myCar1 = new Car("red", 0);  // 디폴트 myCar1 객체 생성

        btnReturn = (Button) findViewById(R.id.btnReturn);

        buttonCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorCar = editText1.getText().toString();
                speedCar = editText2.getText().toString();
                int speedint = Integer.parseInt(speedCar);
                myCar1 = new Car(colorCar, speedint);  // myCar1 객체 생성
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCar1.upSpeed(50);
                Integer var1 = myCar1.getSpeed();
                tempStr = var1.toString();
                tv1.setText(tempStr + " --- 자동차1의 색상은 " + myCar1.getColor());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCar1.downSpeed(50);
                Integer var1 = myCar1.getSpeed();
                tempStr = var1.toString();
                tv1.setText(tempStr + " --- 자동차1의 색상은 " + myCar1.getColor());
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();  // 메인 화면으로 돌아감
            }
        });
    }
}
