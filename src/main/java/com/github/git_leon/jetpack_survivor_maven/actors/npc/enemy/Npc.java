package com.github.git_leon.jetpack_survivor_maven.actors.npc.enemy;

import com.github.git_leon.jetpack_survivor_maven.actors.SubActor;
import com.github.git_leon.jetpack_survivor_maven.actors.npc.NPCInterface;
import com.github.git_leon.jetpack_survivor_maven.actors.npc.ally.Player;
import com.github.git_leon.jetpack_survivor_maven.utils.Util;

public class Npc extends SubActor implements NPCInterface {
    public Npc() {
    }

    public Npc(String prefix, String suffix, int numOfImages) {
        super(prefix, suffix, numOfImages);
    }

    public void facePlayer(int percentChance) {
        if(Util.chance(percentChance)) {
            Player player = getPlayer();
            if(player != null)
                faceObject(player);
        } 
    }

    public void touchGround() {
        while(!onGround() && !atWorldEdge(10, 30))
            checkFall();
    }
}