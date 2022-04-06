package com.github.hanyaeger.SlimeGame.entities;

import java.util.Random;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;

public class SmallSlime extends Slime {
	
	private double speed = BASE_SPEED - 1;
	
	int width = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;
	int height = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;

	/**
	 * Constructor of SmallSlime. Creates an object of a small Slime.
	 * @param coordinate2d
	 * @param slimeGame
	 * @param parentRoom
	 */
	public SmallSlime(Coordinate2D coordinate2d, SlimeGame slimeGame, Room parentRoom) {
		super(coordinate2d, slimeGame);
		this.parentRoom = parentRoom;
		
		health = BASE_HEALTH;
	}

	/**
	 * Sets up the entities for the composte entity.
	 */
	@Override
	protected void setupEntities() {
		addEntity(new SlimeSprite(new Coordinate2D(0, 0), new Size(width, height)));
		addEntity(new LifeformHitbox(this, new Coordinate2D(0, height / 2), (int)(width * 0.95), (int)(height * 0.6)));
	}

}
