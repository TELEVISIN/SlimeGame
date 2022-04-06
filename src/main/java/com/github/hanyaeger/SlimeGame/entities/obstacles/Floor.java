package com.github.hanyaeger.SlimeGame.entities.obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Floor extends SpriteEntity {
    /**
     * Constructor of Floor. Creates object of floor.
     * @param initialLocation
     * @param size
     * @param resource
     */
    public Floor(Coordinate2D initialLocation, Size size, String resource) {
        super("sprites/Room_tilemap_V2.png", initialLocation, size, 12, 4);

        int index = Integer.parseInt(resource);
        setCurrentFrameIndex(index);
    }
}
