package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.Bullet;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.Gravity;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.GravityInfluenceeInterface;
import com.github.git_leon.jetpack_survivor_maven.system.controls.JFootKey;

// TODO
public class P1 extends Ally implements GravityInfluenceeInterface {
    private int runSpeed;
    private final SpriteCreatorRemover bulletCreator;
    private float verticalSpeed;

    public P1() {
        super("player/walk/walk", ".png", 6);
        this.bulletCreator = new SpriteCreatorRemover(this);
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


    public void controls() {
        JFootKey.S.onKeyPress(this::shoot);
        JFootKey.LEFT.onKeyPress(super::moveLeft, runSpeed);
        JFootKey.RIGHT.onKeyPress(super::moveRight, runSpeed);
        JFootKey.DOWN.onKeyPress(super::moveDown, runSpeed);
        if (isOnGround() && JFootKey.UP.isKeyDown()) {
            moveUp(1);
            setVerticalSpeed(-10F);
        }
    }

    private void shoot() {
        bulletCreator.add(new Bullet());
    }


}
