package com.example.cubeplatformer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.cubeplatformer.Common.GameTracker;
import com.example.cubeplatformer.Entities.Platform;
import com.example.cubeplatformer.Entities.PlayerCube;
import com.example.cubeplatformer.Entities.Spikes;
import com.example.cubeplatformer.Entities.Star;

import java.util.ArrayList;

public class IvanGameView extends SurfaceView implements Runnable{

    boolean alive;
    int timer;
    PlayerCube playercube;
    boolean disabledTouch=false;

    boolean attachAny=false;
    boolean fall=false;
    int floor;

    ArrayList<Star> stars = new ArrayList<>();

    ArrayList<Spikes> spikes = new ArrayList<>();
    ArrayList<Platform> platforms = new ArrayList<>();

    Paint paint;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Thread gameThread;

    int sizeX;
    int sizeY;
    boolean jumpBool = false;

    public IvanGameView(Context context, int sizeX, int sizeY) {
        super(context);

        alive = true;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        floor=sizeY-120;

        playercube = new PlayerCube(sizeX, sizeY,context);
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

                                                            // For spikes!
            /*if(timer % 100 == 0) {
                spikes.add(new Spikes(sizeX, sizeY,getContext(),700));
            }*/

                                //Makes first 2 platforms are really close to show multi-level jump!
            if(timer % 100 == 0) {
                platforms.add(new Platform(sizeX, sizeY, getContext(), 700, sizeY-180));
            }
            if(timer % 122 == 0) {
                platforms.add(new Platform(sizeX, sizeY, getContext(), 700,playercube.y-60));
            }
        }
    }
    //Run Ends!

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
                /*
                canvas.drawRect(spike.detectHor,paint);         //Paint collision areas in white!
                canvas.drawRect(spike.detectVert,paint);
                */

            }

            for(Platform platform : platforms) {
                canvas.drawBitmap(platform.bitmap,
                        platform.x,
                        platform.y,
                        paint);

                /*
                canvas.drawRect(platform.detectCollision, paint);       //Paints the collision area... AKA all of it!
                canvas.drawRect(platform.detectVert, paint);
                */
            }


            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }

    private void update() {
        /*for(Star star: stars){
            star.update();
        }*/
        timer++;

        for(Spikes spike:spikes){
            spike.update();
            if (
                            Rect.intersects(spike.detectHor, playercube.detectCollision) ||
                            Rect.intersects(spike.detectVert, playercube.detectCollision)
            ) {
                alive = false;
            }
        }

        for (Platform platform : platforms) {
            platform.update();
            if(Rect.intersects(platform.detectVert,playercube.detectCollision)){
                                            //Left Side minus Jump Height should NEVER intersect!
                alive=false;
                return;
            }
            if (Rect.intersects(platform.detectCollision, playercube.detectCollision)) {
                if (fall == true && playercube.y+playercube.bitmap.getHeight() >= platform.y) {
                                                //If hitting platform roof while falling, attach!
                    playercube.y = platform.y-playercube.bitmap.getHeight()-GameTracker.getJumpHeight();
                    attachAny = true;
                    platform.platformAttach=true;
                }
                else if(attachAny==false) {     //Extra insurance.
                    alive = false;
                }
            }

            if(                             //If Player leaves the roof of the platform!
                    platform.platformAttach==true &&
                    playercube.x>platform.x+platform.bitmap.getWidth()
            ){
                attachAny=false; platform.platformAttach=false; fall=true;
            }
        }
        // For loop ends!

        if (jumpBool) {                     //On Touch => remove states & go up!
            attachAny=false;
            fall=false;
            playercube.update(GameTracker.getJumpHeight());

            if(playercube.y<=playercube.jumpYmax){      //On reaching maximum jump height => Fall!
                jumpBool=false;
                fall=true;
            }
        }

        if(fall==true){                     //Fall!
            playercube.update((-GameTracker.getJumpHeight()));
        }
        if((playercube.y+playercube.bitmap.getHeight())>=floor&&fall==true){    //Attach to floor!

            playercube.y=floor-playercube.bitmap.getHeight();
            attachAny=true;
        }

        if(attachAny==true){                //Attach!
            fall=false;
            playercube.startY=playercube.y;
        }
    }
    //Update ends!


    private void frameRate() {
        try{
            //     gameThread.sleep(100 / GameTracker.getSpeed());
            gameThread.sleep(33);           //<- What I used... Haven't tested ^^^^

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (playercube.y == playercube.startY){           // Disable event while in jump animation!
            disabledTouch = false;                        // When attaching to PLATFORM, startY needs to change as well!
        }
        if(disabledTouch == false){
            playercube.jumpYmax=playercube.y-120;         //Update max jump height!
            jumpBool = true;

            disabledTouch = true;
        }
        return false;
    }

}
