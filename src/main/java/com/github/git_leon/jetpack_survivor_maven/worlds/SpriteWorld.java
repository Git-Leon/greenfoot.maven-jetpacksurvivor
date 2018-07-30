package com.github.git_leon.jetpack_survivor_maven.worlds;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import greenfoot.World;

import java.util.List;

public abstract class SpriteWorld extends World {
    public SpriteWorld(int worldWidth, int worldHeight, int cellSize) {
        super(worldWidth, worldHeight, cellSize);
        init();
    }

    protected void init() {
    }

    public static <SpriteSubType extends Sprite> List<SpriteSubType> getSprites(World world, Class<SpriteSubType> cls) {
        return world.getObjects(cls);
    }

    public void removeSprite(Sprite sprite) {
        removeObject(sprite);
    }

    public void addSprite(Sprite sprite, int x, int y) {
        addObject(sprite, x, y);
    }
}
