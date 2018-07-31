package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Player;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.SubActor;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.NPCInterface;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteDestroyer;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteSensorDecorator;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import com.github.git_leon.jetpack_survivor_maven.utils.Util;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Loot;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;

public class Projectile extends Sprite {
    private final SpriteDestroyer spriteDestoyer;
    private int speed;
    private Class enemy;
    public static int lootchance;


    public Projectile(int speed) {
        this(speed, Enemy.class);
    }

    public Projectile(int speed, Class<? extends NPCInterface> cls) {
        super("ant.png");
        this.speed = speed;
        this.enemy = cls;
        this.spriteDestoyer = new SpriteDestroyer(this);
    }


    public void act() {
        move(speed);
        hit(0, Enemy.class);
    }

    public Projectile setSpeed(int val) {
        this.speed = val;
        return this;
    }

    private void hit(int dmg, Class cls) {
        Sprite actor = getOneIntersectingObject(cls);
        if (worldSensor.atWorldEdge(3)) {
            die();
        } else if (actor != null) {
            spriteDestoyer.destroy(actor);
            addLoot(100);
            Player.INSTANCE.kills++;
            die();
        }
    }

    private void addLoot(int percentchance) {
        if (Util.chance(percentchance)) //&& Menu.score() < 100)for(int i=0; i<100; i++)
            addObject(new Loot(), getX(), getY());
    }

    @Deprecated
    private void addObject(Actor sprite, int x, int y) {
        getWorld().addObject(sprite, x, y);
    }

    private void die() {
        addObject(new SubActor("explosion/", ".png", 14) {
            public void act() {
                animate(2);
                if (getCurImage() >= getImages().length - 1) {
                    kill(this);
                }
            }
        }, getX(), getY());
//        Greenfoot.playSound("vaporize.mp3");
        spriteDestoyer.destroy(this);
    }

    @Deprecated
    public void faceObject(Actor sprite) {
        faceObject(sprite);
    }

    public void faceObject(Sprite sprite) {
        new SpriteSensorDecorator<>(this).faceSprite(sprite);
    }
}