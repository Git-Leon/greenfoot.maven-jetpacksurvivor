package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import java.util.function.Predicate;

public class SpriteDestroyer {
    private final Sprite spriteDecoratee;
    private final Predicate<Sprite> predicate;

    public SpriteDestroyer(Sprite spriteWorld) {
        this(spriteWorld, (x) -> true);
    }

    public SpriteDestroyer(Sprite spriteDecoratee, Predicate<Sprite> predicate) {
        this.spriteDecoratee = spriteDecoratee;
        this.predicate = predicate;
    }

    public void destroy(Sprite sprite) {
        if (predicate.test(sprite)) {
            spriteDecoratee.getWorld().removeSprite(sprite);
        }
    }

    public void add(Sprite sprite, int x, int y) {
        if (predicate.test(sprite)) {
            spriteDecoratee.getWorld().addSprite(sprite, x, y);
        }
    }
}
