package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.actors.SubActor;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.AnimatedSprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.NPCInterface;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Player;
import com.github.git_leon.jetpack_survivor_maven.utils.Util;
import greenfoot.GreenfootImage;

import java.util.List;

@Deprecated
public class Npc extends AnimatedSprite implements NPCInterface {
    @Deprecated
    protected final SubActor adapterPiece;
    private final SpriteCreatorRemover spriteDestroyer;

    public Npc(List<GreenfootImage> imageList) {
        super(imageList);
        this.spriteDestroyer = new SpriteCreatorRemover(this);
        this.adapterPiece = new SubActor();
    }

    @Override
    public void postAnimationBehavior() {

    }

    public Npc(String prefix, String suffix, int numOfImages) {
        super(prefix, suffix, numOfImages);
        this.spriteDestroyer = new SpriteCreatorRemover(this);
        this.adapterPiece = new SubActor();

    }

    public void facePlayer(int percentChance) {
        if (Util.chance(percentChance)) {
            Player player = Player.INSTANCE;
            if (player != null)
                adapterPiece.faceObject(player);
        }
    }

    @Deprecated
    public void touchGround() {
        while (!adapterPiece.onGround() && !adapterPiece.atWorldEdge(10, 30))
            adapterPiece.checkFall();
    }


    protected void act(int moveSpeed, int frequency, int damage) {
        if (super.lifetime > 1) {
            move(-moveSpeed);
            animate(frequency);
            try {
                if (adapterPiece.atWorldEdge(10, 30)) {
                    spriteDestroyer.destroy(this);
                }
            } catch (IllegalStateException ise) {
            }
        }
    }
}