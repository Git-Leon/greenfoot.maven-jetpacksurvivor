package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteSensorDecorator;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Rocket;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.guns.HandGun;
import com.github.git_leon.jetpack_survivor_maven.actors.userinterface.gamewindow.PauseWindow;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.Gravity;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.GravityInfluenceeInterface;
import com.github.git_leon.jetpack_survivor_maven.system.controls.JFootKey;
import greenfoot.Greenfoot;

public class P1 extends AnimatedSprite implements GravityInfluenceeInterface, AllyInterface {
    private final SpriteCreatorRemover spriteCreator;
    private final HandGun gun;
    private Rocket rocket;
    private int runSpeed;
    private float verticalSpeed;

    public P1() {
        super("player/walk/walk", ".png", 6);
        this.runSpeed = 2;
        this.gun = new HandGun(this);
        this.spriteCreator = new SpriteCreatorRemover(this);
        this.rocket = new Rocket(this);
    }

    @Override
    public final void animate() {
        if (JFootKey.isAnyKeyDown(
                JFootKey.LEFT,
                JFootKey.RIGHT,
                JFootKey.UP,
                JFootKey.DOWN)) {
            super.animate(3);
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
        if (!super.flippedHorizontally) {
            flipImagesHorizontally();
        }
    }

    @Override
    public void moveLeft(int xOffset) {
        super.moveLeft(xOffset);
        if (super.flippedHorizontally) {
            flipImagesHorizontally();
        }
    }

    public void controls() {
        JFootKey.SPACE.onKeyPress(this::createRocket);
        JFootKey.DOWN.onKeyPress(gun::shoot);
        JFootKey.LEFT.onKeyPress(this::moveLeft, runSpeed);
        JFootKey.RIGHT.onKeyPress(this::moveRight, runSpeed);
        JFootKey.P.onKeyPress(this::createPauseWindow);

        if (isOnGround() && JFootKey.UP.isKeyDown()) {
            jump();
        }
    }

    private void createPauseWindow() {
        if (new SpriteSensorDecorator(this).getNearest(PauseWindow.class) == null) {
            spriteCreator.add(new PauseWindow());
        }
    }

    private void pause() {
        if (JFootKey.P.isKeyDown()) {

        }
    }

    private void createRocket() {
        if (!rocket.isAddedToWorld()) {
            spriteCreator.add(rocket);
        }
    }


    private void jump() {
        Gravity.ANTI.apply(this, 15);
    }
}
