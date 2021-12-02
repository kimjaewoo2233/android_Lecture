package com.cookandroid.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

public class ThridActivity extends Activity {
    final static int LINE = 1, CIRCLE = 2,RECTAN = 3;
    static String color="red";
    static int curShape = LINE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단그림판");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"선 그리기");
        menu.add(0,2,0,"원 그리기");
        menu.add(0,3,0,"사각형 그리기");
        SubMenu subMenu = menu.addSubMenu("색깔 변경>>");
        subMenu.add(0,4,0,"빨간색");
        subMenu.add(0,5,0,"파랑색");
        subMenu.add(0,6,0,"검정색");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 1:
                curShape = LINE;
                return true;
            case 2:
                curShape = CIRCLE;
                return true;
            case 3:
                curShape = RECTAN;
                return true;
            case 4:
                color = "red";
                return true;
            case 5:
                color = "blue";
                return true;
            case 6:
                color = "green";
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        public MyGraphicView(Context context){
            super(context);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startX = (int)event.getX();
                    startY = (int)event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int)event.getX();
                    stopY = (int)event.getY();

                    this.invalidate();
                    break;
            }
            return true;
        }

        protected void onDraw(Canvas canvas){

            super.onDraw(canvas);

            Paint paint = new Paint();

            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            switch (color){
                case "red":
                    paint.setColor(Color.RED);
                    break;
                case "blue":
                    paint.setColor(Color.BLUE);
                    break;
                case "black":
                    paint.setColor(Color.BLACK);
                    break;
            }

            switch (curShape){
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2)
                            + Math.pow(stopY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
                case RECTAN:
                    paint.setStyle(Paint.Style.STROKE); // 스타일은 FILL 로 설정(채우기만 하고 외곽선 X)
                    paint.setStrokeWidth(5);
                    Rect rect = new Rect(startX,startY,stopX,stopY);
                    canvas.drawRect(rect, paint); // 캔버스에 그리기

            }
        }
    }
}