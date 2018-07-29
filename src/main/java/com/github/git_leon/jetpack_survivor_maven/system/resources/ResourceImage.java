package com.github.git_leon.jetpack_survivor_maven.system.resources;

import greenfoot.GreenfootImage;

import java.util.HashMap;
import java.util.Map;

public class ResourceImage extends GreenfootImage {
    private static final Map<String, GreenfootImage> imageMap = new HashMap<>();

    public ResourceImage(String filename) throws IllegalArgumentException {
        super(filename);
    }

    public ResourceImage(int width, int height) {
        super(width, height);
    }

    public ResourceImage(GreenfootImage image) throws IllegalArgumentException {
        super(image);
    }

}
