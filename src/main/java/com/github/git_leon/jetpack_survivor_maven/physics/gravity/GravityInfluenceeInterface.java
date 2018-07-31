package com.github.git_leon.jetpack_survivor_maven.physics.gravity;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteInterface;

/**
 * @author leon on 7/31/18.
 */
public interface GravityInfluenceeInterface extends SpriteInterface {
    Float getVerticalSpeed();

    void setVerticalSpeed(Float i);

    float getTerminalSpeed();
}
