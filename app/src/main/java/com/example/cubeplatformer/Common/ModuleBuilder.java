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

    public ModuleBuilder(Context context){

    }

    // This is where all the modules will be built and specified (spikes and platforms: x,y, size, etc..)
    public static void modulesMap(Context context, int sizeX, int sizeY, PlayerCube playerCube){
        modules.clear();

        ArrayList<Platform> platformBuilder = new ArrayList<Platform>();
        ArrayList<Spikes> spikesBuilder = new ArrayList<Spikes>();

        spikesBuilder.add(new Spikes(sizeX, sizeY, context,playerCube.x + 120));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context, playerCube.x + 130));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,playerCube.x + 140));
        platformBuilder.add(new Platform(sizeX, sizeY, context,playerCube.x + 100,10));

        cleanUpBuildersAndSave("moduleA", platformBuilder, spikesBuilder);

        spikesBuilder.add(new Spikes(sizeX, sizeY, context,playerCube.x + 150));
        spikesBuilder.add(new Spikes(sizeX, sizeY, context,playerCube.x + 170));
        platformBuilder.add(new Platform(sizeX,sizeY, context,playerCube.x + 540, 450));

        cleanUpBuildersAndSave("moduleB", platformBuilder, spikesBuilder);
    }

    // Random Module Picker
    public static PlatformModule getRandomModule(){
        int randomNumber = RNGModulePicker.nextInt(modules.size());

        return modules.get(randomNumber);
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
}
