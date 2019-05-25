package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import greenfoot.GreenfootImage;

public class InvisibleSprite extends Sprite {
    public InvisibleSprite() {
        super("invisible.png");
        GreenfootImage image = getImage();
        image.scale(1, 1);
        setImage(image);
    }

}
