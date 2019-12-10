package com.example.cubeplatformer.Entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class BaseEntity {

    private Rect cube;
    private Paint paint;

    public BaseEntity (int x, int y, Bitmap bitmap, Rect cube, Paint paint) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
        this.cube = cube;
        this.paint = paint;
    }

    private int x;
    private int y;

    private Bitmap bitmap;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Rect getCube() {
        return cube;
    }

    public void setCube(Rect cube) {
        this.cube = cube;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public abstract void draw(Canvas canvas);
    public abstract void update();

}
