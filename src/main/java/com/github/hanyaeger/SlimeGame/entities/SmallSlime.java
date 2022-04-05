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
	
	public SmallSlime(Coordinate2D coordinate2d, SlimeGame slimeGame, Room parentRoom) {
		super(coordinate2d, slimeGame);
		this.parentRoom = parentRoom;
		
		health = BASE_HEALTH;
	}
	
	@Override
	protected void setupEntities() {
		// TODO Auto-generated method stub
		addEntity(new SlimeSprite(new Coordinate2D(0, 0), new Size(width, height)));
		addEntity(new LifeformHitbox(this, new Coordinate2D(0, 0), (int)(width * 0.95), (int)(height * 0.95)));
	}
	
	public void Move() {
		
	}
	
	public void Attack() {
		
	}

}
