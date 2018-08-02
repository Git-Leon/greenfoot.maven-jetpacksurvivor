package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;

public class Bullet extends Sprite implements ProjectileInterface {
    private int speed = 5;
    private SpriteCreatorRemover spriteCreatorRemover;

    public Bullet() {
        super("ant.png");
        this.spriteCreatorRemover = new SpriteCreatorRemover(this);
    }

    public void act() {
        moveRight(speed);
        destroyOnImpact(Enemy.class);
        spriteCreatorRemover.destroy((sprite) -> sprite.isAtEdge(), this);
    }

    private void destroyOnImpact(Class<? extends Sprite> cls) {
        Sprite sprite = getOneIntersectingObject(cls);
        if (sprite != null) {
            spriteCreatorRemover.destroy(sprite);
        }
    }


    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
