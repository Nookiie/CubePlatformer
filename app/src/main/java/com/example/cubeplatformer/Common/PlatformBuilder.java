package com.example.cubeplatformer.Common;

import com.example.cubeplatformer.Entities.Platform;
import com.example.cubeplatformer.Entities.PlatformModule;
import com.example.cubeplatformer.Entities.Spikes;

import java.util.ArrayList;
import java.util.Random;

public class PlatformBuilder {
    public PlatformBuilder(){

    }

    Random RNGModulePicker = new Random();
    ArrayList<PlatformModule> modules = new ArrayList<PlatformModule>();

    public void modulesMap(){ // This is where all the modules will be built and specified (spikes and platforms: x,y, size, etc..)

    }

    public PlatformModule getRandomModule(ArrayList<PlatformModule> modules){ // Random Module Picker
        int randomNumber = RNGModulePicker.nextInt(modules.size() - 1);

        return modules.get(randomNumber);
    }
}
