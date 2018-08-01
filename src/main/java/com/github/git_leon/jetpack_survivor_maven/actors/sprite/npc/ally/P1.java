package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.system.controls.JFootKey;

// TODO
public class P1 extends AnimatedSprite {
    public P1() {
        super("player/walk/walk", ".png", 6);
    }

    public final void animate() {
        if(JFootKey.isAnyKeyDown(
                JFootKey.LEFT,
                JFootKey.RIGHT,
                JFootKey.UP,
                JFootKey.DOWN)) {
            super.animate(1);
        }
    }

    @Override
    public final void postAnimationBehavior() {
        JFootKey.LEFT.onKeyPress(super::moveLeft, 1);
        JFootKey.RIGHT.onKeyPress(super::moveRight, 1);
        JFootKey.UP.onKeyPress(super::moveUp, 1);
        JFootKey.DOWN.onKeyPress(super::moveDown, 1);
    }
}
