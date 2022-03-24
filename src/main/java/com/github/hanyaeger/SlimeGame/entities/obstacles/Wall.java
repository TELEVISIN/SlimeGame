package com.github.hanyaeger.SlimeGame.entities.obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Wall extends SpriteEntity implements Collider {

    protected Wall(String resource, Coordinate2D initialLocation, int frameIndex) {
        super("sprites/Room_tilemap.png", initialLocation, 4, 4);

        setCurrentFrameIndex(frameIndex);
    }
}
