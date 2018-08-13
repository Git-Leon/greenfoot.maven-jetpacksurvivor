package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.enemies;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Ally;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.AllyInterface;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;

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
        super.spriteSensor.faceNearest(Ally.class);
        super.postAnimationBehavior();
    }
}
