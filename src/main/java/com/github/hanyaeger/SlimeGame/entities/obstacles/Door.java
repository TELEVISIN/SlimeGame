package com.github.hanyaeger.SlimeGame.entities.obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Door extends SpriteEntity {
    public Door(Coordinate2D initialLocation, Size size, String resource) {
        super("sprites/Room_tilemap.png", initialLocation, size, 4, 4);

        if (resource == "0") {
            setCurrentFrameIndex(0);
        } else {
            setCurrentFrameIndex(1);
        }
    }
}
