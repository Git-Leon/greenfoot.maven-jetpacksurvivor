package com.github.git_leon.jetpack_survivor_maven;

import com.github.git_leon.jfoot.system.JFootApplication;
import com.github.git_leon.jetpack_survivor_maven.worlds.MockSpriteWorld;
import greenfoot.Greenfoot;
import greenfoot.core.WorldHandler;
import org.junit.Test;

import java.io.IOException;

public class DemoAppTest {
    @Test
    public void test() {
        try {
            new JFootApplication(null).run();
            Greenfoot.setWorld(new MockSpriteWorld(800,300,1));
            WorldHandler.getInstance().getWorld();
            Thread.sleep(9000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
