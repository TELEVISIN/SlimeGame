package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Door;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Floor;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;

import java.util.Random;

public class BossRoom extends Room{
    final int MAX_ENEMIES = 10;
    final int MIN_ENEMIES = 3;

    Random random = new Random();


    public BossRoom(GameLevel gameLevel)
    {
        super(gameLevel);

        //set enemy variables
        enemyCount = random.nextInt(MAX_ENEMIES - MIN_ENEMIES) + MIN_ENEMIES;
        enemiesKilled = 0;
    }


    @Override
    public int[][] defineMap()
    {
        return editTileMap(createTileMap());
    }

    //edit tilemap by adding walls and crates
    private int[][] editTileMap(int[][] oldTilemap) {
        int[][] newTilemap = oldTilemap;

        //place predefined set of walls
        newTilemap[2][2] = 10;
        newTilemap[2][wallAmountX - 3] = 10;
        newTilemap[wallAmountY - 3][2] = 10;
        newTilemap[wallAmountY - 3][wallAmountX - 3] = 10;

        //place predefined set of crates
        newTilemap[wallAmountY / 2][2] = 7;
        newTilemap[wallAmountY / 2][wallAmountX - 3] = 7;

        return newTilemap;
    }
}
