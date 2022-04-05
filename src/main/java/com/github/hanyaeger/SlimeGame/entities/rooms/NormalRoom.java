package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Door;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Floor;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;

import java.util.Random;

public class NormalRoom extends Room{
    final int MAX_ENEMIES = 10;
    final int MIN_ENEMIES = 3;

    Random random = new Random();
    int wallChanceMaximum = 10;
    int wallChance;
    int crateChanceMaximum = 1;
    int crateChance;


    public NormalRoom(GameLevel gameLevel)
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

        //loop through row
        for (int columnNr = 0; columnNr < wallAmountX; columnNr++)
        {
            //loop through column
            for (int rowNr = 0; rowNr < wallAmountY; rowNr++)
            {
                //check if tile is floor tile
                if (entityClassArray[oldTilemap[rowNr][columnNr] - 1] == Floor.class)
                {
                    wallChance = random.nextInt(100);
                    crateChance = random.nextInt(100);

                    //try to add an obstacle
                    oldTilemap = addObstacle(oldTilemap, columnNr, rowNr);


                }
            }
        }

        return newTilemap;
    }

    private int[][] addObstacle(int[][] oldTilemap, int columnNr, int rowNr)
    {
        int[][] newTilemap = oldTilemap;

        int upperTileXIndex = columnNr;
        int upperTileYIndex = rowNr - 1;
        int rightTileXIndex = columnNr + 1;
        int rightTileYIndex = rowNr;
        int lowerTileXIndex = columnNr;
        int lowerTileYIndex = rowNr + 1;
        int leftTileXIndex = columnNr - 1;
        int leftTileYIndex = rowNr;

        //check if tile is next to wall, door or crate
        if (entityClassArray[oldTilemap[upperTileYIndex][upperTileXIndex] - 1] != Wall.class &&
                entityClassArray[oldTilemap[rightTileYIndex][rightTileXIndex] - 1] != Wall.class &&
                entityClassArray[oldTilemap[lowerTileYIndex][lowerTileXIndex] - 1] != Wall.class &&
                entityClassArray[oldTilemap[leftTileYIndex][leftTileXIndex] - 1] != Wall.class &&
                entityClassArray[oldTilemap[upperTileYIndex][upperTileXIndex] - 1] != Door.class &&
                entityClassArray[oldTilemap[rightTileYIndex][rightTileXIndex] - 1] != Door.class &&
                entityClassArray[oldTilemap[lowerTileYIndex][lowerTileXIndex] - 1] != Door.class &&
                entityClassArray[oldTilemap[leftTileYIndex][leftTileXIndex] - 1] != Door.class &&
                entityClassArray[oldTilemap[upperTileYIndex][upperTileXIndex] - 1] != Crate.class &&
                entityClassArray[oldTilemap[rightTileYIndex][rightTileXIndex] - 1] != Crate.class &&
                entityClassArray[oldTilemap[lowerTileYIndex][lowerTileXIndex] - 1] != Crate.class &&
                entityClassArray[oldTilemap[leftTileYIndex][leftTileXIndex] - 1] != Crate.class)
        {
            //wall has priority over crates
            if (wallChance < wallChanceMaximum)
            {
                //place wall
                newTilemap[rowNr][columnNr] = 10;
            }
            else if (crateChance < crateChanceMaximum)
            {
                //place crate
                newTilemap[rowNr][columnNr] = 7;
            }
        }

        return newTilemap;
    }
}
