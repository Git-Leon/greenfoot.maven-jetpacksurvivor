package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.enemies;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;

public class Mummy extends Enemy {
    public Mummy(){
        super(    "npc/mummy/", ".png", 17);
        flipImagesHorizontally();
    }

}
