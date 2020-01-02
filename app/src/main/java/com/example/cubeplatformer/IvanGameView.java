package com.example.cubeplatformer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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

import java.util.ArrayList;

public class IvanGameView extends SurfaceView implements Runnable {

    boolean alive;
    int timer;
    int othertimer;
    int score = GameTracker.getScore();
    int delayfall = 0;
    int attachcount = 0;
   // int speedRate = 150;
   // int jumpRate = 100;

    PlayerCube playercube;
    boolean disabledTouch = false;
    boolean itsAttachedAlready = false;
    boolean firstModule = true;

    boolean attachAny = false;
    boolean fall = false;
    int floor;

    public static int xx;
    public static int yy;
    public static int floorbetter;
    public static int elementSize;

    ArrayList<Spikes> spikes = new ArrayList<>();
    ArrayList<Platform> platforms = new ArrayList<>();


    Paint paint;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Thread gameThread;
    boolean queuedJump = false;


    int sizeX;
    int sizeY;
    boolean jumpBool = false;

    public IvanGameView(Context context, int sizeX, int sizeY) {
        super(context);

        alive = true;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        playercube = new PlayerCube(sizeX, sizeY, context);
        elementSize = playercube.bitmap.getWidth();
        GameTracker.setMaxJump(elementSize * 3 + elementSize / 3);
        GameTracker.setModuleRate(elementSize*5);

        surfaceHolder = getHolder();

        paint = new Paint();

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (alive || GameTracker.isGodMode()) {
            frameRate();
            update();
            draw();

            // Module Spawn
            if (timer % GameTracker.getModuleRate() == 0 || (firstModule && othertimer > 0)) {
                firstModule = false;
                // Initializing the Module Builder
                ModuleBuilder.modulesMap(getContext(), sizeX, sizeY, playercube);

                PlatformModule chosenModule = ModuleBuilder.getRandomModule();

                for (Platform platform : chosenModule.platforms) {
                    platforms.add(platform);
                }

                for (Spikes spike : chosenModule.spikes) {
                    spikes.add(spike);
                }
            }

        }
        //Game Over State
        GameTracker.scores.add(score);

        GameFragment.stopMusic();
        Intent intent = new Intent(getContext(), GameOverActivity.class);
        getContext().startActivity(intent);
        ((Activity) getContext()).finish();

    }
    //Run Ends!


    public void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();

            floor = canvas.getHeight();
            //elementSize=platforms.get(0).bitmap.getWidth();
            xx = canvas.getWidth();
            yy = canvas.getHeight();
            floorbetter = floor;
            othertimer = 1;

            //if (elementSize>50) {//canvas.getWidth() / speedRate)
                GameTracker.setSpeed((int) (elementSize / 7.5));
                GameTracker.setJumpHeight(GameTracker.getMaxJump() / 15);
           // }
           // if(GameTracker.getJumpHeight() < canvas.getWidth() / jumpRate)
           //         GameTracker.setJumpHeight(canvas.getWidth() / jumpRate);

           canvas.drawText("score: " + score,
                    canvas.getWidth() / 2 - 40,
                    50,
                    paint);


            canvas.drawColor(Color.argb(200, 131, 159, 255));

            paint.setColor(Color.WHITE);
            paint.setTextSize(50);

            canvas.drawBitmap(
                    playercube.bitmap,
                    playercube.x,
                    playercube.y,
                    paint
            );
            //  canvas.drawRect(playercube.detectCollision,paint);      //Playercube collision figure!

            for (Spikes spike : spikes) {
                canvas.drawBitmap(spike.bitmap,
                        spike.x,
                        spike.y,
                        paint);
                //canvas.drawRect(spike.detectHor,paint);         //Paint collision areas in white!
                //canvas.drawRect(spike.detectVert,paint);
            }

