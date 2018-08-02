package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;

public abstract class Ally extends AnimatedSprite implements AllyInterface {
    public Ally(String basename, String suffix, int noOfImages) {
        super(basename, suffix, noOfImages);
    }
}
