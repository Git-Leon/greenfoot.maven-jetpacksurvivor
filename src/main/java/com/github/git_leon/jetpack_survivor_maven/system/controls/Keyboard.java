package com.github.git_leon.jetpack_survivor_maven.system.controls;

import com.github.git_leon.Keys;
import greenfoot.Greenfoot;

public enum Keyboard {
    INSTANCE;

    public boolean isKeyDown(Keys keys) {
        return Greenfoot.isKeyDown(keys.name());
    }
}
