package com.github.hanyaeger.SlimeGame.entities.obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Crate extends SpriteEntity implements Collider {
    final int CRATE_SPRITE_INDEX = 6;

    public Crate(Coordinate2D initialLocation, Size size) {
        super("sprites/Room_tilemap_V2.png", initialLocation, size, 12, 4);

        setCurrentFrameIndex(CRATE_SPRITE_INDEX);
    }
}
