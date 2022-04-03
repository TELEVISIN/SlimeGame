package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;

public abstract class Slime extends Enemy {

	final int BASE_HEALTH = 100;
	final double BASE_SPEED = 5;
	final double BASE_ATTACK_SPEED = 0.7;
	final double BASE_ATTACK_POWER = 10;
	GameLevel gameLevel;
	
	public Slime(Coordinate2D coordinate2d, SlimeGame slimeGame) {
		super(coordinate2d, slimeGame);
		// TODO Auto-generated constructor stub
	}
	
	public void Move() {
		
	}
	
	public void Attack() {
		
	}

}
