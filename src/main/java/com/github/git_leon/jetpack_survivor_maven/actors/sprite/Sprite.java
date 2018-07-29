package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import com.github.git_leon.jetpack_survivor_maven.worlds.SpriteWorld;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Sprite extends Actor implements SpriteInterface {

    private final List<GreenfootImage> images;
    protected final WorldSensorDecoration worldSensor = new WorldSensorDecoration(this);

    public Sprite(String imageName) {
        this(new String[]{imageName});
    }

    public Sprite(String... imageNames) {
        this.images = new ArrayList<>();
        List<String> imageNameList = new ArrayList<>(Arrays.asList(imageNames));
        imageNameList.forEach(image -> this.images.add(new GreenfootImage(image)));
        setImage(images.get(0));
    }

    @Override
    public Sprite getOneObjectAtOffset(int x, int y, Class cls) {
        return (Sprite)super.getOneObjectAtOffset(x,y,cls);
    }

    @Override
    public final SpriteWorld getWorld() {
        return (SpriteWorld)super.getWorld();
    }

    @Override
    protected final Sprite getOneIntersectingObject(Class<?> cls) {
        return getOneIntersectingObject(cls);
    }
}
