package com.github.git_leon.jetpack_survivor_maven.physics.gravity;

/**
 * @author leon on 7/31/18.
 */
public enum Gravity {
    NORMAL(1);
    private final int forceConstant;

    Gravity(int forceConstant) {
        this.forceConstant = forceConstant;
    }

    private void addGravity(GravityInfluenceeInterface sprite) {
        float verticalSpeed = sprite.getVerticalSpeed();
        if (verticalSpeed > sprite.getTerminalSpeed())
            verticalSpeed = sprite.getTerminalSpeed();
        sprite.setVerticalSpeed(verticalSpeed);
    }

    private int calcNewPosition(GravityInfluenceeInterface gravityInfluencee) {
        return gravityInfluencee.getY() + gravityInfluencee.getVerticalSpeed().intValue();
    }

    private void move(GravityInfluenceeInterface gravityInfluencee) {
        int x = gravityInfluencee.getX();
        int y = gravityInfluencee.getY() + gravityInfluencee.getVerticalSpeed().intValue();
        gravityInfluencee.setLocation(x,y);
    }

    public void apply(GravityInfluenceeInterface gravityInfluencee) {
        addGravity(gravityInfluencee);
        calcNewPosition(gravityInfluencee);
        move(gravityInfluencee);
    }

    public static void applyNormal(GravityInfluenceeInterface gravityInfluencee) {
        NORMAL.apply(gravityInfluencee);
    }
}
