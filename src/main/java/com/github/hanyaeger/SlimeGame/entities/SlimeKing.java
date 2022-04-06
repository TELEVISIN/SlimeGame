package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SlimeKing extends Slime {

	public int KingScaleSize = 2;
	
	int width = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale * KingScaleSize;
	int height = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale * KingScaleSize;

	/**
	 * Constructor of SlimeKing. Creates an object of THE slime king.
	 * @param coordinate2d
	 * @param slimeGame
	 * @param parentRoom
	 */
	public SlimeKing(Coordinate2D coordinate2d, SlimeGame slimeGame, Room parentRoom) {
		super(coordinate2d, slimeGame);
		this.parentRoom = parentRoom;
		
		health = BASE_HEALTH * 5;
	}

	/**
	 * Sets up the entities for the composite entity
	 */
	@Override
	protected void setupEntities() {
		addEntity(new KingSlimeSprite(new Coordinate2D(0, 0), new Size(width, height)));
		addEntity(new LifeformHitbox(this, new Coordinate2D(0, 0), (int)(width * 0.95), (int)(height * 0.95)));
	}
}
