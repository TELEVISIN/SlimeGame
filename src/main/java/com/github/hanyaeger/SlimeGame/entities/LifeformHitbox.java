package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public class LifeformHitbox extends RectangleEntity implements Collided, Collider{
	
	iLifeform ilifeform;

	/**
	 * Constructor of lifeform hitbox. Creates an object of a lifeform hitbox
	 * @param ilifeform
	 * @param initialPosition
	 * @param width
	 * @param height
	 */
	public LifeformHitbox(iLifeform ilifeform, Coordinate2D initialPosition, int width, int height) {
		super(initialPosition);
		this.ilifeform = ilifeform;
		setWidth(width);
		setHeight(height);
		setOpacity(0);
	}

	/**
	 * Handles collision with the Hitbox
	 * @param collidingObject
	 */
	@Override
	public void onCollision(Collider collidingObject) {
		ilifeform.onCollision(collidingObject);
	}
}
