package com.example.cubeplatformer.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.example.cubeplatformer.Common.GameTracker;
import com.example.cubeplatformer.R;

import androidx.annotation.RequiresApi;

public class PlayerCube extends BaseEntity {

    public Bitmap bitmap;

    public int x;
    public int y;
    public int startY;
    public int rotationIndex;

    public Rect detectCollision;
    public int jumpYmax;

    public int[] rotations = {
            R.drawable.cube2,
            R.drawable.cube2,
            R.drawable.cube2,
            R.drawable.cube2rot225,
            R.drawable.cube2rot225,
            R.drawable.cube2rot225,
            R.drawable.cube2rot450,
            R.drawable.cube2rot450,
            R.drawable.cube2rot450,
            R.drawable.cube2rot675,
            R.drawable.cube2rot675,
            R.drawable.cube2rot675,
    };


    public PlayerCube(int sizeX, int sizeY, Context context) {//, Rect cube, Paint paint) {
        super(sizeX, sizeY, context);
        bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.cube2);
        this.context = context;

        x = 300;
        y = sizeY - bitmap.getHeight() - 120;

        jumpYmax = y - 120;
        startY = y;

        detectCollision = new Rect(x, y,
                x + bitmap.getWidth(),
                y + bitmap.getHeight());

    }

    @Override
    public void draw(Canvas canvas) {
    }

    // @Override
    public void update(int jump) {
        y -= jump;
        detectCollision.top = y;
        detectCollision.bottom = y + bitmap.getHeight();

    }

    public void updatecollisions() {
        detectCollision.top = y;
        detectCollision.bottom = y + bitmap.getHeight();
    }

    public void Rotation() {

        rotationIndex++;
        if (rotationIndex > rotations.length - 1) {
            rotationIndex = 0;
        }
        Bitmap bi = BitmapFactory.decodeResource(context.getResources(), rotations[rotationIndex]);

        bitmap = bi;
        detectCollision.top = y;
        detectCollision.bottom = y + bitmap.getHeight();
    }

    public Bitmap defaultrot() {
        rotationIndex=0;
        Bitmap bi = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.cube2);
        bitmap = bi;
        detectCollision.top = y;
        detectCollision.bottom = y + bitmap.getHeight();
        return bitmap;
    }


}
