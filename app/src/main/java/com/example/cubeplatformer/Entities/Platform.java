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
    int startY;
    int finalX=-10;         //When to delete! UNUSED!!!

    public boolean platformAttach=false;

    int maxX;
    int maxY;

    int speed = GameTracker.getSpeed();

    public Rect detectVert;
    public Rect detectCollision;



    public Platform(int sizeX, int sizeY, Context context, int startX,int startY){//, Bitmap bitmap, Rect cube, Paint paint) {
        super(sizeX, sizeY,context);//, bitmap, cube, paint);

        this.context = context;

        maxX = sizeX;
        maxY = sizeY;

        bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.platform1);
        x = startX;
        //startY = sizeY - bitmap.getHeight() - 120;
        y = startY;


        detectCollision=new Rect(x,y,x+bitmap.getWidth(),y+bitmap.getHeight());
/*
        detectTop=new Rect(x+2,
                y,
                x+bitmap.getWidth(),
                y
        );*/

        detectVert=new Rect(x,
                y+ GameTracker.getJumpHeight()+1,
                x+GameTracker.getJumpHeight()+1,
                y+bitmap.getHeight()
        );



    }

    @Override
    public void draw(Canvas canvas) {

    }

    //  @Override
    public void update() {

        x -= speed;
/*
        detectTop.left= x+2;
        detectTop.top= y;
        detectTop.right= x+bitmap.getWidth();
        detectTop.bottom= y;
*/
        detectVert.left= x;
        detectVert.top= y+16;
        detectVert.right= x+16;
        detectVert.bottom= y+bitmap.getHeight();


        detectCollision.left=x;
        detectCollision.top=y;
        detectCollision.right=x+bitmap.getWidth();
        detectCollision.bottom=y+bitmap.getHeight();

    }
}
