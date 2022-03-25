package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;

import java.util.List;

public abstract class Room extends CompositeEntity {
    final int DOOR_NR = 4;
    GameLevel gameLevel;
    Crate[] crates;
    Wall[] walls;
    final String SPRITESHEET = "sprites/Room_tilemap.png";
    final int SPRITE_SIZE = 64;

    public Room(Coordinate2D coordinate2D, GameLevel gameLevel)
    {
        super(coordinate2D);

        this.gameLevel = gameLevel;

        setWalls();
    }

    protected void setupEntities()
    {
        for (Wall wall : walls)
        {
            //addEntity(new Door(new Coordinate2D()));
        }

    }

    private void setCrates() {}

    private void setWalls()
    {
        //set amount of wall x and y
        int wallAmountX = (int) (gameLevel.getWidth() / SPRITE_SIZE) - (4 * SPRITE_SIZE);

        //loop through row
        for (int i = 0; i < wallAmountX; i++)
        {
            //loop through column

        }
    }

    private void setDoors() {}

    private void spawnEnemies() {}
}
