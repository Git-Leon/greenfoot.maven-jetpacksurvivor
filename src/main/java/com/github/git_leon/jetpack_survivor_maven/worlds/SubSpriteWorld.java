package com.github.git_leon.jetpack_survivor_maven.worlds;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.P1;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.P1Partner;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.EnemyMaterializer;
import com.github.git_leon.jetpack_survivor_maven.actors.userinterface.Menu;

public class SubSpriteWorld extends SpriteWorld {
    public SubSpriteWorld() {
        super(800, 300, 1);
    }

    @Override
    public void init() {
        createGround();
        addObject(new EnemyMaterializer(50F), getWidth() - 40, 60);
        addObject(new P1Partner(), 0, 0);
    }

    private void createGround() {
        for (int i = 0; i < 13; i++) {
            Platform platform = new Platform();
            int xOffset = platform.getImage().getWidth() / 2;
            addObject(platform, i * xOffset, getHeight());
        }
        addObject(new P1(), getWidth() / 2, getHeight() / 2);
    }
}
