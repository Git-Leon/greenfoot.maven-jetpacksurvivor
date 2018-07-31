package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

/**
 * @author leon on 7/31/18.
 */

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.Gravity;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.GravityInfluencee.GravityInfluencee;

/**
 * Write a description of class Ball here.
 */
public class Ball extends GravityInfluencee {
    private float verticalSpeed = 0.0f;
    private float terminalSpeed = 30.0f;

    public Ball(Sprite sprite) {
        super(sprite);
    }

    public void act()
    {
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
        return terminalSpeed;
    }
}

