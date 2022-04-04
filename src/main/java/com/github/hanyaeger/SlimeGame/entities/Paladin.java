package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Paladin extends Player {
	
	public Paladin(Coordinate2D coordinate2d, SlimeGame slimeGame, int health, double speed, double attackPower, double attackSpeed) {
		super(coordinate2d, slimeGame, health, speed, attackPower, attackSpeed);
		setAnchorPoint(AnchorPoint.CENTER_CENTER);
	}


	@Override
	protected void setupEntities() {
		addEntity(new PaladinSprite(new Coordinate2D(0, 0), new Size(width, height)));
		addEntity(new LifeformHitbox(this, new Coordinate2D(0, 0), (int)(width * hitboxMultiplier), (int)(height * hitboxMultiplier)));
	}
		

	
	@Override
	public void Attack() {
		System.out.println("Attack!");
		//handle slimes being attacked;
	}
	
	public void Block() {
		System.out.println("Block!");
	}
}
