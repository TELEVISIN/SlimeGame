package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;

public abstract class Enemy extends iLifeform {
	public Enemy(Coordinate2D coordinate2d, SlimeGame slimeGame) {
		super(coordinate2d);
		// TODO Auto-generated constructor stub
	}
	final int BASE_HEALTH = 100;
	final double BASE_SPEED = 5;
	final double BASE_ATTACK_SPEED = 0.7;
	final double BASE_ATTACK_POWER = 10;
	
	int health = BASE_HEALTH;
	double speed = BASE_SPEED;
	double attackPower = BASE_ATTACK_POWER;
	double attackSpeed = BASE_ATTACK_SPEED;

	SlimeGame slimeGame;
	GameLevel gameLevel;
	
	public void onCollision() {
		
	}
	
	public void Atatck() {
		
	}
	
	public void Move() {
		
	}
	
	public void updateHealth( ) {
		
	}
}
