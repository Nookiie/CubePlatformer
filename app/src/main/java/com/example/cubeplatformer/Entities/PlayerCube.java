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

    public Rect detectCollision;
    public int jumpYmax;

    public PlayerCube(int sizeX, int sizeY,Context context){//, Rect cube, Paint paint) {
        super(sizeX,sizeY,context);
        bitmap= BitmapFactory.decodeResource(context.getResources(),
                R.drawable.cube1);
        this.context = context;

        x = 300;
        y = sizeY - bitmap.getHeight() - 120;   //To see how the matrix bugs out
                                                //Should be ~120

        jumpYmax=y-120;
        startY=y;

        detectCollision = new Rect(x, y,
                x + bitmap.getWidth(),
                y + bitmap.getHeight());

    }

    @Override
    public void draw(Canvas canvas) {

    }

   // @Override
    public void update(int jump) {

        y -= jump;             //This works for jumping
     //   bitmap=RotateBitmap(bitmap,45);     //pass the angle you want to rotate

        detectCollision.top=y;
        detectCollision.bottom=y+bitmap.getHeight();

    }
    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        Bitmap bi=Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
       // Bitmap bi=Bitmap.createBitmap(source, 0, 0, source.getWidth()/2, source.getHeight()/2, matrix, true);
            //THIS IS THE PROBLEMS^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            //TRY THE SECOND TO DECREASE THE SIZE AND BUG OUT AGAIN... AT LEAST IT DOESN'T MOVE!
        return bi;

    }





}
