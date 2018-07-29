package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import greenfoot.GreenfootImage;

import java.util.Arrays;
import java.util.List;

public abstract class AnimatedSprite extends Sprite {
    protected int lifetime;
    private int currentImageIndex = 0;

    public AnimatedSprite(String basename, String suffix, int noOfImages) {
        super(createImages(basename, suffix, noOfImages));
    }

    public AnimatedSprite(List<GreenfootImage> imageList) {
        super(imageList);
    }


    public void animate(int frequency) {
        if (lifetime % frequency == 1) {
            animate();
        }
        lifetime++;
    }

    public void animate() {
        if (imageList != null) {
            currentImageIndex++;
            currentImageIndex %= imageList.size();
            setImage(imageList.get(currentImageIndex));
        }
    }


    public void flipImagesHorizontally() {
        imageList.forEach(image -> image.mirrorHorizontally());
    }

    public void flipImagesVertically() {
        imageList.forEach(image -> image.mirrorVertically());
    }

    public static List<GreenfootImage> createImages(String basename, String suffix, int noOfImages) {
        GreenfootImage[] immageArray = new GreenfootImage[noOfImages];
        for (int i = 0; i < noOfImages; i++)
            immageArray[i] = new GreenfootImage(basename + i + suffix);
        List<GreenfootImage> imageList = Arrays.asList(immageArray);
        return imageList;
    }

    public List<GreenfootImage> getImages() {
        return imageList;
    }
}
