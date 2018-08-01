package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.WeaponInterface;

public interface ProjectileInterface extends WeaponInterface {
    void setSpeed(int speed);
    int getSpeed();
}
