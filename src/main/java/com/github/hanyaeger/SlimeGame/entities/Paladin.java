package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Paladin extends Player {

	GameLevel gamelevel;

	public Paladin(Coordinate2D coordinate2d, SlimeGame slimeGame, HealthText healthText, Room parentRoom, GameLevel gameLevel) {
		super(coordinate2d, slimeGame, healthText, parentRoom);
		setAnchorPoint(AnchorPoint.CENTER_CENTER);
		this.gameLevel = gameLevel;
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
