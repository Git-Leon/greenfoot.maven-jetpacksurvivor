package com.github.git_leon.jfoot.sprite.npc.enemy;

import com.github.git_leon.RandomUtils;
import com.github.git_leon.jfoot.sprite.InvisibleSprite;
import com.github.git_leon.jfoot.sprite.SpriteCreatorRemover;

public class EnemyMaterializer extends InvisibleSprite {
    private final SpriteCreatorRemover spriteCreator;
    private final Float spawnChance;

    public EnemyMaterializer(Float spawnChance) {
        this.spriteCreator = new SpriteCreatorRemover(this);
        this.spawnChance = spawnChance;
    }

    public void act() {
        if(RandomUtils.createBoolean(spawnChance)) {
            spriteCreator.add(EnemyGenerator.getRandom());
        }
    }
}
