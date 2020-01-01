package com.example.cubeplatformer.Entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlatformModule {
    private String name;
    public ArrayList<Spikes> spikes = new ArrayList<Spikes>();
    public ArrayList<Platform> platforms = new ArrayList<Platform>();

    public PlatformModule(String name, ArrayList<Spikes> spikes, ArrayList<Platform> platforms) {
        this.name = name;
        this.spikes = spikes;
        this.platforms = platforms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
