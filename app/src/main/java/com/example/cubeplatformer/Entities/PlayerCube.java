package com.example.cubeplatformer.Entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cubeplatformer.Common.GameTracker;

public class PlayerCube extends BaseEntity {

    public PlayerCube(int x, int y, Bitmap bitmap, Rect cube, Paint paint) {
        super(x,y,bitmap,cube,paint);
    }


}
