package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Paladin extends Player {
	/**
	 * Constructor of Paladin. Creates a paladin object.
	 * @param coordinate2d
	 * @param slimeGame
	 * @param healthText
	 * @param parentRoom
	 * @param gameLevel
	 */
	public Paladin(Coordinate2D coordinate2d, SlimeGame slimeGame, HealthText healthText, Room parentRoom, GameLevel gameLevel) {
		super(coordinate2d, slimeGame, healthText, parentRoom);
		setAnchorPoint(AnchorPoint.CENTER_CENTER);
		this.gameLevel = gameLevel;
	}

	/**
	 * Sets up entities of the paladin composite entity
	 */
	@Override
	protected void setupEntities() {
		addEntity(new PaladinSprite(new Coordinate2D(0, 0), new Size(width, height)));
		addEntity(new LifeformHitbox(this, new Coordinate2D(0, 0), (int)(width * hitboxMultiplier), (int)(height * hitboxMultiplier)));
	}

	/**
	 * Signals an attack in the console.
	 */
	@Override
	public void Attack() {
		System.out.println("Attack!");
	}

	/**
	 * Signals a block in the console.
	 */
	public void Block() {
		System.out.println("Block!");
	}
}
