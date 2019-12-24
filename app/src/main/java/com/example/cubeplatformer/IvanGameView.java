package com.example.cubeplatformer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.cubeplatformer.Entities.PlayerCube;
import com.example.cubeplatformer.Entities.Spikes;
import com.example.cubeplatformer.Entities.Star;

import java.util.ArrayList;

public class IvanGameView extends SurfaceView implements Runnable{

    boolean alive;
    int timer;
    PlayerCube playercube;
    boolean disabledTouch=false;

    ArrayList<Star> stars = new ArrayList<>();

    ArrayList<Spikes> spikes = new ArrayList<>();


    Paint paint;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Thread gameThread;

    int sizeX;
    int sizeY;
    int jumpInt=0;
    boolean jumpBool=false;

    public IvanGameView(Context context, int sizeX, int sizeY) {
        super(context);

        alive = true;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        playercube = new PlayerCube(sizeX, sizeY,context);
        surfaceHolder = getHolder();
        paint = new Paint();


          //  spikes.add(new
         //           Spikes(sizeX, sizeY,getContext(),600));



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

            if(timer%10==0) {
                spikes.add(new
                        Spikes(sizeX, sizeY,getContext(),700));
            }
        }


    }

    public void draw(){
        if(surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();

            canvas.drawColor(Color.argb(200,131,159,255));

            paint.setColor(Color.WHITE);
            paint.setTextSize(50);

            for(Star star : stars){
                canvas.drawPoint(star.x, star.y, paint);
            }

            canvas.drawBitmap(
                    playercube.bitmap,
                    playercube.x,
                    playercube.y,
                    paint
            );
            for(Spikes spike : spikes){
                canvas.drawBitmap(spike.bitmap,
                        spike.x,
                        spike.y,
                        paint);
            }

            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }

    private void update() {
        for(Star star: stars){
            star.update();
        }
        timer++;

        for(Spikes spike:spikes){
            spike.update();
        }
        if(jumpBool==true){
            jumpInt++;
            playercube.update(15);
          //  jumpBool=false; //Delete this line after rotation fix

        }
        if(jumpInt>=10){
            jumpBool=false;
            jumpInt++;
            playercube.update(-15);
        }
        if(jumpInt==20){

            jumpInt=0;
        }


                //^^^ THIS WORKS! Just commented because of rotation!!!!!!!!!!!!!!!!!!!!!!!!!!
                //Platform.Java was commended. And more code too.
    }

    private void frameRate() {
        try{
            gameThread.sleep(33);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (playercube.y==playercube.startY){           //Disable even while in jump animation!
            disabledTouch=false;                        //When attaching to PLATFORM, startY needs to change as well!
        }
        if(disabledTouch==false){
            jumpBool=true;
            disabledTouch=true;
        }
        //playercube.update();


        return false;
    }

}
