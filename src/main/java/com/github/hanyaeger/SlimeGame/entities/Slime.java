package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.Coordinate2D;

public abstract class Slime extends Enemy {

	final int BASE_HEALTH = 25;
	final double BASE_SPEED = 5;

	/**
	 * Constructor of the Slime. Creates object of a slime.
	 * @param coordinate2d
	 * @param slimeGame
	 */
	public Slime(Coordinate2D coordinate2d, SlimeGame slimeGame) {
		super(coordinate2d, slimeGame);
	}
}
