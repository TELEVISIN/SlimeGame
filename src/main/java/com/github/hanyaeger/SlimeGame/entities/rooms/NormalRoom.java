package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.scenes.GameLevel;

public class NormalRoom extends Room{

    public NormalRoom(GameLevel gameLevel)
    {
        super(gameLevel);
    }


    @Override
    public int[][] defineMap()
    {
        //create layout of standard room
//        return new int[][]{
//                {1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 4},
//                {9, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
//                {9, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
//                {9, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
//                {9, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
//                {5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 12},
//                {9, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
//                {9, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
//                {9, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
//                {9, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
//                {13, 15, 15, 15, 15, 15, 15, 15, 15, 14, 15, 15, 15, 15, 15, 15, 15, 15, 16}
//        };

        int[][] tilemap = createTileMap();
        return tilemap;
    }

    @Override
    protected int[][] createTileMap()
    {
        //set amount of wall x and y
        int wallAmountX = (int) (gameLevel.getWidth() / SPRITE_SIZE);
        int wallAmountY = (int) (gameLevel.getHeight() / SPRITE_SIZE);

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
                else
                {
                    //if not corner piece, check wall pieces
                    tilemap[rowNr][columnNr] = 6;
                }
            }
        }

        return tilemap;
    }
}
