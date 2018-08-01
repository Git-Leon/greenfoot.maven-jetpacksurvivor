package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.utils.Util;

public class Mummy extends Mob {
    public Mummy(){
        super(    "npc/mummy/", ".png", 17);
    }

    public void postAnimationBehavior() {
        touchGround();
        act(Util.ran(2), Util.ran(3)+1, 1);
    }
}
