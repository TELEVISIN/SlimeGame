package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Door;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Floor;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.TileMap;

import java.util.List;
import java.util.Random;

public abstract class Room extends TileMap {
    int wallAmountX;
    int wallAmountY;

    int enemyCount;
    int enemiesKilled = 0;

    GameLevel gameLevel;

    //random floor tiles variables
    int floorTileVariantsStartIndex = 16;
    int floorTileVariantsEndIndex = 31;
    int floorTileVariantIndex;
    Random random = new Random();
    int floorRandomChanceMaximum = 10;
    int floorRandomChance;

    //public boolean doorsOpen = false;
    public boolean doorsOpen = true;


    //class array to keep track of the entity classes of this tilemap
    Class[] entityClassArray = {
            Wall.class,
            Wall.class,
            Door.class,
            Wall.class,
            Door.class,
            Floor.class,
            Crate.class,
            Wall.class,
            Wall.class,
            Wall.class,
            Crate.class,
            Door.class,
            Wall.class,
            Door.class,
            Wall.class,
            Wall.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class,
            Floor.class
    };


    public Room(GameLevel gameLevel)
    {
        this.gameLevel = gameLevel;

        //set amount of wall x and y
        wallAmountX = SlimeGame.roomTileColumns;
        wallAmountY = SlimeGame.roomTileRows;
    }

    public void setupEntities()
    {
        //setup all the entities for the standard room tilemap
        addEntity(1, entityClassArray[0], "0" );
        addEntity(2, entityClassArray[1], "1" );
        addEntity(3, entityClassArray[2], "2" );
        addEntity(4, entityClassArray[3], "3" );
        addEntity(5, entityClassArray[4], "4" );
        addEntity(6, entityClassArray[5], "5" );
        addEntity(7, entityClassArray[6]);
        addEntity(8, entityClassArray[7], "7" );
        addEntity(9, entityClassArray[8], "8" );
        addEntity(10, entityClassArray[9], "9" );
        addEntity(11, entityClassArray[10]);
        addEntity(12, entityClassArray[11], "11" );
        addEntity(13, entityClassArray[12], "12" );
        addEntity(14, entityClassArray[13], "13" );
        addEntity(15, entityClassArray[14], "14" );
        addEntity(16, entityClassArray[15], "15" );
        //floor tile variants
        addEntity(17, entityClassArray[16], "16" );
        addEntity(18, entityClassArray[17], "17" );
        addEntity(19, entityClassArray[18], "18" );
        addEntity(20, entityClassArray[19], "19" );
        addEntity(21, entityClassArray[20], "20" );
        addEntity(22, entityClassArray[21], "21" );
        addEntity(23, entityClassArray[22], "22" );
        addEntity(24, entityClassArray[23], "23" );
        addEntity(25, entityClassArray[24], "24" );
        addEntity(26, entityClassArray[25], "25" );
        addEntity(27, entityClassArray[26], "26" );
        addEntity(28, entityClassArray[27], "27" );
        addEntity(29, entityClassArray[28], "28" );
        addEntity(30, entityClassArray[29], "29" );
        addEntity(31, entityClassArray[30], "30" );
        addEntity(32, entityClassArray[31], "31" );

    }

