package com.github.git_leon.jetpack_survivor_maven.worlds;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Jetpack;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Player;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.WeightedEnemy;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.EnemyGenerator;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Loot;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.PlayerPartner;
import com.github.git_leon.jetpack_survivor_maven.actors.userinterface.Menu;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.DeprecatedProjectile;
import com.github.git_leon.jetpack_survivor_maven.utils.Util;

import static com.github.git_leon.jetpack_survivor_maven.system.resources.Resources.SOUNDS;

public class SubWorld extends SpriteWorld {
    PlayerPartner partner = null;
    Player player = null;
    private long birth = System.currentTimeMillis();
    private GreenfootSound gameExecutionMusic = SOUNDS.getSound("music0.mp3");
    private GreenfootSound gameOverMusic = SOUNDS.getSound("music1.mp3");


    public SubWorld() {
        super(800, 300, 1);
        mode(1);
    }

    public void act() {
//        addEnemy(0);
    }

    public Player getPlayer() {
        return this.player;
    }

    public PlayerPartner getPartner() {
        return this.partner;
    }

    private void mode(int num) {
        setPaintOrder(Player.class, Loot.class);
//        gameOverMusic.stop();
        //gameExecutionMusic.playLoop();
        switch (num) {
            case 1:
                classic();
                break;

            case 2:
                break;
            case 3:
                break;
        }
    }

    private int getX(Actor actor) {
        return actor.getX();
    }

    private int getY(Actor actor) {
        return actor.getY();
    }

    private void makeGround() {
        for (int i = 0; i < 13; i++) {
            Platform platform = new Platform();
            addObject(platform, i * 64, getHeight());
        }
    }

    private void classic() {
        makeGround();
        DeprecatedProjectile.lootchance = 66;
        this.player = Player.INSTANCE;
        this.partner = new PlayerPartner();
        addObject(player, 174, 50);
        addObject(partner, getX(player) - 50, getY(player) + 100);
        addObject(new Jetpack(), 174, 50);
        addObject(new Menu() {
                      public void act() {
//                          gameExecutionMusic.playLoop();
                          kill(this);
                      }

                  }, getWidth() / 2,
                getHeight() / 2);

        Menu playerInfo = new Menu(true);
        addObject(playerInfo, playerInfo.getImage().

                getWidth() / 2, playerInfo.getImage().

                getHeight() / 2);
    }

    private Platform[] ladder() {
        Platform[] ladder = new Platform[5];
        for (int i = 0; i < 5; i++) {
            Platform rung = new Platform();
            ladder[i] = rung;
            addObject(rung, getWidth(), getHeight() - (i * 80));
        }
        return ladder;
    }

    private void addLadder(int freq) {
        if (Util.chance(freq))
            ladder();
    }

    private void rain(int frequency) {
        if (Util.chance(frequency)) {
            int offset = Util.plusOrMinus() * 70;
            addObject(new Loot(), Util.ran(getWidth()), 40);
        }
    }

    private void addEnemy(int num) {
        boolean b = count(WeightedEnemy.class) < (Menu.score / 10) + 1;
        if (b)
            addObject(EnemyGenerator.getRandom(), getWidth() - 50, 50);
    }

    public SubWorld getCurrentWorld() {
        return this;
    }

    public int count(Class cls) {
        return getObjects(cls).size();
    }


    public void playExecutionMusic() {
        stopMusic();
        gameExecutionMusic.playLoop();
    }

    public void playGameOverMusic() {
        stopMusic();
        gameOverMusic.playLoop();
    }

    public void stopMusic() {
        gameExecutionMusic.stop();
        gameOverMusic.stop();
    }
}