package com.github.git_leon.jetpack_survivor_maven.system.controls;

import com.github.git_leon.Keys;
import greenfoot.Greenfoot;

import java.util.List;

public class Keyboard {
    public static boolean isKeyDown(Keys keys) {
        return isKeyDown(keys.name());
    }

    public static boolean isKeyDown(String key) {
        return Greenfoot.isKeyDown(key);
    }

    public static List<String> getCurrentlyPressedKeys() {
        throw new UnsupportedOperationException("This method has yet to be implemented");
    }
}
