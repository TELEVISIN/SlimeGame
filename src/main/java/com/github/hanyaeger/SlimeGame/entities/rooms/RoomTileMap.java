package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Door;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.api.scenes.TileMap;

public class RoomTileMap extends TileMap {
    @Override
    public void setupEntities() {
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

    @Override
    public int[][] defineMap()
    {
        return new int[][]{
                {16, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 11},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},
                {12, 14, 14, 14, 14, 14, 14, 14, 14, 13, 14, 14, 14, 14, 14, 14, 14, 14, 15}
        };
    }
}
