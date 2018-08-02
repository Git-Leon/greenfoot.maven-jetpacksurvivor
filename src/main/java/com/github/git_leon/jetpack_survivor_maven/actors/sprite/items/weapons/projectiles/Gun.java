package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;

public class Gun {
    private SpriteCreatorRemover bulletCreator;

    public Gun(Sprite gunner) {
        this.bulletCreator = new SpriteCreatorRemover(gunner);
    }

    public void shoot(int bulletSpeed) {
        Bullet bullet = new Bullet();
        bullet.setSpeed(bulletSpeed);
        bulletCreator.add(bullet);
    }
}
