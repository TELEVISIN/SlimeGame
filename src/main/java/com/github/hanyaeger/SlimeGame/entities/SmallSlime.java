package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SmallSlime extends Slime {
	
	int width = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;
	int height = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;

	final int BASE_HEALTH = 100;
	final double BASE_SPEED = 5;
	final double BASE_ATTACK_SPEED = 0.7;
	final double BASE_ATTACK_POWER = 10;
	
	public SmallSlime(Coordinate2D coordinate2d, SlimeGame slimeGame) {
		super(coordinate2d, slimeGame);
		// TODO Auto-generated constructor stub
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
