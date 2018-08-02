package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.Gun;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.Gravity;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.GravityInfluenceeInterface;
import com.github.git_leon.jetpack_survivor_maven.system.controls.JFootKey;

// TODO
public class P1 extends AnimatedSprite implements GravityInfluenceeInterface, Ally {
    private int runSpeed;
    private final Gun gun;
    private float verticalSpeed;

    public P1() {
        super("player/walk/walk", ".png", 6);
        this.gun = new Gun(this);
        this.runSpeed = 2;
    }

    @Override
    public final void animate() {
        if (JFootKey.isAnyKeyDown(
                JFootKey.LEFT,
                JFootKey.RIGHT,
                JFootKey.UP,
                JFootKey.DOWN)) {
            super.animate(1);
        }
    }

    @Override
    public final void postAnimationBehavior() {
        controls();
        Gravity.applyNormal(this);
    }

    @Override
    public Float getVerticalSpeed() {
        return verticalSpeed;
    }

    @Override
    public void setVerticalSpeed(Float i) {
        verticalSpeed = i;
    }

    @Override
    public float getTerminalSpeed() {
        return 3;
    }

    @Override
    public boolean isOnGround() {
        return getOneIntersectingObject(Platform.class) != null;
    }

    @Override
    public void moveRight(int xOffset) {
        super.moveRight(xOffset);
        if(!super.flippedHorizontally) {
            flipImagesHorizontally();
        }
    }

    @Override
    public void moveLeft(int xOffset) {
        super.moveLeft(xOffset);
        if(super.flippedHorizontally) {
            flipImagesHorizontally();
        }
    }


    public void controls() {
        JFootKey.S.onKeyPress(gun::shoot, 5);
        JFootKey.LEFT.onKeyPress(this::moveLeft, runSpeed);
        JFootKey.RIGHT.onKeyPress(this::moveRight, runSpeed);
        JFootKey.DOWN.onKeyPress(this::moveDown, runSpeed);
        if (isOnGround() && JFootKey.UP.isKeyDown()) {
            moveUp(1);
            setVerticalSpeed(-10F);
        }
    }


}
