package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.DeprecatedProjectile;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.WeightedEnemy;
import com.github.git_leon.jetpack_survivor_maven.system.resources.Resources;
import com.github.git_leon.jetpack_survivor_maven.utils.Util;

import java.util.List;

/**
 * Write a description of class PlayerPartner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerPartner extends AnimatedSprite implements AllyInterface {
    private Player player = Player.INSTANCE;
    public PlayerPartner() {
        super(Resources.IMAGES.toString() + "npc/partner1/", ".png", 7);
    }

    public void postAnimationBehavior() {
        animate(6);
        try {

            setLocation(player.getX()-50, player.getY()-75);
            if(Util.keyDown("q") )
                shot(player.getBulletspeed() * 3);
        } catch(NullPointerException npe) {} catch(IllegalStateException ise) {}
    }

    private void followPlayer() {
        setLocation(player.getX()-50, player.getY()-75);
    }

    public void shot(int speed) {
        DeprecatedProjectile bullet = player.fire(speed).setSpeed(speed);
        bullet.setLocation(getX(), getY());
        List<WeightedEnemy> list = player.getObjects(WeightedEnemy.class);
        int index = Util.ran(2) == 1 ? list.size()-1 : 0;
        bullet.faceObject(list.get(index));
    }

}