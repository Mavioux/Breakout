package com.example.mavioux.breakout;

import android.graphics.BitmapFactory;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.content.Context;
import android.graphics.Canvas;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private CharacterSprite characterSprite;
    private RectanglePad rectanglePad;
    Block[] blocksArray;


    public GameView(Context context){
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
        blocksArray = new Block[80];
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){

    }


    public void update() {

        characterSprite.update(rectanglePad);
        for (int i = 0; i < blocksArray.length; i++) {
            blocksArray[i].update();
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        characterSprite = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.ball) , blocksArray);
        int counter = 0;
        rectanglePad = new RectanglePad(BitmapFactory.decodeResource(getResources(),R.drawable.rec));
        for(int i = 0; i < 700; i = i + 70) {
            for(int j = 0; j < 550;  j = j + 70) {
                blocksArray[counter++] = new Block(BitmapFactory.decodeResource(getResources(), R.drawable.rectangle), i, j);
            }
        }
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public void draw(Canvas canvas) {

        // 1st way: colors (url for hex codes: https://www.color-hex.com/ )
        canvas.drawRGB(126,133,57);

        // fill canva with black color
        //super.draw(canvas);
        characterSprite.draw(canvas);
        characterSprite.update(rectanglePad);
        rectanglePad.draw(canvas);
        rectanglePad.update();
        for (int i = 0; i < blocksArray.length; i++) {
            blocksArray[i].draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int eventAction = event.getAction();

        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                rectanglePad.setX(x - rectanglePad.getWidth()/2);
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}


