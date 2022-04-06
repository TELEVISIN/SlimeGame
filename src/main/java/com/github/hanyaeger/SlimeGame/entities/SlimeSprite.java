package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;


public class SlimeSprite extends DynamicSpriteEntity {
	/**
	 * Constructor of SlimeSprite. Creates an object of a slime sprite.
	 * @param initialLocation
	 * @param size
	 */
	protected SlimeSprite(Coordinate2D initialLocation, Size size) {
		super("sprites/LifeformSpriteSheet.png", initialLocation, size, 8, 8);
		setCurrentFrameIndex(4);
	}

}
