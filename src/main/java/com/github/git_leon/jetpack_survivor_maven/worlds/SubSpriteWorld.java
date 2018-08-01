package com.github.git_leon.jetpack_survivor_maven.worlds;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.P1;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Player;

public class SubSpriteWorld extends SpriteWorld {
    public SubSpriteWorld() {
        super(800, 300, 1);
    }

    @Override
    public void init() {
        for (int i = 0; i < 13; i++) {
            Platform platform = new Platform();
            addObject(platform, i * 64, getHeight());
        }
        addObject(new P1(), getWidth() / 2, getHeight() / 2);
    }
}
