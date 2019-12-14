package com.example.cubeplatformer.Entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Platform extends BaseEntity {

    public Platform(int x, int y, Bitmap bitmap, Rect cube, Paint paint) {
        super(x, y, bitmap, cube, paint);
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void update() {

    }
}
