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
import com.example.cubeplatformer.Common.ModuleBuilder;
import com.example.cubeplatformer.Entities.Platform;
import com.example.cubeplatformer.Entities.PlatformModule;
import com.example.cubeplatformer.Entities.PlayerCube;
import com.example.cubeplatformer.Entities.Spikes;
import com.example.cubeplatformer.Entities.Star;

import java.util.ArrayList;

public class IvanGameView extends SurfaceView implements Runnable{

    boolean detected=false;

    boolean alive;
    int timer;
    int score = GameTracker.getScore();
    int delayfall=0;
    int attachcount=0;
    PlayerCube playercube;
    boolean disabledTouch=false;
    boolean itsAttachedAlready=false;

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
    boolean queuedJump=false;

    int sizeX;
    int sizeY;
    boolean jumpBool = false;
    public boolean previoulyAttached = false;

    int stop=270;

    public IvanGameView(Context context, int sizeX, int sizeY) {
        super(context);

        alive = true;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        floor=sizeY-120;

        //spikes.add(new Spikes(sizeX, sizeY,getContext(),745));
        //spikes.add(new Spikes(sizeX, sizeY,getContext(),700));

        platforms.add(new Platform(sizeX, sizeY, getContext(), 845, 270));
        platforms.add(new Platform(sizeX, sizeY, getContext(), 700, 315));
        platforms.add(new Platform(sizeX, sizeY, getContext(), 1145, 315));
        platforms.add(new Platform(sizeX, sizeY, getContext(), 1100, 315));
        platforms.add(new Platform(sizeX, sizeY, getContext(), 1545, 270));
        platforms.add(new Platform(sizeX, sizeY, getContext(), 1400, 315));


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
        while(alive || GameTracker.isGodMode()){
            frameRate();
            update();
            draw();

            // For spikes!
            if(timer % 150 == 0) {
                spikes.add(new Spikes(sizeX, sizeY, getContext(),900));
            }


            // Module Spawn
            if(timer % GameTracker.getModuleRate() == 0){
                // Initializing the Module Builder
                ModuleBuilder.modulesMap(getContext(), sizeX, sizeY, playercube);
                PlatformModule chosenModule = ModuleBuilder.getRandomModule();

                for(Platform platform : chosenModule.platforms){
                    platforms.add(platform);
                }

                for(Spikes spike : chosenModule.spikes){
                    spikes.add(spike);
                }
            }
/*
                                //Makes first 2 platforms are really close to show multi-level jump!
            if(timer % 100 == 0) {
                platforms.add(new Platform(sizeX, sizeY, getContext(), 700, sizeY-180));
            }
            if(timer % 122 == 0) {
                platforms.add(new Platform(sizeX, sizeY, getContext(), 700,playercube.y-60));
            }*/
        }
        //Game Over State
        GameTracker.scores.add(score);
    }
    //Run Ends!

    public void draw(){
        if(surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();

            canvas.drawText("Already: " +itsAttachedAlready,// attachcount,//GameTracker.getScore(),
                    canvas.getWidth() / 2 ,
                    80,
                    paint);
            canvas.drawText("count: " +attachcount,// attachcount,//GameTracker.getScore(),
                    canvas.getWidth() / 2 ,
                    110,
                    paint);
            canvas.drawText("fall: " +fall,// attachcount,//GameTracker.getScore(),
                    canvas.getWidth() / 2 ,
                    140,
                    paint);
            canvas.drawText("det: " +detected,// attachcount,//GameTracker.getScore(),
                    canvas.getWidth() / 2 ,
                    170,
                    paint);


            canvas.drawColor(Color.argb(200,131,159,255));

            paint.setColor(Color.WHITE);
            paint.setTextSize(50);



            canvas.drawBitmap(
                    playercube.bitmap,
                    playercube.x,
                    playercube.y,
                    paint
            );
            //  canvas.drawRect(playercube.detectCollision,paint);      //Playercube collision figure!

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


                // canvas.drawRect(platform.detectCollision, paint);       //Paints the collision area... AKA all of it!
                // canvas.drawRect(platform.detectVert, paint);
                // canvas.drawRect(platform.detectBot, paint);
                // canvas.drawRect(platform.detectTop, paint);

            }

            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }

