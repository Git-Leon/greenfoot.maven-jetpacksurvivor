package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import com.github.git_leon.jetpack_survivor_maven.worlds.SpriteWorld;
import greenfoot.GreenfootImage;

public class InvisibleSprite extends Sprite {
    public InvisibleSprite() {
        super("invisible.png");
        GreenfootImage image = getImage();
        image.scale(0, 0);
        setImage(image);
    }

}
