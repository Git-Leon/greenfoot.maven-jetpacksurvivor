package com.github.git_leon.jetpack_survivor_maven.physics.gravity;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteDecorator;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.GravityInfluenceeInterface;

/**
 * @author leon on 7/31/18.
 */
public abstract class GravityInfluencee extends SpriteDecorator implements GravityInfluenceeInterface {
    public GravityInfluencee(Sprite sprite) {
        super(sprite);
    }
}
