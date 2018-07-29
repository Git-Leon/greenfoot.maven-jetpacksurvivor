package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import com.github.git_leon.jetpack_survivor_maven.worlds.SpriteWorld;

import java.util.function.Predicate;

public class SpriteDestroyer {
    private final SpriteWorld spriteWorld;

    public SpriteDestroyer(SpriteWorld spriteWorld) {
        this.spriteWorld = spriteWorld;
    }

    public void destroy(Sprite sprite) {
        destroy((x) -> true, sprite);
    }

    public void destroy(Predicate<Sprite> predicate, Sprite sprite) {
        if (predicate.test(sprite)) {
            spriteWorld.removeSprite(sprite);
        }
    }


    public void add(Sprite sprite) {
        add((x) -> true, sprite);
    }

    public void add(Predicate<Sprite> predicate, Sprite sprite) {
        if (predicate.test(sprite)) {
            spriteWorld.removeSprite(sprite);
        }
    }
}
