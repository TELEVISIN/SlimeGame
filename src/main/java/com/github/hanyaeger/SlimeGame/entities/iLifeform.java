
package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;


public abstract class iLifeform extends DynamicCompositeEntity {
	boolean canMoveUp = true;
	boolean canMoveDown = true;
	boolean canMoveLeft = true;
	boolean canMoveRight = true;

	GameLevel gameLevel;

	/**
	 * Constructor of iLifeform. Creates an object of iLifeform
	 * @param initialLocation
	 */
	public iLifeform(Coordinate2D initialLocation) {
		super(initialLocation);
	}

	/**
	 * Handles the collision with a lifeform.
	 * @param collidingObject
	 */
	public void onCollision(Collider collidingObject) {}

	/**
	 * Takes care of the lifeform movement
	 */
	public void Move() {}

	/**
	 * Takes care of the attacking of the lifeform
	 */
	public void Attack() {}
}
