package com.github.hanyaeger.SlimeGame.entities.obstacles;

import com.github.hanyaeger.SlimeGame.entities.Player;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Door extends SpriteEntity implements Collider {
    public Door(Coordinate2D initialLocation, Size size, String resource) {
        super("sprites/Room_tilemap_V2.png", initialLocation, size, 12, 4);

        int index = Integer.parseInt(resource);
        setCurrentFrameIndex(index);
    }
}
