package com.example.cubeplatformer.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cubeplatformer.R;

public class Spikes extends BaseEntity {

    public Bitmap bitmap;
    Context context;
    public int x;
    public int y;
    //int startX=300;     //Take From external class LevelBuilder OR something.
    int startY;
    int finalX=-10;

    int maxX;
    int maxY;

    int speed = 15;
    public Spikes(int sizeX, int sizeY, Context context, int startX){//, Bitmap bitmap, Rect cube, Paint paint) {
        super(sizeX, sizeY,context);//, bitmap, cube, paint);

        this.context = context;

        maxX = sizeX;
        maxY = sizeY;

        bitmap= BitmapFactory.decodeResource(context.getResources(),
                R.drawable.spike1);
        x=startX;
        startY= sizeY - bitmap.getHeight() - 120;
        y=startY;
    }

    @Override
    public void draw(Canvas canvas) {

    }

   // @Override
    public void update() {
        x -= speed;
    }

}
