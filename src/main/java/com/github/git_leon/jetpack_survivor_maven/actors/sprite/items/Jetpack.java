package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items;

import com.github.git_leon.jetpack_survivor_maven.actors.SubActor;
import greenfoot.*;
import com.github.git_leon.jetpack_survivor_maven.utils.Util;

import static com.github.git_leon.jetpack_survivor_maven.resources.Resources.IMAGES;
import static com.github.git_leon.jetpack_survivor_maven.resources.Resources.SOUNDS;

public class Jetpack extends SubActor {
    private String type;
    private GreenfootSound gs = SOUNDS.getSound("jetpack, rocket, acceleration.mp3");

    public Jetpack() {     
        this.type = "jetpack";
    }

    public void act()  {
        try { jetpack(); }
        catch(IllegalStateException ise) { }
    }

    private void jetpack() {
        if(is("jetpack")) {
            setImage(IMAGES.getImage("rocket.png"));
//            gs.play();
            shadow(getPlayer());
            if(!Util.keyDown("e")) {
//                gs.stop();
//                gs.setVolume(0);
//                gs = null;
                //Greenfoot.playSound("jetpack, whine, pitch, descends.mp3");
                kill(this);
                return;
            }
        }
    }    

    private boolean is(String type) {
        return Util.compare(this.type, type);
    }
}