package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;

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

	boolean isAlive = true;
	Room parentRoom;

	SlimeGame slimeGame;
	GameLevel gameLevel;
	
	public void onCollision(Collider collidingObject) {
		//if collide with attack, take damage
		if (collidingObject instanceof AttackSprite)
		{
			TakeDamage((AttackSprite) collidingObject);
		}

		//if colliding with player
		if (collidingObject instanceof Player)
		{
			System.out.println("Oh no!!! Scawy Pawadin be touching meeee ONO!");
		}
	}

	public void TakeDamage(AttackSprite attackSprite)
	{
		//if still alive
		if (isAlive) {
			health -= attackSprite.attackPower;
			System.out.println("ENEMY HIT");

			//if health hits or drops below zero, kill
			if (health <= 0) {
				parentRoom.updateEnemiesKilled();
				isAlive = false;
				System.out.println("ENEMY KILLED");
				remove();
			}
		}
	}
	
	public void Attack() {
		
	}
	
	public void Move() {
	}
}
