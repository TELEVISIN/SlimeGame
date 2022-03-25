package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.TileMap;

import java.util.List;

public class NormalRoom extends Room{

    public NormalRoom(Coordinate2D coordinate2D, GameLevel gameLevel) {
        super(coordinate2D, gameLevel);
    }

    @Override
    protected void setupEntities() {

    }
}
