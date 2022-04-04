package com.github.hanyaeger.SlimeGame.entities;

import java.util.Optional;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import javafx.scene.Node;

public class SlimeSprite extends DynamicSpriteEntity {

	protected SlimeSprite(Coordinate2D initialLocation, Size size) {
		super("sprites/LifeformSpriteSheet.png", initialLocation, size, 8, 8);
		setCurrentFrameIndex(4); 
		//frame 4 = facing forward
		//frame 12 = facing right
		//frame 20 = facing left
		//frame 28 = facing up
		
		
		// TODO Auto-generated constructor stub
	}

}
