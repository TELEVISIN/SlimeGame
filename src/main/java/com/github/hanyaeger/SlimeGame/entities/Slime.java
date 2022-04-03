package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;

public abstract class Slime extends Enemy {

	final int BASE_HEALTH = 25;
	final double BASE_SPEED = 5;
	final double BASE_ATTACK_SPEED = 1;
	final double BASE_ATTACK_POWER = 5;
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
