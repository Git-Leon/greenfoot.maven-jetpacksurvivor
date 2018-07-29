package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import java.util.function.Predicate;

public class SpriteRemover {
    private final Sprite sprite;

    public SpriteRemover(Sprite sprite) {
        this.sprite = sprite;
    }

    public void destroy(Sprite sprite) {
        destroy((x) -> true, sprite);
    }

    public void destroy(Predicate<Sprite> predicate, Sprite sprite) {
        if (predicate.test(sprite)) {
            if(sprite != null)
                sprite.getWorld().removeSprite(sprite);
        }
    }


    public void add(Sprite sprite) {
        add((x) -> true, sprite);
    }

    public void add(Predicate<Sprite> predicate, Sprite sprite) {
        if (predicate.test(sprite)) {
            sprite.getWorld().removeSprite(sprite);
        }
    }
}
