package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.CoolDown;
import com.github.git_leon.jetpack_survivor_maven.actors.SubActor;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.Enemy;
import com.github.git_leon.jetpack_survivor_maven.system.controls.JFootKey;
import com.github.git_leon.jetpack_survivor_maven.system.resources.Resources;
import greenfoot.*;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Jetpack;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.userinterface.Menu;
import com.github.git_leon.jetpack_survivor_maven.worlds.SubWorld;
import com.github.git_leon.jetpack_survivor_maven.utils.Util;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.DeprecatedProjectile;

import java.util.ArrayList;

public class Player extends SubActor {
    public static final Player INSTANCE = new Player();

    private int shotdelay;
    private int firerate;
    private int magsize;
    private int thrust;
    private int fuel;
    private int jumpstrength;
    private int bulletspeed;
    private int runspeed;
    private int kills = 0;
    private ArrayList<CoolDown> coolDowns = new ArrayList<CoolDown>();

    private void init(
            int shotdelay, int firerate, int magsize, int thrust,
            int fuel, int jumpstrength, int bulletspeed, int runspeed) {
        this.shotdelay = shotdelay;
        this.firerate = firerate;
        this.magsize = magsize;
        this.thrust = thrust;
        this.fuel = fuel;
        this.jumpstrength = jumpstrength;
        this.bulletspeed = bulletspeed;
        this.runspeed = runspeed;
    }


    private Player() {
        super("player/walk/walk", ".png", 6);
        for (GreenfootImage image : getImages())
            image.mirrorHorizontally();
        init(1000, 1, 1, 2, 15, 10, 5, 3);
        addCoolDown("shoot", shotdelay);
        addCoolDown("jetpack", fuel);
        addCoolDown("invincibility", 1000);
    }

    public int getShotDelay() {
        return this.shotdelay;
    }

    public int setShotDelay(int val) {
        this.shotdelay = val;
        this.firerate = 1001 - shotdelay;
        return val;
    }


    public CoolDown addCoolDown(String methodName, double maxlife) {
        CoolDown c = new CoolDown(methodName, maxlife);
        this.coolDowns.add(c);
        return c;
    }

    public void act() {
        checkFall();
        checkKeys();
        endGame();
    }

    private void endGame() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            boolean a = getOneObjectAtOffset(0, 0, Enemy.class) != null;
            boolean b = enemy.getOneObjectAtOffset(0, 0, Player.class) != null;
            if (a || b)
                die();
        }

    }

    private void die() {
        Menu finalScore = new Menu("FINAL SCORE:   " + Menu.score()) {
            public void act() {
                Greenfoot.delay(10);
            }
        };
        addObject(finalScore, getX(), getY());

        Menu reset = new Menu("Press Space to Continue") {
            public void act() {
                if (Util.keyDown("space")) {
                    Greenfoot.setWorld(new SubWorld());
                }
            }
        };
        addObject(reset, getX(), getY() - finalScore.getImage().getHeight());
        kill(this);
    }

    public boolean hitPlatform() {
        try {
            for (Object platform : getIntersectingObjects(Platform.class))
                if (((Platform) platform).getY() < getY()) // not on top platform
                    return true;
            return false;
        } catch (NullPointerException npe) {
            return false;
        }
    }

    private boolean v_flipped = false, h_flipped = false;

    private void checkKeys() {
        if (!hitPlatform()) {
            if (JFootKey.LEFT.isKeyDown()) {
                if (v_flipped == false) {
                    setRotation(180);
                    v_flipImages();
                    v_flipped = true;
                }
                if (h_flipped) {
                }
                setLocation(getX() - runspeed, getY());
                animate(15 - runspeed >= 1 ? 1 - runspeed : 2);
            }

            if (Util.keysDown("right", "d")) {
                if (v_flipped == true) {
                    setRotation(0);
                    v_flipImages();
                    v_flipped = false;
                }
                setLocation(getX() + runspeed, getY());
                animate(15 - runspeed >= 1 ? 1 - runspeed : 2);
            }
        }

        if (Util.keysDown("up", "w") && onGround())
            jump(10);

        if (Util.keysDown("down", "x", "s")) {
            fire(this.bulletspeed);
        }

        boolean jetpack_exists = count(Jetpack.class) > 0;
        if (Util.keyDown("e"))
            if (jetpack_exists)
                jump(Util.ran(thrust));
            else
                addObject(new Jetpack(), getX(), getY());

        if (Util.keyDown("p")) {
            addObject(new Menu(), worldWidth() / 2, worldHeight() / 2);
            while (Util.keyDown("p"))
                Greenfoot.delay(1);
        }
    }

    public boolean isAvailable(String methodname) {
        return getCoolDown(methodname).isAvailable();
    }

    public CoolDown getCoolDown(String methodName) {
        for (CoolDown c : coolDowns)
            if (c.getMethodName().equals(methodName))
                return c;
        return null;
    }

    public DeprecatedProjectile fire(int speed) {
        if (count(DeprecatedProjectile.class) < magsize)
            if (isAvailable("shoot")) {
                setImage(Resources.IMAGES.getImage("player/shoot/shoot3.png"));
                if (getRotation() == 180) {
                    getImage().mirrorVertically();
                } else {
                    getImage().mirrorHorizontally();
                }
//                Greenfoot.playSound("shot1.mp3");
                return shoot(bulletspeed);
            }
        return null;
    }

    private void fall() {
        fall(1, 7);
    }


    @Override
    public String toString() {
        return "Player 1";
    }

    public int getBulletspeed() {
        return bulletspeed;
    }

    public void increaseKills() {
        kills++;
    }

    public void increaseMagSize() {
        magsize++;
    }

    public void increaseThrust() {
        thrust++;
    }

    public void increaseBulletSpeed() {
        bulletspeed++;
    }

    public void increaseRunSpeed() {
        runspeed++;
    }

    public int getRunSpeed() {
        return runspeed;
    }
}