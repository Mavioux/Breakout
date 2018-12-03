package com.example.mavioux.breakout;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.view.View;

public class RectanglePad implements View.OnTouchListener {

    private Bitmap image;
    private int x;
    private int y;
    private int xVelocity;
    private int width;
    private int height;

    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;




    public RectanglePad(Bitmap bmp){

        image = bmp;
        width = 300;
        height = 100;
        x = screenWidth/2 - 150;
        y = screenHeight - 100;
        xVelocity = 10;
        image = Bitmap.createScaledBitmap(image, width, height, false);
    }

    int getWidth() {
        return  width;
    }

    int getHeight() {
        return height;
    }

    int getY() {
        return y;
    }

    int getX() {
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public void draw(Canvas canvas) {

        canvas.drawBitmap(image, x, y, null);

    }

    public void update(){

        if(x > screenWidth || x < 0) {
            xVelocity = -xVelocity;
        }



    }

    /*@Override
    public boolean onTouch(View view, MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                rectangePad.setX((int)e.getX());
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return true;
    }*/

    @Override
    public boolean onTouch (View v, MotionEvent event) {

        int xTemp = (int)(event.getX());
        int yTemp = (int)(event.getY());

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xTemp = ((int)event.getX());
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        x = xTemp;
        y = yTemp;

        return true;

    }

}
