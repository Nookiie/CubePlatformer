package com.example.cubeplatformer.Common;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.cubeplatformer.Entities.Platform;
import com.example.cubeplatformer.Entities.PlatformModule;
import com.example.cubeplatformer.Entities.Spikes;
import com.example.cubeplatformer.GameActivity;
import com.example.cubeplatformer.MainActivity;
import com.example.cubeplatformer.MainThread;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PlatformBuilder {
    public PlatformBuilder(Context context){
        modulesMap(context);
    }

    Random RNGModulePicker = new Random();
    ArrayList<PlatformModule> modules = new ArrayList<PlatformModule>();

    public void modulesMap(Context context){ // This is where all the modules will be built and specified (spikes and platforms: x,y, size, etc..)
        ArrayList<Platform> platformBuilder = new ArrayList<Platform>();
        ArrayList<Spikes> spikesBuilder = new ArrayList<Spikes>();

        spikesBuilder.add(new Spikes(12,12, context,700));
        spikesBuilder.add(new Spikes(60,80, context, 800));
        spikesBuilder.add(new Spikes(50,90,context,900));

        cleanUpBuildersAndSave("moduleA", platformBuilder, spikesBuilder);

        spikesBuilder.add(new Spikes(25,13,context,700));
        spikesBuilder.add(new Spikes(15, 23,context,800));

        cleanUpBuildersAndSave("moduleB", platformBuilder, spikesBuilder);
    }

    public PlatformModule getRandomModule(ArrayList<PlatformModule> modules){ // Random Module Picker
        int randomNumber = RNGModulePicker.nextInt(modules.size() - 1);

        return modules.get(randomNumber);
    }


    private void cleanUpBuildersAndSave(String name, ArrayList<Platform> platforms, ArrayList<Spikes> spikes){
        modules.add(new PlatformModule(name, spikes, platforms));

        spikes.clear();
        platforms.clear();
    }
}
