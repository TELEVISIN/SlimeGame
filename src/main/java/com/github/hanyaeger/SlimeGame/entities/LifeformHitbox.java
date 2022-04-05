package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public class LifeformHitbox extends RectangleEntity implements Collided, Collider{
	
	iLifeform ilifeform;
	
	public LifeformHitbox(iLifeform ilifeform, Coordinate2D initialPosition, int width, int height) {
		super(initialPosition);
		this.ilifeform = ilifeform;
		setWidth(width);
		setHeight(height);
		setOpacity(0);
	}

	@Override
	public void onCollision(Collider collidingObject) {
		// TODO Auto-generated method stub
		ilifeform.onCollision(collidingObject);

	}
}
