package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items;

import com.github.git_leon.jetpack_survivor_maven.actors.SubActor;

public class Platform extends SubActor {
    public Platform() {
    }

    public Platform(String image) {
        setImage(image);
    }

    public void act() {
        //setLocation(getX()-1, getY());
        repeat();
    }

    private void repeat() {
        if(getX() < 30)
            setLocation(13*64, 784);
    }

    public void touchingplatform() {
    }
}