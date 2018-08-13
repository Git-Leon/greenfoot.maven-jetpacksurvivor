package com.github.git_leon.jetpack_survivor_maven.utils;

import greenfoot.Color;
import greenfoot.GreenfootImage;

public class JFootTextImage extends GreenfootImage {
    public JFootTextImage(String string, int size, Color foreground, Color background, Color outline) {
        super(string, size, foreground, background, outline);
    }
    public JFootTextImage(String string, int size, Color foreground) {
        this(string, size, foreground, Color.BLACK, Color.WHITE);
    }
}
