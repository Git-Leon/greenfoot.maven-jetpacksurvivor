package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

public class Bat extends Mob {

    public Bat(){
        super("npc/bat/", ".png", 10);
    }

    @Override
    public final void animate() {
        animate(5);
    }
}
