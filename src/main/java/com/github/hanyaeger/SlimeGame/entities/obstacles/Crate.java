package com.github.hanyaeger.SlimeGame.entities.obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Crate extends SpriteEntity implements Collider {
    final int frameIndex = 7;

    public Crate(String resource, Coordinate2D initialLocation) {
        super("sprites/Room_tilemap.png", initialLocation, 4, 4);

        setCurrentFrameIndex(frameIndex);
    }
}
