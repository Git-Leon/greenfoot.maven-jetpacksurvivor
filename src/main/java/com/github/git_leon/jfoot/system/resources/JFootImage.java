package com.github.git_leon.jfoot.system.resources;

import greenfoot.GreenfootImage;

import java.util.HashMap;
import java.util.Map;

public class JFootImage extends GreenfootImage {
    private static final Map<String, GreenfootImage> imageMap = new HashMap<>();

    public JFootImage(String filename) throws IllegalArgumentException {
        super(filename);
    }

    public JFootImage(int width, int height) {
        super(width, height);
    }

    public JFootImage(GreenfootImage image) throws IllegalArgumentException {
        super(image);
    }

}
