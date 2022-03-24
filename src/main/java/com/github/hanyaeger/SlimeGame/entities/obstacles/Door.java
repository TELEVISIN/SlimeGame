package com.github.hanyaeger.SlimeGame.entities.obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Door extends SpriteEntity {
    protected Door(String resource, Coordinate2D initialLocation) {
        super("sprites/Room_tilemap.png", initialLocation);

        setCurrentFrameIndex(7);
    }
}
