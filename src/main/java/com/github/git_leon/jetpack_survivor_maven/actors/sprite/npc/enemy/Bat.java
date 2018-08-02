package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Ally;

public class Bat extends Mob {

    public Bat(){
        super("npc/bat/", ".png", 10);
    }

    @Override
    public final void animate() {
        animate(5);
    }

    @Override
    public void moveLeft(int x) {
        move(-x);
    }

    @Override
    public void postAnimationBehavior() {
        super.spriteSensor.faceNearest(Ally.class);
        super.postAnimationBehavior();
    }
}
