package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import com.github.git_leon.jetpack_survivor_maven.worlds.SpriteWorld;
import greenfoot.GreenfootImage;


/**
 * The purpose of this class is to model invisible sprite decorations;
 * i.e. - sensors
 */
public class SpriteFacade implements SpriteWrapper  {
    protected final Sprite sprite;

    public SpriteFacade(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void act() {
        sprite.act();
    }

    @Override
    public int getX() throws IllegalStateException {
        return sprite.getX();
    }

    @Override
    public int getY() {
        return sprite.getY();
    }

    @Override
    public int getRotation() {
        return sprite.getRotation();
    }

    @Override
    public void setRotation(int rotation) {
        sprite.setRotation(rotation);
    }

    @Override
    public void setLocation(int x, int y) {
        sprite.setLocation(x, y);
    }

    @Override
    public SpriteWorld getWorld() {
        return sprite.getWorld();
    }

    @Override
    public GreenfootImage getImage() {
        return sprite.getImage();
    }

    @Override
    public void setImage(String filename) throws IllegalArgumentException {
        sprite.setImage(filename);
    }

    @Override
    public void setImage(GreenfootImage image) {
        sprite.setImage(image);
    }

    @Override
    public void move(int degrees) {
        sprite.move(degrees);
    }

    @Override
    public void turn(int degrees) {
        sprite.turn(degrees);
    }

    @Override
    public Sprite getOneObjectAtOffset(int x, int y, Class cls) {
        return sprite.getOneObjectAtOffset(x,y,cls);
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }
}
