package com.github.git_leon.jetpack_survivor_maven.actors.sprite;

import java.util.List;

public class SpriteSensorDecorator<SpriteSubType extends Sprite>
        extends SpriteDecorator {


    public SpriteSensorDecorator(Sprite sprite) {
        super(sprite);
    }


    public void faceSprite(SpriteSubType obj) {
        if (obj != null) {
            int deltaX = obj.getX() - getX();
            int deltaY = obj.getY() - getY();
            setRotation((int) (180 * Math.atan2(deltaY, deltaX) / Math.PI));
        } else {
            return;
        }
    }


    public void faceNearest(Class<SpriteSubType> cls, int radius) {
        SpriteSubType actor = getNearest(cls, radius);
        faceSprite(actor);
    }

    public SpriteSubType getNearest(Class<SpriteSubType> cls, int radius) {
        List<SpriteSubType> actors = this.getWorld().getObjects(cls);
        // TODO - Test below implementation
//        Map<SpriteSubType, Double> distanceMap = new HashMap<>();
//        actors.forEach(actor -> distanceMap.put(actor, getDistance(actor));
//        return new TreeSet<>(distanceMap.keySet()).pollFirst();
        SpriteSubType nearestActor = null;
        Double nearestDistance = null;
        double distance;
        int size = actors.size();
        for (int i = 0; i < size; i++) {
            distance = getDistance(actors.get(i));
            if (i == 0) {
                nearestDistance = distance;
            }
            if (distance < nearestDistance) {
                nearestActor = actors.get(i);
                nearestDistance = distance;
            }
        }
        return nearestActor;
    }

    public List<SpriteSubType> getObjectsInRange(Class<SpriteSubType> cls, int radius) {
        return getObjectsInRange(cls, radius);
    }

    public double getDistance(SpriteSubType actor) {
        return Math.hypot(actor.getX() - getX(), actor.getY() - getY());
    }


    public boolean isInFrontAndColliding(Class<SpriteSubType> cls) {
        return getCollidingObjectInFront(cls) != null;
    }

    public boolean isInFrontAndColliding(Class<SpriteSubType> cls, int xOffset, int yOffset) {
        return getCollidingObjectInFront(cls, xOffset, yOffset) != null;
    }

    public SpriteSubType getCollidingObjectInFront(Class<SpriteSubType> cls) {
        int imageWidth = (this.getImage().getWidth());
        int imageHeight = (this.getImage().getHeight());
        int offset = imageWidth > imageHeight ? imageWidth : imageHeight;

        return getCollidingObjectInFront(cls, offset / 2);
    }

    public SpriteSubType getCollidingObjectInFront(Class<SpriteSubType> cls, int offset) {
        return getCollidingObjectInFront(cls, offset, offset);
    }

    public SpriteSubType getCollidingObjectInFront(Class<SpriteSubType> cls, int xOffset, int yOffset) {
        int deltaX = (int) Math.round((Math.cos(getRotation() * Math.PI / 180)));
        int deltaY = (int) Math.round((Math.sin(getRotation() * Math.PI / 180)));
        int x = xOffset * deltaX;
        int y = yOffset * deltaY;
        SpriteSubType actor = this.getOneObjectAtOffset(x, y, cls);

        return actor;
    }


    public SpriteSubType getOneObjectAtOffset(int x, int y, Class cls) {
        return (SpriteSubType) sprite.getOneObjectAtOffset(x, y, cls);
    }

    public List<SpriteSubType> getObjects(Class<SpriteSubType> cls) {
        return this.getWorld().getObjects(cls);
    }

}
