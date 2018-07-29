package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

public interface SpriteWrapper extends SpriteInterface {
    <SpriteSubType extends Sprite> SpriteSubType getSprite();
}
