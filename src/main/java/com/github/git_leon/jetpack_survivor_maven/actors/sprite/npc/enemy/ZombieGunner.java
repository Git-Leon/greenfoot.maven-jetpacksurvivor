package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.utils.Util;

public class ZombieGunner extends Mob {
    public ZombieGunner() {
        super("npc/zombie_gunner/", ".png", 13);
        flipImagesHorizontally();
    }


    public void act() {
        adapterPiece.checkFall();
        if(adapterPiece.onGround() && Util.chance(1))
            adapterPiece.jump(15);
        act(1, 3, 1);
    }
}
