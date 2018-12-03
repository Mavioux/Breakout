package com.example.mavioux.breakout;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Block  {
    private Bitmap image;
    private int x,y;
    private int rwidth ;
    private int rheight ;
    private boolean broken;


    public Block(Bitmap bmp, int x, int y) {
        image = bmp;
        this.x = x;
        this.y = y;
        image = Bitmap.createScaledBitmap(image, 80, 80, false);//8080
        rwidth = image.getWidth();
        rheight = image.getHeight();
        broken = false;
    }

    // Getters
    public int getRwidth() {
        return  rwidth;
    }

    public int getRheight() {
        return rheight;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean getBroken() {
        return broken;
    }

    // Setters
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setWidth(int rwidth){
        this.rwidth = rwidth;
    }

    public void setHeight(int rheight){
        this.rheight = rheight;
    }

    public void setBroken(boolean broken){
        this.broken = broken;
    }

    // More functions
    public void draw(Canvas canvas) {

        if(!broken) {
            canvas.drawBitmap(image, x, y, null);
        }
    }

    public void update() {

    }

}