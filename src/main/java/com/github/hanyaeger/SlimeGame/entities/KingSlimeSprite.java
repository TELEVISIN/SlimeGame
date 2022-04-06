package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class KingSlimeSprite extends DynamicSpriteEntity {
	/**
	 * Constructor of KingSlimeSprite. Creates an object of the king slime sprite.
	 * @param initialLocation
	 * @param size
	 */
	protected KingSlimeSprite(Coordinate2D initialLocation, Size size) {
		super("sprites/LifeformSpriteSheet.png", initialLocation, size, 4, 4);
		setCurrentFrameIndex(11);
	}
}
