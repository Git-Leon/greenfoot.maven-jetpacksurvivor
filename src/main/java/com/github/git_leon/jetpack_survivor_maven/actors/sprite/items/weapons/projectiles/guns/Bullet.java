package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.guns;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.guns.Projectile;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;

public class Bullet extends Projectile {
    public Bullet() {
        super(Enemy.class);
    }
}
