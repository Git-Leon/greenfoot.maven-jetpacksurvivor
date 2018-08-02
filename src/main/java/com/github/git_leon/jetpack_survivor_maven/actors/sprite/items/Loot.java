package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items;
import com.github.git_leon.jetpack_survivor_maven.actors.SubActor;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.Player;
import greenfoot.*;
import com.github.git_leon.jetpack_survivor_maven.utils.Util;

public class Loot extends SubActor {
    private String[] types = {       
            "rapidfire++", "rapidfire++", "extended_mag++",
            "jetpack_thrust++", "bullet speed++", "run speed++" };

    private String type;
    private void init(int type_n) {
        this.type = types[ type_n ];
        init(type);
    }

    private void init(String text) {
        setImage( Util.Text.getText(text, 20, Color.BLACK, Color.BLACK, Color.BLACK) );
    }

    private void init(int type_n, String text) {
        this.type = types[ type_n ];
        setImage(text);
    }

    public Loot() {
        init(Util.ran(types.length));
    }

    public Loot(int type_n) {
        init(type_n);
    }

    private void fall() {
        if(!onGround())
            fall(1);
    }

    private void flash() {
        if(getLifeTime()%2 == 1)
            getImage().setTransparency(125);
        else 
            getImage().setTransparency(255);
    }

    public void act()  {
        fall();        
        activate();         
        flash();
        die();
    }

    public void update(String methodname, int val) {
        getPlayer().getCoolDown(methodname).setMaxLife(val);
    }

    private void activate() {
        Player p = (Player)getOneIntersectingObject(Player.class);
        if(p != null) {
            Greenfoot.playSound("power up.mp3");
            int shotdelay = p.getShotDelay();
            if(is("rapidfire")) {
                shotdelay = 9*(shotdelay/10);
                update("shoot", p.setShotDelay(shotdelay += shotdelay*(9/10) ) );

            } else if(is("extended_mag"))
                p.increaseMagSize();
            else if(is("jetpack_thrust")) 
                p.increaseThrust();
            else if(is("bullet_speed"))
                p.increaseBulletSpeed();
            else if(is("run_speed")) {
                p.increaseRunSpeed();
                if(p.getRunSpeed() >= p.getBulletspeed())
                    p.increaseBulletSpeed();

            }
            //if(is("life_power"))
            //    player.setFireRate((int)firerate);
        }
    }

    private void die() {
        if(rot(3))
            return;
        else if(getOneIntersectingObject(Player.class) != null)        
            kill(this);
        else
            disappearAtEdge(10,10);
    }

    private boolean is(String type) {
        return Util.compare(this.type, type);
    }

}