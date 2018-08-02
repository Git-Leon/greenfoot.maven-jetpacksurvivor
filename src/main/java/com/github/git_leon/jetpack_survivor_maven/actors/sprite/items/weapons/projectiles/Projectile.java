package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;

public abstract class Projectile<VictimClass extends Sprite> extends Sprite implements ProjectileInterface {
    private final Class<VictimClass> victimClass;
    private int speed = 5;
    private SpriteCreatorRemover spriteCreatorRemover;

    public Projectile(Class<VictimClass> cls) {
        super("ant.png");
        this.spriteCreatorRemover = new SpriteCreatorRemover(this);
        this.victimClass = cls;
    }

    public void act() {
        move(speed);
        destroyOnImpact(Enemy.class);
        if(isAtEdge()) {

        }
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
