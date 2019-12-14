package com.example.cubeplatformer.Entities;

import java.util.Random;

public class Star {
    public int x;
    public int y;
    int maxX;
    int maxY;
    int speed;

    Random random = new Random();

    public Star(int screenX, int screenY){
        maxX = screenX;
        maxY = screenY;

        y = random.nextInt(maxY);
        x = random.nextInt(maxX);

        speed = random.nextInt(10) + 1;
    }

    public void update(){
        y += speed;

        if(y > maxY){
            y = -10;
            x = random.nextInt(maxX);
            speed = random.nextInt(10) + 1;
        }
    }
}
