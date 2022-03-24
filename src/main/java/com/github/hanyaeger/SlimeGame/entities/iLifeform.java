/**
 * 
 */
package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

/**
 * @author jasper
 *
 */
public abstract class iLifeform extends DynamicCompositeEntity {
	//base lifeform stats, modified by class or enemy type
	final int BASE_HEALTH = 100;
	final double BASE_SPEED = 1.5; //0.7 tiles per second?
	final double BASE_ATTACK_POWER = 10;
	final double BASE_ATTACK_SPEED = 0.7;
	
	int health;
	float speed;
	float attackPower;
	float attackSpeed;
	SlimeGame slimegame;
	GameLevel gameLevel;
	
	public iLifeform(Coordinate2D initialLocation) {
		super(initialLocation);
		// TODO Auto-generated constructor stub
	}
	
	public void onCollision(Collider collided) {
		
	}
	
	public void Move() {
		
	}
	
	public void Attack(SlimeGame slimeGame) {
		
	}
	
	public void UpdateHealth() {
		
	}
}
