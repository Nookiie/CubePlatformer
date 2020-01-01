package com.example.cubeplatformer.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cubeplatformer.Common.GameTracker;
import com.example.cubeplatformer.R;

public class Platform extends BaseEntity {


    public Bitmap bitmap;
    Context context;
    public int x;
    public int y;
    //int startX=300;       //Take From external class LevelBuilder OR something.
    // int startY;
    // int finalX=-10;         //When to delete! UNUSED!!!
    public boolean flag = true;
    public boolean isAlive = true;

    public boolean platformAttach = false;
    public boolean multiAttach = false;

    // int maxX;
    // int maxY;

    int speed = GameTracker.getSpeed();

    public Rect detectVert;
    public Rect detectBot;
    public Rect detectTop;
    public Rect detectCollision;


    public Platform(int sizeX, int sizeY, Context context, int startX, int startY) {//, Bitmap bitmap, Rect cube, Paint paint) {
        super(sizeX, sizeY, context);//, bitmap, cube, paint);

        this.context = context;

        //  maxX = sizeX;
        //  maxY = sizeY;

        bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.platform2);
        x = startX;
        //startY = sizeY - bitmap.getHeight() - 120;
        y = startY;


        detectCollision = new Rect(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());

        detectBot = new Rect(x,
                y + bitmap.getHeight() - 5,
                x + bitmap.getWidth(),
                y + bitmap.getHeight() - 1
        );
        detectTop = new Rect(x,
                y - 3,
                x + bitmap.getWidth(),
                y
        );

        detectVert = new Rect(x,
                y + 10,
                x + GameTracker.getJumpHeight() + 1,
                y + bitmap.getHeight()
        );


    }

    @Override
    public void draw(Canvas canvas) {

    }

    //  @Override
    public void update() {

        x -= speed;

        detectBot.left = x + 2;
        detectBot.top = y + bitmap.getHeight() - 5;
        detectBot.right = x + bitmap.getWidth();
        detectBot.bottom = y + bitmap.getHeight() - 1;

        detectTop.left = x + 1;
        detectTop.top = y - 10;
        detectTop.right = x + bitmap.getWidth();
        detectTop.bottom = y;

        detectVert.left = x;
        detectVert.top = y + 10;
        detectVert.right = x + 1;
        detectVert.bottom = y + bitmap.getHeight();


        detectCollision.left = x + 9;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();

    }
}
