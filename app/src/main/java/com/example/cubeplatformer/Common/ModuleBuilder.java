package com.example.cubeplatformer.Common;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.cubeplatformer.Entities.Platform;
import com.example.cubeplatformer.Entities.PlatformModule;
import com.example.cubeplatformer.Entities.PlayerCube;
import com.example.cubeplatformer.Entities.Spikes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ModuleBuilder {
    private static  Random RNGModulePicker = new Random();
    public static final ArrayList<PlatformModule> modules = new ArrayList<PlatformModule>();
    public static int canvas = 855;
    static int oneSpace = 45;
    public static int randomNumber;
    static int previousNumber = 999;

    public ModuleBuilder(Context context){

    }

    // This is where all the modules will be built and specified (spikes and platforms: x,y, size, etc..)
    public static void modulesMap(Context context, int sizeX, int sizeY, PlayerCube playerCube){
        modules.clear();

        ArrayList<Platform> platformBuilder = new ArrayList<Platform>();
        ArrayList<Spikes> spikesBuilder = new ArrayList<Spikes>();


        platformBuilder.add(new Platform(sizeX, sizeY, context,place(0),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(4),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(8),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(12),level(1)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(1),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(2),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(3),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(5),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(6),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(7),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(8),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(9),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(10),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(11),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(12),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,place(13),level(0)));
        cleanUpBuildersAndSave("moduleA", platformBuilder, spikesBuilder);

        platformBuilder.add(new Platform(sizeX, sizeY, context,place(0),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(4),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(5),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(6),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(7),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(8),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(11),level(2)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(1),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(2),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(3),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(6),level(2)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(9),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(10),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(11),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(12),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(13),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(14),level(0)));
        cleanUpBuildersAndSave("moduleB", platformBuilder, spikesBuilder);


        platformBuilder.add(new Platform(sizeX, sizeY, context,place(0),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(4),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(4),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(5),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(6),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(7),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(8),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(11),level(2)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(1),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(2),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(3),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(7),level(2)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(9),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(10),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(11),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(12),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(13),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(14),level(0)));
        cleanUpBuildersAndSave("moduleB2", platformBuilder, spikesBuilder);

        platformBuilder.add(new Platform(sizeX, sizeY, context,place(9),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(11),level(1)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(12),level(1)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(0),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(3),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(7),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(8),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(11),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(12),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(13),level(0)));

        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(11),level(2)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(12),level(2)));
        cleanUpBuildersAndSave("moduleC", platformBuilder, spikesBuilder);


        platformBuilder.add(new Platform(sizeX, sizeY, context,place(0),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(3),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(6),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(9),level(6)));

        platformBuilder.add(new Platform(sizeX, sizeY, context,place(9),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(10),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(13),level(2)));

        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(1),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(2),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(3),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(4),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(5),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(6),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(7),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(8),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(11),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(12),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(13),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(14),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(15),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(16),level(0)));

        platformBuilder.add(new Platform(sizeX, sizeY, context,place(10),level(5)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(11),level(5)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(12),level(5)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(10),level(6)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(11),level(6)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(12),level(6)));

        cleanUpBuildersAndSave("moduleD", platformBuilder, spikesBuilder);

        //up down up down up down

        platformBuilder.add(new Platform(sizeX, sizeY, context,place(0),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(3),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(5),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(6),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(9),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(11),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(12),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(15),level(2)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(1),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(2),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(3),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(4),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(7),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(8),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(9),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(10),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(13),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(14),level(0)));
        cleanUpBuildersAndSave("moduleE", platformBuilder, spikesBuilder);


        platformBuilder.add(new Platform(sizeX, sizeY, context,place(0),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(3),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(6),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(9),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(10),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(13),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(16),level(4)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(1),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(2),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(3),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(4),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(5),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(6),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(7),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(8),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(11),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(12),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(13),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(14),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(15),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(16),level(0)));

        cleanUpBuildersAndSave("moduleF", platformBuilder, spikesBuilder);

        platformBuilder.add(new Platform(sizeX, sizeY, context,place(0),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(1),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(2),level(0)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(4),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(6),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(7),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(10),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(11),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(12),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(13),level(4)));

        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(8), level(2)));

        cleanUpBuildersAndSave("moduleE", platformBuilder, spikesBuilder);

        platformBuilder.add(new Platform(sizeX, sizeY, context,place(0),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(1),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(2),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(3),level(2)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(7),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(8),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(9),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(10),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(11),level(4)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(11),level(6)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(12),level(6)));
        platformBuilder.add(new Platform(sizeX, sizeY, context,place(13),level(6)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(1),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(2),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(3),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(4),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(5),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(14),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(15),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(16),level(0)));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, place(17),level(0)));

        cleanUpBuildersAndSave("moduleF", platformBuilder, spikesBuilder);
    }

    // Random Module Picker
    public static PlatformModule getRandomModule(){
        randomNumber = RNGModulePicker.nextInt(modules.size());
        while(randomNumber == previousNumber){
            randomNumber = RNGModulePicker.nextInt(modules.size());
        }
        previousNumber = randomNumber;
        return modules.get(randomNumber);


       // return modules.get(randomNumber);
    }
    private static void cleanUpBuildersAndSave(String name, ArrayList<Platform> platforms, ArrayList<Spikes> spikes){
        ArrayList<Platform> storedPlatforms = new ArrayList<>();
        ArrayList<Spikes> storedSpikes = new ArrayList<>();

        for(Platform platform : platforms){
            storedPlatforms.add(platform);
        }

        for(Spikes spike : spikes){
            storedSpikes.add(spike);
        }

        modules.add(new PlatformModule(name, storedSpikes, storedPlatforms));

        spikes.clear();
        platforms.clear();
    }
    public static int place(int num){
        return (canvas + (num * 45));
    }

    public static int level(int num){
        return 315 - (num * 45);
    }
}
