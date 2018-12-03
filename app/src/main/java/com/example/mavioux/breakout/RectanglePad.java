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
        width = (int)(screenWidth / 2.75) ;
        height = screenHeight / 15;
        x = screenWidth/2 - width/2;
        y = screenHeight - height;
        xVelocity = 10;
        image = Bitmap.createScaledBitmap(image, width, height, false);
    }

    // Getters
    public int getWidth() {
        return  width;
    }

    public int getHeight() {
        return height;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int xVelocity(){
        return xVelocity;
    }

    // Setters
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setxVelocity(int xVelocity){
        this.xVelocity = xVelocity;
    }

    // More functions
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);

    }

    public void update(){
        if(x > screenWidth || x < 0) {
            xVelocity = -xVelocity;
        }

    }

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
