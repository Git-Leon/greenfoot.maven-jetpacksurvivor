package com.github.git_leon.jetpack_survivor_maven.worlds;

import com.github.git_leon.RandomUtils;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.P1;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Player;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Mob;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.MobGenerator;

public class SubSpriteWorld extends SpriteWorld {
    public SubSpriteWorld() {
        super(800, 300, 1);
    }

    @Override
    public void init() {
        createGround();
    }

    public void act() {
        generateMob();
    }

    private void generateMob() {
        Platform p = new Platform();
        int groundHeight = p.getImage().getHeight();
        if (RandomUtils.createBoolean(10)) {
            Mob randomMob = MobGenerator.getRandom();

            addObject(randomMob, getWidth() - 40, getHeight() - 60);
        }
    }

    private void createGround() {
        for (int i = 0; i < 13; i++) {
            Platform platform = new Platform();
            addObject(platform, i * 64, getHeight());
        }
        addObject(new P1(), getWidth() / 2, getHeight() / 2);
    }
}
