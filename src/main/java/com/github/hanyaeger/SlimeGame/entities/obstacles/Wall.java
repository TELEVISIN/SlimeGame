package com.github.hanyaeger.SlimeGame.entities.obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Wall extends SpriteEntity implements Collider {

    public Wall(Coordinate2D initialLocation, Size size, String resource) {
        super("sprites/Room_tilemap.png", initialLocation, size, 4, 4);

        int index = Integer.parseInt(resource);
        setCurrentFrameIndex(index);

    }
}
