package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteSensorDecorator;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Ally;
import com.github.git_leon.jetpack_survivor_maven.physics.gravity.GravityInfluenceeInterface;

public abstract class Mob extends AnimatedSprite implements GravityInfluenceeInterface {
    private final SpriteCreatorRemover spriteRemover;
    protected final SpriteSensorDecorator<Ally> spriteSensor;
    private float verticalSpeed;

    public Mob(String basename, String suffix, int noOfImages) {
        super(basename, suffix, noOfImages);
        this.spriteRemover = new SpriteCreatorRemover(this);
        this.spriteSensor = new SpriteSensorDecorator<>(this);
    }

    @Override
    public void postAnimationBehavior() {
        moveLeft(1);
        spriteRemover.destroy(getOneIntersectingObject(Ally.class));
        spriteRemover.destroy(Sprite::isAtEdge, this);
    }

    @Override
    public Float getVerticalSpeed() {
        return verticalSpeed;
    }

    @Override
    public void setVerticalSpeed(Float i) {
        this.verticalSpeed = i;
    }

    @Override
    public float getTerminalSpeed() {
        return 3;
    }

    @Override
    public boolean isOnGround() {
        return getOneIntersectingObject(Platform.class) != null;
    }
}
