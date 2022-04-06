package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;

public abstract class Enemy extends iLifeform {
	int health;
	boolean isAlive = true;

	Room parentRoom;

	SlimeGame slimeGame;

	/**
	 * Constructor of Enemy. Creates object of enemy.
	 * @param coordinate2d
	 * @param slimeGame
	 */
	public Enemy(Coordinate2D coordinate2d, SlimeGame slimeGame) {
		super(coordinate2d);
		this.slimeGame = slimeGame;
	}

	/**
	 * Handles Collision with the Enemy
	 * @param collidingObject
	 */
	public void onCollision(Collider collidingObject) {
		//if collide with attack, take damage
		if (collidingObject instanceof AttackSprite)
		{
			TakeDamage((AttackSprite) collidingObject);
		}
	}

	/**
	 * Lowers health when still alive.
	 * @param attackSprite
	 */
	public void TakeDamage(AttackSprite attackSprite)
	{
		//if still alive
		if (isAlive) {
			health -= attackSprite.attackPower;
			System.out.println("ENEMY HIT");
			System.out.println(health);

			//if health hits or drops below zero, kill
			if (health <= 0) {
				if (this instanceof SlimeKing) {
					slimeGame.setActiveScene(3);
				} else {
					parentRoom.updateEnemiesKilled();
					isAlive = false;
					System.out.println("ENEMY KILLED");
					remove();
				}	
			}
		}
	}
	
	public void Attack() {}
	
	public void Move() {}
}
