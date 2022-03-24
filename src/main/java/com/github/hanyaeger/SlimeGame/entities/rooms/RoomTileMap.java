package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.api.scenes.TileMap;

public class RoomTileMap extends TileMap {
    @Override
    public void setupEntities() {

        addEntity(1, Wall.class);
        addEntity(2, Wall.class);
        addEntity(3, Wall.class);
        addEntity(4, Wall.class);
        addEntity(5, Wall.class);
        addEntity(6, Wall.class);
        addEntity(7, Wall.class);
        addEntity(8, Wall.class);
        addEntity(9, Wall.class);
        addEntity(10, Wall.class);
        addEntity(11, Wall.class);
        addEntity(12, Wall.class);
    }

    @Override
    public int[][] defineMap() {
        return new int[0][];
    }
}
