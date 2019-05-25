package com.github.git_leon.jetpack_survivor_maven;

import com.github.git_leon.jetpack_survivor_maven.system.JFootApplication;
import greenfoot.World;
import greenfoot.core.WorldHandler;

import java.io.IOException;

public class JFootTest {
    public static World createNewWorld() {
        try {
            new JFootApplication(null).run();
        } catch (IOException e) {
            throw new Error(e);
        }
        return WorldHandler.getInstance().getWorld();
    }
}
