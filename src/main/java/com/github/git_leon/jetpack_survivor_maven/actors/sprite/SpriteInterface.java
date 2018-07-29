package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import com.github.git_leon.jetpack_survivor_maven.worlds.SpriteWorld;
import greenfoot.GreenfootImage;

/**
 * A common interface between Sprite, SpriteFacade, and SpriteDecorator
 */
public interface SpriteInterface<SpriteSubType extends SpriteInterface> {
    void act();

    int getX() throws IllegalStateException;

    int getY();

    int getRotation();

    void setRotation(int rotation);

    void setLocation(int x, int y);

    GreenfootImage getImage();

    void setImage(String filename) throws IllegalArgumentException;

    void setImage(GreenfootImage image);

    void move(int degrees);

    void turn(int degrees);

    SpriteSubType getOneObjectAtOffset(int x, int y, Class<SpriteSubType> cls);

    <SpriteWorldSubType extends SpriteWorld> SpriteWorldSubType getWorld();
}