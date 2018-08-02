package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.enemies;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;

public class ZombieGunner extends Enemy {
    public ZombieGunner() {
        super("npc/zombie_gunner/", ".png", 13);
        flipImagesHorizontally();
    }
}
