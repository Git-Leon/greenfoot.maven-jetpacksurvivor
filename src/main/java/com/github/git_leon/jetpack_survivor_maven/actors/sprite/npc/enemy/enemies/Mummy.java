package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.enemies;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.WeightedEnemy;

public class Mummy extends WeightedEnemy {
    public Mummy(){
        super(    "npc/mummy/", ".png", 17);
        flipImagesHorizontally();
    }

}
