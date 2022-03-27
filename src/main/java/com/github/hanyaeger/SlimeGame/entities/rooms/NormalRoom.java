package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.scenes.GameLevel;

import java.util.Random;

public class NormalRoom extends Room{
    Random random = new Random();
    int wallChanceMinimum = 5;
    int wallChanceMaximum = 45;
    int wallChance = random.nextInt(wallChanceMaximum - wallChanceMinimum) + wallChanceMinimum;

    public NormalRoom(GameLevel gameLevel)
    {
        super(gameLevel);
    }


    @Override
    public int[][] defineMap()
    {
        return createTileMap();
    }

    //edit tilemap by adding walls and crates
    private int[][] EditTileMap(int[][] oldTilemap) {
        int[][] newTilemap = oldTilemap;

        //loop through row
        for (int columnNr = 0; columnNr < wallAmountX; columnNr++)
        {
            //loop through column
            for (int rowNr = 0; rowNr < wallAmountY; rowNr++)
            {

            }
        }


        return newTilemap;
    }
}
