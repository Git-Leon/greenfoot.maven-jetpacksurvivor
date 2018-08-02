package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.enemies;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;

public class OrcRider extends Enemy {
    public OrcRider() {
        super(  "npc/orc_rider/", ".png", 2);
    }

    @Override
    public void animate() {
        animate(5);
    }

}
