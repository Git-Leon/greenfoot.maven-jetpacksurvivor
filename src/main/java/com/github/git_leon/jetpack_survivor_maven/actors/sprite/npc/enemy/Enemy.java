package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.utils.Util;

public class Enemy extends Npc {
    private String[] types = {
            "mummy", "orc_rider", "bat",
            "zombie_gunner", "zombie_crawler",
            "fiend_crawler"};
    private String type;
    private boolean h_flip = true, v_flip = true;

    private void init(String prefix, String suffix, int numberOfImages) {
        adapterPiece.setAnimation(prefix, suffix, numberOfImages);
    }

    private void constructor() {
        if(is("zombie_gunner")) { //Zombie Gunner Constructor
            init("npc/zombie_gunner/", ".png", 13);
            adapterPiece.flipImages(h_flip, !v_flip);
        }
        else if( is("orc_rider") ) { //Orc Rider Constructor
            init("npc/orc_rider/", ".png", 2);
            adapterPiece.flipImages(!h_flip, !v_flip);
        }
        else if( is("bat") ) { //Bat Constructor
            init("npc/bat/", ".png", 10);
            adapterPiece.flipImages(h_flip, v_flip);
        }
        else if( is("mummy") ) {
            init("npc/mummy/", ".png", 17);
            adapterPiece.flipImages(h_flip, !v_flip);
        }
        else if( is("zombie_crawler")) {
            init("npc/zombie_crawler/", ".png", 12);
            adapterPiece.flipImages(h_flip, !v_flip);
        }
        else if( is("fiend_crawler")) {
            init("npc/fiend_crawler/", ".png", 5);            
        }
    }

    public Enemy() {
        super(EnemyGenerator.getRandom().getImages());
        this.type = types[ Util.ran(types.length) ];
        constructor();
    }

    public void act() {
        try {
            //facePlayer(100);
            if(is("orc_rider")) {
                touchGround();
                act(5, 10, 1);
            } else if(is("mummy")) {
                touchGround();
                act(Util.ran(2), Util.ran(3)+1, 1);
            } else if(is("zombie_gunner")) {
                adapterPiece.checkFall();
                if(adapterPiece.onGround() && Util.chance(1))
                    adapterPiece.jump(15);
                act(1, 3, 1);
            } else if(is("bat")) {
                facePlayer(20);
                act(-5, 3, 1);
            } else if(is("zombie_crawler")) {
                touchGround();
                act(1,3,1);
            } else if(is("fiend_crawler")) {
                touchGround();
                act(4, 2, 1);
            }
        } catch(IllegalStateException ise) {}
        catch(NullPointerException npe) {}
    }

    private boolean is(String type) {
        return Util.compare(this.type, type);
    }
}