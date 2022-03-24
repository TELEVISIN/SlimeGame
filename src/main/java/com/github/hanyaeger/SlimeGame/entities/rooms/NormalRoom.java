package com.github.hanyaeger.SlimeGame.entities.rooms;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.api.Coordinate2D;

public class NormalRoom extends Room{

    public NormalRoom(Coordinate2D coordinate2D, Crate[] crates, Wall[] walls, float width, float height) {
        super(coordinate2D, crates, walls, width, height);
    }
}
