package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteSensorDecorator;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Ally;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.AllyInterface;

public class Enemy  extends AnimatedSprite implements EnemyInterface {
    private final SpriteCreatorRemover spriteRemover;
    protected final SpriteSensorDecorator<Ally> spriteSensor;

    public Enemy(String basename, String suffix, int noOfImages) {
        super(basename, suffix, noOfImages);
        this.spriteRemover = new SpriteCreatorRemover(this);
        this.spriteSensor = new SpriteSensorDecorator<>(this);
    }

    @Override
    public void postAnimationBehavior() {
        moveLeft(1);
        spriteRemover.destroy(getOneIntersectingObject(AllyInterface.class));
        spriteRemover.destroy(Sprite::isAtEdge, this);
    }
}