package com.github.git_leon.jfoot.sprite.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.actors.Platform;
import com.github.git_leon.jfoot.sprite.physics.gravity.Gravity;
import com.github.git_leon.jfoot.sprite.physics.gravity.GravityInfluenceeInterface;

public abstract class WeightedEnemy extends Enemy implements GravityInfluenceeInterface {
    private float verticalSpeed;

    public WeightedEnemy(String basename, String suffix, int noOfImages) {
        super(basename, suffix, noOfImages);
    }

    @Override
    public void postAnimationBehavior() {
        applyGravity();
        super.postAnimationBehavior();
    }

    protected void applyGravity() {
        Gravity.applyNormal(this);
    }

    @Override
    public Float getVerticalSpeed() {
        return verticalSpeed;
    }

    @Override
    public void setVerticalSpeed(Float i) {
        this.verticalSpeed = i;
    }

    @Override
    public float getTerminalSpeed() {
        return 3;
    }

    @Override
    public boolean isOnGround() {
        return getOneIntersectingObject(Platform.class) != null;
    }
}
