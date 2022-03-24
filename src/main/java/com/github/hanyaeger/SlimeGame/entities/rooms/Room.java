package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public abstract class Room extends RectangleEntity {
    final int DOOR_NR = 4;
    GameLevel gameLevel;
    Crate[] crates;
    Wall[] walls;
    final String SPRITESHEET = "sprites/Room_tilemap.png";

    public Room(Coordinate2D coordinate2D, Crate[] crates, Wall[] walls, float width, float height)
    {
        super(coordinate2D, new Size(0.95 * width, height));
        this.crates = crates;
        this.walls = walls;
    }

    private void buildRoom() {
        for (Wall wall : walls)
        {
            gameLevel.addEntity();
        }
    }

    private void setCrates() {}

    private void setWalls() {}

    private void setDoors() {}

    private void spawnEnemies() {}
}
