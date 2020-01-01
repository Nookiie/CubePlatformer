package com.example.cubeplatformer.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cubeplatformer.Common.GameTracker;
import com.example.cubeplatformer.R;

public class Spikes extends BaseEntity {

    public Bitmap bitmap;
    Context context;
    public int x;
    public int y;
    //int startX=300;     //Take From external class LevelBuilder OR something.
    int finalX = -10;
    public boolean isAlive = true;

    // int maxX;
    // int maxY;

    int speed = GameTracker.getSpeed();


    public Rect detectVert;
    public Rect detectHor;


    public Spikes(int sizeX, int sizeY, Context context, int startX, int startY) {//, Bitmap bitmap, Rect cube, Paint paint) {
        super(sizeX, sizeY, context);//, bitmap, cube, paint);

        this.context = context;

        //    maxX = sizeX;
        //    maxY = sizeY;

        bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.spike2);
        x = startX;
        //startY = sizeY - bitmap.getHeight() - 120;
        y = startY;


        detectHor = new Rect(x,
                y + bitmap.getHeight() - 1,
                x + bitmap.getWidth(),
                y + bitmap.getHeight()
        );

        detectVert = new Rect(x + (bitmap.getWidth() / 2),
                y + 6,
                x + (bitmap.getWidth() / 2),
                y + bitmap.getHeight()
        );

    }

    @Override
    public void draw(Canvas canvas) {

    }

    // @Override
    public void update() {

        x -= speed;

        detectHor.left = x + 1;
        detectHor.top = y + bitmap.getHeight() - 1;
        detectHor.right = x + bitmap.getWidth();
        detectHor.bottom = y + bitmap.getHeight();

        detectVert.left = x + (bitmap.getWidth() / 2);
        detectVert.top = y + 15;
        detectVert.right = x + (bitmap.getWidth() / 2);
        detectVert.bottom = y + bitmap.getHeight();

    }

}
