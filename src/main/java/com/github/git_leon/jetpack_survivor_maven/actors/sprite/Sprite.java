package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import com.github.git_leon.jetpack_survivor_maven.worlds.SpriteWorld;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Sprite extends Actor implements SpriteInterface {

    protected final List<GreenfootImage> imageList;
    protected final WorldSensorDecoration worldSensor = new WorldSensorDecoration(this);

    public Sprite(String imageName) {
        this(new String[]{imageName});
    }

    public Sprite(String... imageNames) {
        this.imageList = new ArrayList<>();
        List<String> imageNameList = new ArrayList<>(Arrays.asList(imageNames));
        imageNameList.forEach(image -> this.imageList.add(new GreenfootImage(image)));
        setImage(imageList.get(0));
    }

    public Sprite(String basename, String suffix, int noOfImages) {
        GreenfootImage[] immageArray = new GreenfootImage[noOfImages];
        for (int i = 0; i < noOfImages; i++)
            immageArray[i] = new GreenfootImage(basename + i + suffix);
        imageList = Arrays.asList(immageArray);
        setImage(imageList.get(0));
    }

    public Sprite(List<GreenfootImage> imageList) {
        this.imageList = imageList;
    }

    @Override
    public Sprite getOneObjectAtOffset(int x, int y, Class cls) {
        return (Sprite) super.getOneObjectAtOffset(x, y, cls);
    }

    @Override
    public final SpriteWorld getWorld() {
        return (SpriteWorld) super.getWorld();
    }

    @Override
    protected final Sprite getOneIntersectingObject(Class<?> cls) {
        return (Sprite) super.getOneIntersectingObject(cls);
    }
}
