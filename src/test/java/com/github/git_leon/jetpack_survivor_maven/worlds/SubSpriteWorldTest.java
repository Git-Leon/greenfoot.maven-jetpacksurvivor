package com.github.git_leon.jetpack_survivor_maven.worlds;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Player;
import org.junit.Assert;
import org.junit.Test;

public class SubSpriteWorldTest {

    @Test
    public void setup() {
        // Given
        SubSpriteWorld subSpriteWorld = new SubSpriteWorld();
        subSpriteWorld.addObject(Player.INSTANCE, 0, 0);
        Assert.assertTrue(subSpriteWorld.getObjects(Player.class).contains(Player.INSTANCE));
    }
}
