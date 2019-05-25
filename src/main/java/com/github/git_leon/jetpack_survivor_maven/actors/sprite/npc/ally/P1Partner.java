package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteSensorDecorator;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.guns.FullyAutomaticGun;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.guns.Projectile;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.WeightedEnemy;
import com.github.git_leon.jetpack_survivor_maven.system.controls.JFootKey;

public class P1Partner extends AnimatedSprite implements AllyInterface {
    private P1 player;
    private FullyAutomaticGun gun;

    public P1Partner() {
        super("npc/partner1/", ".png", 7);
        this.gun = new FullyAutomaticGun(this);
    }

    @Override
    public void animate() {
        animate(3);
    }

    @Override
    public void postAnimationBehavior() {
        JFootKey.Q.onKeyPress(this::shoot);
        shadowPlayer();
    }

    private void shoot() {
        Projectile b = gun.shoot(5);
        SpriteSensorDecorator<WeightedEnemy> bulletRedirector = new SpriteSensorDecorator<>(b);
        bulletRedirector.faceNearest(WeightedEnemy.class);
    }

    private void shadowPlayer() {
        try {
            P1 player = getPlayer();
            if (player != null) {
                int pX = player.getX() - 50;
                int pY = player.getY() - 75;
                setLocation(pX, pY);
            }
        } catch(IllegalStateException ise) {
            shoot();
        }
    }

    private P1 getPlayer() {
        if (this.player == null) {
            this.player = new SpriteSensorDecorator<P1>(this).getNearest(P1.class);
        }
        return this.player;
    }
}