            for (Platform platform : platforms) {
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

        if (timer % GameTracker.getScoreRate() == 0) {
            score++;
        }

        for (Spikes spike : spikes) {
            spike.update();
            if (spike.x + spike.bitmap.getWidth() < 0) {
                spike.isAlive = false;
            }
            if (
                    Rect.intersects(spike.detectHor, playercube.detectCollision) ||
                            Rect.intersects(spike.detectVert, playercube.detectCollision)
            ) {
                alive = false;
            }
        }

        for (Platform platform : platforms) {

            platform.update();

            if (platform.x + platform.bitmap.getWidth() < 0) {
                platform.isAlive = false;
            }
            attachcount = 0;

            if (timer % 2 == 0) {                                    //Fixes stuttering when calculating

                for (int i = 0; i < platforms.size(); i++) {

                    if (platforms.get(i).multiAttach == true) {
                        attachcount++;
                    }
                }//inner for loop ends

                if (attachcount > 0) {
                    itsAttachedAlready = true;
                }
                if (attachcount == 0) {
                    itsAttachedAlready = false;
                }

            }//timer loop ends

            if (itsAttachedAlready == false) {
                if(playercube.y+playercube.bitmap.getHeight()<floor)
                    fall = true;

            }
            if (itsAttachedAlready) {
                attachAny = true;
                if (playercube.rotationIndex > 2) {
                    playercube.defaultrot();
                }
                fall = false;
            }

            if (disabledTouch == true && Rect.intersects(platform.detectTop, playercube.detectCollision) &&
                    !Rect.intersects(platform.detectVert, playercube.detectCollision)
            ) {
                if (jumpBool && playercube.x + playercube.bitmap.getWidth() < platform.x + GameTracker.getSpeed() + 1
                        && playercube.y > platform.y - 15) {
                    alive = false;
                }
                if (jumpBool == false) {       //if colliding and not going up, attach! Very important
                    platform.multiAttach = true;

                    attachAny = true;
                    playercube.defaultrot();

                    fall = false;

                    playercube.y = platform.y - playercube.bitmap.getHeight();
                    playercube.startY = playercube.y;
                }
            }

            if (Rect.intersects(platform.detectCollision, playercube.detectCollision)) {
                if (Rect.intersects(platform.detectBot, playercube.detectCollision)) {                                                           //Extra insurance for bottom
                    alive = false;
                    return;
                }

                if (fall == true && playercube.y + playercube.bitmap.getHeight() >= platform.y) {
                    //If hitting platform roof while falling, attach!
                    fall = false;
                    playercube.y = platform.y - playercube.bitmap.getHeight();//-GameTracker.getJumpHeight();
                    attachAny = true;

                    platform.multiAttach = true;
                    playercube.defaultrot();
                    playercube.y = platform.y - playercube.bitmap.getHeight();

                    platform.platformAttach = true;
                }
            }

            if (platform.platformAttach == true &&
                    playercube.x > platform.x + platform.bitmap.getWidth()) {
                platform.platformAttach = false;
                platform.multiAttach = false;

            }
            if (platform.multiAttach == true && playercube.x > platform.x + platform.bitmap.getWidth()) {
                platform.multiAttach = false;
            }

            playercube.updatecollisions();
            if (Rect.intersects(platform.detectVert, playercube.detectCollision) && itsAttachedAlready == false) {
                //Left Side of platform minus Jump Height shouldn't intersect!

                if ((fall == false && disabledTouch == true) ||
                        (playercube.x + playercube.bitmap.getWidth() < platform.x + GameTracker.getSpeed())) {
                    alive = false;
                    return;
                }
            }
        }//FOR LOOP ENDS!

        if (itsAttachedAlready == false) {
            if(playercube.y+playercube.bitmap.getHeight()<floor)
            fall = true;
        }

        if (playercube.y == playercube.startY && queuedJump == true && attachAny) {        //Jump Queue logic
            playercube.jumpYmax = playercube.y - GameTracker.getMaxJump();
            jumpBool = true;
            queuedJump = false;
        }
        if (jumpBool == true) { //On Touch => remove states & go up!
            playercube.Rotation();

            attachAny = false;
            fall = false;

            if (playercube.y <= playercube.jumpYmax + 20) {      //On reaching maximum jump height => Fall!
                delayfall++;
                if (delayfall > 3) {               //Delay fall at top for smoother motion
                    jumpBool = false;
                    fall = true;
                    delayfall = 0;
                }
            } else {
                playercube.update(GameTracker.getJumpHeight());
            }
        }

        if (fall == true) {                     //Fall!
            playercube.update((-GameTracker.getJumpHeight()));
            playercube.Rotation();
        }

        if ((playercube.y + playercube.bitmap.getHeight()) >= floor && fall == true) {    //Attach to floor!

            attachAny = true;
            fall = false;
            if (playercube.rotationIndex > 2) {
                playercube.defaultrot();
            }
            playercube.y = floor - playercube.bitmap.getHeight();
            playercube.startY = playercube.y;
        }
        for (int i = 0; i < platforms.size(); i++) {
            if (platforms.get(0).isAlive == false) {
                platforms.remove(0);
            }
        }
        for (int i = 0; i < spikes.size(); i++) {
            if (spikes.get(0).isAlive == false) {
                spikes.remove(0);
            }
        }
    }
    //Update ends!

    private void frameRate() {
        try {
            gameThread.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (fall == true) {
            queuedJump = true;        //Queues up the jump only when falling
        }

        if (playercube.y == playercube.startY) {           // Disable event while in jump animation!
            disabledTouch = false;                        // When attaching to PLATFORM, startY needs to change as well!

        }
        if (disabledTouch == false) {
            playercube.jumpYmax = playercube.y - GameTracker.getMaxJump();         //Update max jump height!
            jumpBool = true;

            disabledTouch = true;
        }
        return false;
    }

}
