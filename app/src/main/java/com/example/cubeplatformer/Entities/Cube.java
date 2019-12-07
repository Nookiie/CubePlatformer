package com.example.cubeplatformer.Entities;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cubeplatformer.Common.GameTracker;

public class Cube extends BaseEntity {

    public Cube (int x, int y, Bitmap bitmap, Rect cube, Paint paint) {
        super(x,y,bitmap,cube,paint);
    }
}
