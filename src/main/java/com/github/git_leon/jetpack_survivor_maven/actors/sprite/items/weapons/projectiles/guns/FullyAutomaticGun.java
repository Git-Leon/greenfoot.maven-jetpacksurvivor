package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.guns;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;

public class FullyAutomaticGun {
    private SpriteCreatorRemover bulletCreator;

    public FullyAutomaticGun(Sprite gunner) {
        this.bulletCreator = new SpriteCreatorRemover(gunner);
    }

    public Projectile shoot(int bulletSpeed) {
        Projectile projectile = new Bullet();
        projectile.setSpeed(bulletSpeed);
        bulletCreator.add(projectile);
        return projectile;
    }
}
