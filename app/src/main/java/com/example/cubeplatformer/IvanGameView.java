package com.example.cubeplatformer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.cubeplatformer.Entities.Star;

import java.util.ArrayList;

public class IvanGameView extends SurfaceView implements Runnable{

    boolean alive;

  //  PlayerShip player;

    ArrayList<Star> stars = new ArrayList<>();

    Paint paint;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Thread gameThread;

    int sizeX;
    int sizeY;

    public IvanGameView(Context context, int sizeX, int sizeY) {
        super(context);

        alive = true;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

   //     player = new PlayerShip(context, sizeX, sizeY);

        surfaceHolder = getHolder();
        paint = new Paint();

        for(int i = 0 ; i < 98; i++){
            stars.add(new Star(sizeX, sizeY));
        }

        gameThread = new Thread(this);

        gameThread.start();
    }

    @Override
    public void run() {
        while(alive){
            frameRate();
            update();
            draw();
        }
    }

    public void draw(){
        if(surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();

            canvas.drawColor(Color.BLACK);

            paint.setColor(Color.WHITE);
            paint.setTextSize(50);

            for(Star star : stars){
                canvas.drawPoint(star.x, star.y, paint);
            }

    //        canvas.drawBitmap(
    //                player.bitmap,
    //                player.x,
    //                player.y,
    //                paint
    //        );

            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }

    private void update() {
        for(Star star: stars){
            star.update();
        }
    }

    private void frameRate() {
        try{
            gameThread.sleep(33);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
