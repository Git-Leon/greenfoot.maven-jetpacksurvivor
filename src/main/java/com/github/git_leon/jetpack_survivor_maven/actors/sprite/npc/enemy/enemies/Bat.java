package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.enemies;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.P1;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.Gravity;

public class Bat extends Enemy {

    public Bat(){
        super("npc/bat/", ".png", 10);
        flipImagesHorizontally();
        flipImagesVertically();
    }

    @Override
    public final void animate() {
        animate(5);
    }

    @Override
    public void moveLeft(int xOffset) {
        move(xOffset);
    }

    @Override
    public void postAnimationBehavior() {
        super.spriteSensor.faceNearest(P1.class);
        super.postAnimationBehavior();
    }
}
