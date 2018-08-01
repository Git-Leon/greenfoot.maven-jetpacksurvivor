package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.Bullet;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.Gravity;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.GravityInfluenceeInterface;
import com.github.git_leon.jetpack_survivor_maven.system.controls.JFootKey;

// TODO
public class P1 extends AnimatedSprite implements GravityInfluenceeInterface {
    private int runSpeed;
    private final SpriteCreatorRemover bulletCreator;
    private Float verticalSpeed = 1F;

    public P1() {
        super("player/walk/walk", ".png", 6);
        this.bulletCreator = new SpriteCreatorRemover(this);
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
        if (!isOnGround()) {
            Gravity.applyNormal(this);
        }
    }

    public boolean isOnGround() {
        return getOneIntersectingObject(Platform.class) != null;
    }

    public void controls() {
        JFootKey.S.onKeyPress(this::shoot);
        JFootKey.LEFT.onKeyPress(super::moveLeft, 1);
        JFootKey.RIGHT.onKeyPress(super::moveRight, 1);
        JFootKey.DOWN.onKeyPress(super::moveDown, 1);
        if (isOnGround() && JFootKey.UP.isKeyDown() ) {
            moveUp(1);
            setVerticalSpeed(-10F);
        }
    }

    private void shoot() {
        bulletCreator.add(new Bullet());
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
}
