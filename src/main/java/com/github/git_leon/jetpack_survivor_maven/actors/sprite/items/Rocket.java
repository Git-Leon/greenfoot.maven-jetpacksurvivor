package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.Gravity;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.GravityInfluenceeInterface;
import com.github.git_leon.jetpack_survivor_maven.system.controls.JFootKey;

public class Rocket extends Sprite {
    private final GravityInfluenceeInterface sprite;

    public Rocket(GravityInfluenceeInterface sprite) {
        super("rocket.png");
        this.sprite = sprite;
    }

    public void act() {
        if(!JFootKey.SPACE.isKeyDown()) {
            new SpriteCreatorRemover(this).destroy();
        } else {
            setLocation(sprite);
            Gravity.ANTI.apply(sprite);
        }
    }
}
