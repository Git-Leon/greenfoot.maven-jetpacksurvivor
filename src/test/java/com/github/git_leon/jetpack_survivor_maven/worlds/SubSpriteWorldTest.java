package com.github.git_leon.jetpack_survivor_maven.worlds;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.P1;
import org.junit.Assert;
import org.junit.Test;

public class SubSpriteWorldTest {

    @Test
    public void setup() {
        // Given
        P1 p1 = new P1();
        SubSpriteWorld subSpriteWorld = new SubSpriteWorld();
        subSpriteWorld.addObject(p1, 0, 0);
        Assert.assertTrue(subSpriteWorld.getObjects(P1.class).contains(p1));
    }
}
