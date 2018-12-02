package com.example.mavioux.breakout;

import android.app.Notification;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CharacterSprite {
    private Bitmap image;
    public int x,y;
    private int xVelocity = 5;
    private int yVelocity = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    Block[] blocksArray;
    int ww = 0;
    int hh = 0;



    public CharacterSprite(Bitmap bmp, Block[] blocksArray) {
        image = bmp;
        x = screenWidth / 2;
        y = (int)(screenHeight / 1.75);
        image = Bitmap.createScaledBitmap(image, (int)(screenWidth/17.5), (int)(screenWidth/17.5), false);
        this.blocksArray = blocksArray;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update(){


        x += xVelocity ;
        y += yVelocity ;
        if ((x >  screenWidth - image.getWidth()) || (x < 0)) {
            xVelocity = xVelocity * -1;
        }
        if ((y > screenHeight - image.getHeight()) || (y < 0)) {
            yVelocity = yVelocity * -1;
        }
        boolean check = false;

        for(int i = 0; i < blocksArray.length; i++) {
            if((y > blocksArray[i].y  && y < blocksArray[i].y + blocksArray[i].rheight) && (x > blocksArray[i].x && x < blocksArray[i].x + blocksArray[i].rwidth) && !blocksArray[i].broken ) {
                blocksArray[i].broken = true;
                yVelocity = -yVelocity;
            }
        }
    }
}