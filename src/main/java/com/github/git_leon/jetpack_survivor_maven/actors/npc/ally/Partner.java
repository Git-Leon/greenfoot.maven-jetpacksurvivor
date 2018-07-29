package com.github.git_leon.jetpack_survivor_maven.actors.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.npc.enemy.Enemy;
import com.github.git_leon.jetpack_survivor_maven.actors.npc.enemy.Npc;
import com.github.git_leon.jetpack_survivor_maven.actors.items.weapons.projectiles.Projectile;
import com.github.git_leon.jetpack_survivor_maven.resources.ResourceORM;
import com.github.git_leon.jetpack_survivor_maven.utils.Util;

/**
 * Write a description of class Partner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partner extends Npc {
    public Partner() {
        setAnimation(ResourceORM.IMAGES.toString() + "npc/partner1/", ".png", 7);
    }

    public void act() {
        animate(6);
        try {
            Player p = getPlayer();
            setLocation(getX(p)-50, getY(p)-75);
            if(Util.keyDown("q") )
                shot(p.bulletspeed * 3);
        } catch(NullPointerException npe) {} catch(IllegalStateException ise) {}
    }

    private void followPlayer() {
        Player p = getPlayer();
        setLocation(getX(p)-50, getY(p)-75);
    }

    public void shot(int speed) {
        Player p = getPlayer();
        Projectile bullet = p.fire(speed).setSpeed(speed);
        bullet.setLocation(getX(), getY());
        java.util.List list = getObjects(Enemy.class);
        int index = Util.ran(2) == 1 ? list.size()-1 : 0;
        bullet.faceObject(list.get(index));
    }

}