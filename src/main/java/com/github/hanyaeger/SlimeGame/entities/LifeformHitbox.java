package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public class LifeformHitbox extends RectangleEntity{
	public LifeformHitbox(Coordinate2D initialPosition, int width, int height) {
		super(initialPosition);
	}
}
