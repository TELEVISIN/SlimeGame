package com.github.hanyaeger.SlimeGame.entities.Rooms;

import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public abstract class Room extends RectangleEntity {
    final int DOOR_NR = 4;
    GameLevel gameLevel;
    Crate[] crates;
    Wall[] walls;

    public Room(Coordinate2D coordinate2D, Crate[] crates, Wall[] walls, float width, float height)
    {
        super(coordinate2D, new Size(0.95 * width, height));
        this.crates = crates;
        this.walls = walls;
    }

    private void buildRoom() {}

    private void setCrates() {}

    private void setWalls() {}

    private void setDoors() {}

    private void spawnEnemies() {}
}
