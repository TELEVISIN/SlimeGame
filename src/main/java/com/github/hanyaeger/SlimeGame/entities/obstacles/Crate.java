package com.github.hanyaeger.SlimeGame.entities.obstacles;

import com.github.hanyaeger.SlimeGame.entities.AttackSprite;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Crate extends SpriteEntity implements Collider, Collided {
    final int CRATE_SPRITE_INDEX = 6;
    final int CRATE_DESTROYED_SPRITE_INDEX = 10;
    public boolean isDestroyed = false;

    /**
     * Constructor of crate. Creates object of crate
     * @param initialLocation
     * @param size
     */
    public Crate(Coordinate2D initialLocation, Size size) {
        super("sprites/Room_tilemap_V2.png", initialLocation, size, 12, 4);

        setCurrentFrameIndex(CRATE_SPRITE_INDEX);
    }

    /**
     * Handles collisions with the crate
     * @param collider
     */
    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof AttackSprite && !isDestroyed)
        {
            System.out.println("Crate Hit!");
            this.Destroy();
        }
    }

    /**
     * Sets the crate to its destroyed state
     */
    private void Destroy()
    {
        isDestroyed = true;

        setCurrentFrameIndex(CRATE_DESTROYED_SPRITE_INDEX);
        System.out.println("Crate Destroyed...");
    }
}
