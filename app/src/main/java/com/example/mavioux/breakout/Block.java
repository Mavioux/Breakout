package com.example.mavioux.breakout;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class Block  {
    private Bitmap image;
    public int x,y;
    int rwidth ;
    int rheight ;
    public boolean broken;


    public Block(Bitmap bmp, int i, int j) {
        image = bmp;
        x = i;
        y = j;
        image = Bitmap.createScaledBitmap(image, 80, 80, false);//8080
        rwidth = image.getWidth();
        rheight = image.getHeight();
        broken = false;
    }

    public void draw(Canvas canvas) {

        if(!broken) {
            canvas.drawBitmap(image, x, y, null);
        }
    }

    public void update() {

    }

}