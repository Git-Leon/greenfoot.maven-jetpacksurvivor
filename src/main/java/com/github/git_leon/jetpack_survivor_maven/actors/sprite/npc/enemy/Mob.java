package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;

public abstract class Mob extends Npc {
    public Mob(String basename, String suffix, int noOfImages) {
        super(basename, suffix, noOfImages);
    }
}