    private void update() {
        timer++;

        if(timer % GameTracker.getScoreRate() == 0){
            score++;
        }

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

            attachcount=0;

            if(timer%2==0) {                                    //Fixes stuttering when calculating

                for (int i = 0; i < platforms.size(); i++) {

                    if (platforms.get(i).multiAttach == true) {
                        attachcount++;
                    }
                }//inner for loop ends

                if(attachcount>0){
                    itsAttachedAlready=true;
                }
                if(attachcount==0){
                    itsAttachedAlready=false;
                }

            }//timer loop ends

            if(itsAttachedAlready==false){
                fall=true;

            }
            if(itsAttachedAlready){
                attachAny=true;
                playercube.defaultrot();
                fall=false;
            }

            if(disabledTouch==true&& Rect.intersects(platform.detectTop,playercube.detectCollision)&&
                           !Rect.intersects(platform.detectVert,playercube.detectCollision)
            )
            {
                if(jumpBool&&playercube.x+playercube.bitmap.getWidth()<platform.x+GameTracker.getSpeed()+1){
                    detected=true;      //This might actually never proc
                    alive=false;
                }
                if(jumpBool==false) {       //if colliding and not going up, attach! Very important
                    platform.multiAttach = true;

                    detected = true;
                    attachAny = true;
                    playercube.defaultrot();

                    fall = false;

                    playercube.y = platform.y - playercube.bitmap.getHeight();
                    playercube.startY = playercube.y;
                }
            }

            if (Rect.intersects(platform.detectCollision, playercube.detectCollision))
            {
                if(Rect.intersects(platform.detectBot,playercube.detectCollision))
                {                                                           //Extra insurance for bottom
                    alive = false;
                    return;
                }

                if (fall == true && playercube.y+playercube.bitmap.getHeight() >= platform.y) {
                                                //If hitting platform roof while falling, attach!
                    fall=false;
                    playercube.y = platform.y-playercube.bitmap.getHeight();//-GameTracker.getJumpHeight();
                    attachAny = true;

                    platform.multiAttach=true;
                    playercube.defaultrot();
                    playercube.y=platform.y-playercube.bitmap.getHeight();

                    platform.platformAttach = true;
                }
            }

            if(platform.platformAttach==true &&
                    playercube.x > platform.x + platform.bitmap.getWidth())
            {
                platform.platformAttach=false;
                platform.multiAttach=false;

            }
            if(platform.multiAttach==true&&playercube.x>platform.x+platform.bitmap.getWidth())
            {
                platform.multiAttach=false;
            }

            playercube.updatecollisions();
            if(Rect.intersects(platform.detectVert,playercube.detectCollision)&&itsAttachedAlready==false){
                //Left Side of platform minus Jump Height shouldn't intersect!

                if((fall==false&&disabledTouch==true)||
                        (playercube.x+playercube.bitmap.getWidth()<platform.x+GameTracker.getSpeed()))
                {
                    alive = false;
                    return;
                }
            }
        }//FOR LOOP ENDS!

        if(itsAttachedAlready==false){
            fall=true;
        }

        if(playercube.y == playercube.startY&&queuedJump==true&&attachAny){        //Jump Queue logic
            playercube.jumpYmax=playercube.y - GameTracker.getMaxJump();
            jumpBool=true;
            queuedJump=false;
        }
        if (jumpBool==true) { //On Touch => remove states & go up!
            playercube.Rotation();
            attachAny = false;
            fall = false;

            if(playercube.y <= playercube.jumpYmax+20){      //On reaching maximum jump height => Fall!
                delayfall++;
                if(delayfall>3) {               //Delay fall at top for smoother motion
                    jumpBool = false;
                    fall = true;
                    delayfall=0;
                }
            }
            else{
                playercube.update(GameTracker.getJumpHeight());
            }
        }

        if(fall==true){                     //Fall!
            playercube.update((-GameTracker.getJumpHeight()));
            playercube.Rotation();

        }

        if((playercube.y + playercube.bitmap.getHeight())>=floor&&fall==true){    //Attach to floor!

            attachAny=true;
            fall=false;
            playercube.rotationIndex=playercube.rotations.length;     //index >3, ++1 => index=0
            playercube.Rotation();
            playercube.y=floor-playercube.bitmap.getHeight();
            playercube.startY=playercube.y;
        }
    }
    //Update ends!

    private void frameRate() {
        try{
            //     gameThread.sleep(100 / GameTracker.getSpeed());

            gameThread.sleep(6);           //<- What I used... Haven't tested ^^^^

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(fall==true) {
            queuedJump = true;        //Queues up the jump only when falling
        }

        if (playercube.y == playercube.startY){           // Disable event while in jump animation!
            disabledTouch = false;                        // When attaching to PLATFORM, startY needs to change as well!

        }
        if(disabledTouch == false){

            playercube.jumpYmax=playercube.y - GameTracker.getMaxJump();         //Update max jump height!
            jumpBool = true;

            disabledTouch = true;
        }
        return false;
    }

}
