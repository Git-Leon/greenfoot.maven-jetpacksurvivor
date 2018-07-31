package com.github.git_leon.jetpack_survivor_maven.actors.sprite.environment;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteDestroyer;

public class Explosion extends AnimatedSprite {
    public Explosion() {
        super("explosion/", ".png", 14);
    }

    @Override
    public final void act() {
        super.act();
        new SpriteDestroyer(this, (thiz) -> hasAnimatedOnce()).destroy();
    }
}