    //create the base for the TileMap
    protected int[][] createTileMap()
    {
        //create empty tilemap to be filled later on
        int[][] tilemap = new int[wallAmountY][wallAmountX];

        //loop through row
        for(int columnNr = 0; columnNr < wallAmountX; columnNr++)
        {
            //loop through column
            for (int rowNr = 0; rowNr < wallAmountY; rowNr++)
            {
                //check if corner piece
                if (rowNr == 0 && columnNr == 0 ||                              //top left corner
                        rowNr == 0 && columnNr == wallAmountX - 1 ||                //top right corner
                        rowNr == wallAmountY - 1 && columnNr == 0 ||                //bottom left corner
                        rowNr == wallAmountY - 1 && columnNr == wallAmountX - 1)    //bottom right corner
                {
                    //set corner pieces
                    if(rowNr == 0 && columnNr == 0)
                    {
                        //top left corner
                        tilemap[rowNr][columnNr] = 1;
                    }
                    else if(rowNr == 0 && columnNr == wallAmountX - 1)
                    {
                        //top right corner
                        tilemap[rowNr][columnNr] = 4;
                    }
                    else if(rowNr == wallAmountY - 1 && columnNr == 0)
                    {
                        //bottom left corner
                        tilemap[rowNr][columnNr] = 13;
                    }
                    else
                    {
                        //bottom right corner
                        tilemap[rowNr][columnNr] = 16;
                    }
                }
                //if not corner piece, check wall pieces
                else if(rowNr == 0 || rowNr == wallAmountY - 1 || columnNr == 0 || columnNr == wallAmountX - 1)
                {
                    //top wall
                    if (rowNr == 0)
                    {
                        //check if wall needs to be door
                        if(columnNr == wallAmountX / 2)
                        {
                            //door
                            tilemap[rowNr][columnNr] = 3;
                        }
                        else
                        {
                            //wall
                            tilemap[rowNr][columnNr] = 2;
                        }
                    }
                    //bottom wall
                    else if (rowNr == wallAmountY - 1)
                    {
                        //check if wall needs to be door
                        if(columnNr == wallAmountX / 2)
                        {
                            //door
                            tilemap[rowNr][columnNr] = 14;
                        }
                        else
                        {
                            //wall
                            tilemap[rowNr][columnNr] = 15;
                        }
                    }
                    //left wall
                    else if (columnNr == 0)
                    {
                        //check if wall needs to be door
                        if(rowNr == wallAmountY / 2)
                        {
                            //door
                            tilemap[rowNr][columnNr] = 5;
                        }
                        else
                        {
                            //wall
                            tilemap[rowNr][columnNr] = 9;
                        }
                    }
                    //right wall
                    else
                    {
                        //check if wall needs to be door
                        if(rowNr == wallAmountY / 2)
                        {
                            //door
                            tilemap[rowNr][columnNr] = 12;
                        }
                        else
                        {
                            //wall
                            tilemap[rowNr][columnNr] = 8;
                        }
                    }
                }
                //every tile else is floor tile
                else
                {
                    //random tile chance
                    floorRandomChance = random.nextInt(100);

                    if (floorRandomChance < floorRandomChanceMaximum) {
                        //random floor tile
                        floorTileVariantIndex = random.nextInt(floorTileVariantsEndIndex - floorTileVariantsStartIndex) + floorTileVariantsStartIndex;
                        tilemap[rowNr][columnNr] = floorTileVariantIndex + 1;
                    }
                    else
                    {
                        //normal floor tile
                        tilemap[rowNr][columnNr] = 6;
                    }
                }
            }
        }

        return tilemap;
    }

    public void printInstanceMap()
    {
        YaegerEntity[][] instanceMap = getInstanceMap();

        //make a print functino to see what  the map contains
        for ( YaegerEntity[] instanceRow : instanceMap)
        {
            for ( YaegerEntity instance : instanceRow)
            {
                System.out.print(instance.getClass().getSimpleName());
                System.out.print(",  ");
            }

            //start a new line
            System.out.println();
        }
    }

    public void printTileMap(int[][] tilemap) {
        YaegerEntity[][] instanceMap = getInstanceMap();

        //make a print functino to see what  the map contains
        for (int[] tileRow : tilemap) {
            for (int tile : tileRow) {
                System.out.print(tile);
                System.out.print(",  ");
            }

            //start a new line
            System.out.println();
        }
    }

    public void updateEnemiesKilled()
    {
        enemiesKilled++;

        //open doors if all enemies have been killed
        openDoors();
    }

    private void openDoors()
    {
        doorsOpen = true;
    }


    private void spawnEnemies() {}
}
