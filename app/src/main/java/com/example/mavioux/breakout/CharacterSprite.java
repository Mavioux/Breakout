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
    private int ballWidth;
    private int ballHeight;
    private int xReference;
    private int yReference;



    public CharacterSprite(Bitmap bmp, Block[] blocksArray) {
        image = bmp;
        x = screenWidth / 2;
        y = screenHeight / 2;
        y = (int)(screenHeight / 1.75);
        image = Bitmap.createScaledBitmap(image, (int)(screenWidth/17.5), (int)(screenWidth/17.5), false);
        this.blocksArray = blocksArray;
        xReference = x - ballWidth/2;
        yReference = y - ballHeight/2;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getBallWidth() {
        return ballWidth;
    }

    public int getBallHeight() {
        return ballHeight;
    }

    public int getxReference() {
        return xReference;
    }

    public int getyReference() {
        return yReference;
    }







    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update(RectanglePad rectanglePad){


        x += xVelocity ;
        y += yVelocity ;
        xReference = x - ballWidth/2;
        yReference = y - ballHeight/2;
        if ((x >  screenWidth - image.getWidth()) || (x < 0)) {
            xVelocity = xVelocity * -1;
        }
        if ((y > screenHeight - image.getHeight()) || (y < 0)) {
            yVelocity = yVelocity * -1;
        }

        if(y > rectanglePad.getY() - screenHeight/40 && (x > rectanglePad.getX() && x < rectanglePad.getX() + rectanglePad.getWidth())) {
            yVelocity  = -yVelocity;
        }

        for(int i = 0; i < blocksArray.length; i++) {

            /*if(y > blocksArray[i].y && y < blocksArray[i].y + yVelocity) {
                if(x > blocksArray[i].x && x < blocksArray[i].x + blocksArray[i].rwidth) {
                    if(blocksArray[i].x - x > blocksArray[i].y - y) {
                        blocksArray[i].broken = true;
                        yVelocity = -yVelocity;
                    }
                    else {
                        blocksArray[i].broken = true;
                        xVelocity = -xVelocity;
                    }

                }
            }

            if(y < blocksArray[i].y + blocksArray[i].rheight && y > blocksArray[i].y + blocksArray[i].rheight - yVelocity) {
                if(x > blocksArray[i].x && x < blocksArray[i].x + blocksArray[i].rwidth && !blocksArray[i].broken) {
                    if(blocksArray[i].x - x > blocksArray[i].y - y) {
                        blocksArray[i].broken = true;
                        yVelocity = -yVelocity;
                    }
                    else {
                        blocksArray[i].broken = true;
                        xVelocity = -xVelocity;
                    }
                }
            }

            if(x > blocksArray[i].x && x < blocksArray[i].x + xVelocity) {
                if(y > blocksArray[i].y && y < blocksArray[i].y +blocksArray[i].rheight && !blocksArray[i].broken) {
                    if(blocksArray[i].x - x > blocksArray[i].y - y) {
                        blocksArray[i].broken = true;
                        yVelocity = -yVelocity;
                    }
                    else {
                        blocksArray[i].broken = true;
                        xVelocity = -xVelocity;
                    }
                }
            }

            if(x < blocksArray[i].x + blocksArray[i].rwidth && x > blocksArray[i].x + blocksArray[i].rwidth + xVelocity) {
                if(y > blocksArray[i].y && y < blocksArray[i].y +blocksArray[i].rheight && !blocksArray[i].broken) {
                    if(blocksArray[i].x - x > blocksArray[i].y - y) {
                        blocksArray[i].broken = true;
                        yVelocity = -yVelocity;
                    }
                    else {
                        blocksArray[i].broken = true;
                        xVelocity = -xVelocity;
                    }
                }
            }*/


            if((yReference > blocksArray[i].y -yVelocity   && yReference < blocksArray[i].y + blocksArray[i].rheight ) && (xReference > blocksArray[i].x && xReference < blocksArray[i].x + blocksArray[i].rwidth) && !blocksArray[i].broken ) {
                if(blocksArray[i].x - xReference > blocksArray[i].y - yReference) {
                        blocksArray[i].broken = true;
                        yVelocity = -yVelocity;
                    }
                    else {
                        blocksArray[i].broken = true;
                        xVelocity = -xVelocity;
                    }
            }
        }


    }
}