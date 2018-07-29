package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

public class ZombieCrawler extends Mob {
    public ZombieCrawler() {
        super("npc/zombie_crawler/", ".png", 12);
        flipImagesHorizontally();
    }

    public void act() {
        touchGround();
        act(1,3,1);
    }
}
