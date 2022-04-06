package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;


public class PaladinAttackSprite extends DynamicSpriteEntity {
	/**
	 * Constructor of Paladin attack sprite. Creates an object of a paladin attack sprite.
	 * @param initialLocation
	 */
	public PaladinAttackSprite(Coordinate2D initialLocation) {
		super("sprites/LifeformSpriteSheet.png", initialLocation, new Size(64, 64), 8, 8);
        setCurrentFrameIndex(11);
	}

}
