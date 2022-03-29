package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Door;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.scenes.TileMap;

import java.util.List;

public abstract class Room extends TileMap {
    final int DOOR_NR = 4;
    final int SPRITE_SIZE = 64;

    int wallAmountX;
    int wallAmountY;

    GameLevel gameLevel;

    public Room(GameLevel gameLevel)
    {
        this.gameLevel = gameLevel;

        //set amount of wall x and y
        wallAmountX = (int) (gameLevel.getWidth() / SPRITE_SIZE);
        wallAmountY = (int) (gameLevel.getHeight() / SPRITE_SIZE);

        createTileMap();
    }

    public void setupEntities()
    {
        //setup all the entities for the standard room tilemap
        addEntity(1, Door.class, "0" );
        addEntity(2, Wall.class, "1" );
        addEntity(3, Wall.class, "2" );
        addEntity(4, Door.class, "3" );
        addEntity(5, Wall.class, "4" );
        addEntity(6, Wall.class, "5" );
        addEntity(7, Wall.class, "6" );
        addEntity(8, Wall.class, "7" );
        addEntity(9, Wall.class, "8" );
        addEntity(10, Wall.class, "9" );
        addEntity(11, Wall.class, "10" );
        addEntity(12, Wall.class, "11" );
        addEntity(13, Door.class, "12" );
        addEntity(14, Wall.class, "13" );
        addEntity(15, Wall.class, "14" );
        addEntity(16, Door.class, "15" );

    }

    private void setCrates() {}

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
                    tilemap[rowNr][columnNr] = 6;
                }
            }
        }

        return tilemap;
    }



    private void spawnEnemies() {}
}
