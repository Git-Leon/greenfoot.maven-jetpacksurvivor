package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.enemies;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.WeightedEnemy;

public class FiendCrawler extends WeightedEnemy {
    public FiendCrawler() {
        super("npc/fiend_crawler/", ".png", 5);
    }
    @Override
    public void animate() {
        animate(2);
    }
}
