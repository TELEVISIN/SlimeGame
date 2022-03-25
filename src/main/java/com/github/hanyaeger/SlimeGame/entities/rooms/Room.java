package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Door;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.scenes.TileMap;

import java.util.List;

public abstract class Room extends TileMap {
    final int DOOR_NR = 4;
    GameLevel gameLevel;
    Crate[] crates;
    Wall[] walls;
    final String SPRITESHEET = "sprites/Room_tilemap.png";
    final int SPRITE_SIZE = 64;

    public Room(GameLevel gameLevel)
    {
        this.gameLevel = gameLevel;

        setWalls();
    }

    public void setupEntities()
    {
        //setup all the entities for the standard room tilemap
        addEntity(16, Wall.class, "0" );
        addEntity(1, Wall.class, "1" );
        addEntity(2, Wall.class, "2" );
        addEntity(3, Wall.class, "3" );
        addEntity(4, Wall.class, "4" );
        addEntity(5, Wall.class, "5" );
        addEntity(6, Wall.class, "6" );
        addEntity(7, Wall.class, "7" );
        addEntity(8, Wall.class, "8" );
        addEntity(9, Wall.class, "9" );
        addEntity(10, Wall.class, "10" );
        addEntity(11, Wall.class, "11" );
        addEntity(12, Wall.class, "12" );
        addEntity(13, Wall.class, "13" );
        addEntity(14, Wall.class, "14" );
        addEntity(15, Wall.class, "15" );

    }

    private void setCrates() {}

    protected void setWalls() {}

    private void setDoors() {}

    private void spawnEnemies() {}
}
