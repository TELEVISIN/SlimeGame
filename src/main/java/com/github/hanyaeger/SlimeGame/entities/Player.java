package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

/*
 * 
 * @Author: Jasper
 * 
 */

public abstract class Player extends iLifeform implements KeyListener {
	final int BASE_HEALTH = 100;
	final double BASE_SPEED = 5;
	final double BASE_ATTACK_SPEED = 0.7;
	final double BASE_ATTACK_POWER = 10;
	
	int health = BASE_HEALTH;
	double speed = BASE_SPEED;
	double attackPower = BASE_ATTACK_POWER;
	double attackSpeed = BASE_ATTACK_SPEED;

	boolean leftKey;
	boolean upKey;
	boolean rightKey;
	boolean downKey;
	
	int experience;
	int level;
	SlimeGame slimeGame;
	
	public Player(Coordinate2D coordinate2d, SlimeGame slimeGame, int health, double speed, double attackPower, double atatckSpeed) {
		super(coordinate2d);
	}


	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		// TODO Auto-generated method stub
		leftKey = pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A);
		upKey = pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.W);
		rightKey = pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D);
		downKey = pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S);

		Move();
	}

	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof Wall)
		{
			double wallX = ((Wall) collidingObject).getAnchorLocation().getX();
			double wallY = ((Wall) collidingObject).getAnchorLocation().getY();
			double wallSize = ((Wall) collidingObject).getWidth();
			double lifeFormX = this.getLocationInScene().getX();
			double lifeFormY = this.getLocationInScene().getY();
			double lifeFormSize = this.getWidth();


			boolean topWall = wallY < lifeFormY;
			boolean bottomWall = wallY > lifeFormY;
			boolean rightWall = wallX > lifeFormX;
			boolean leftWall = wallY < lifeFormY;

			//if wall is top
			if (topWall)
			{
				System.out.println("TOP WALL");
				if(leftKey && upKey)
				{
					//go right if right is also pressed
					setMotion(speed / 2, 270d);
				}
				else if (upKey && rightKey)
				{
					//go left if left is also pressed
					setMotion(speed / 2, 90d);
				}
				else if (upKey)
				{
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveUp = false;
			}

			//if wall is bottom
			if (bottomWall)
			{
				System.out.println("BOTTOM WALL");
				if(leftKey && downKey)
				{
					//go right if right is also pressed
					setMotion(speed / 2, 270d);
				}
				else if (upKey && downKey)
				{
					//go left if left is also pressed
					setMotion(speed / 2, 90d);
				}
				else if (downKey)
				{
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveDown = false;
			}

			//if wall is left
			if (leftWall)
			{
				System.out.println("LEFT WALL");
				if(downKey && leftKey)
				{
					//go down if down is also pressed
					setMotion(speed / 2, 0d);
				}
				else if (upKey && leftKey)
				{
					//go left if left is also pressed
					setMotion(speed / 2, 180d);
				}
				else if (leftKey)
				{
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveLeft = false;
			}

			//if wall is right
			if (rightWall)
			{
				System.out.println("RIGHT WALL");
				if(downKey && rightKey)
				{
					//go down if down is also pressed
					setMotion(speed / 2, 0d);
				}
				else if (upKey && rightKey)
				{
					//go up if up is also pressed
					setMotion(speed / 2, 180d);
				}
				else if (rightKey)
				{
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveRight = false;
			}
		}
	}

	public void Attack() {
		
	}
	
	public void Block() {
		
	}

	public void Move()
	{
		//diagonal movement
		if(leftKey && upKey && canMoveLeft && canMoveUp) {
			setMotion(speed, 225d);
		} else if (upKey && rightKey && canMoveRight && canMoveUp) {
			setMotion(speed, 135d);
		} else if (rightKey && downKey && canMoveRight && canMoveDown) {
			setMotion(speed, 45d);
		} else if (downKey && leftKey && canMoveDown && canMoveLeft) {
			setMotion(speed, 315d);
		}
		//horizontal and vertical movement
		else if(leftKey && canMoveLeft) {
			setMotion(speed, 270d);
		} else if (rightKey && canMoveRight) {
			setMotion(speed, 90d);
		} else if (upKey && canMoveUp) {
			setMotion(speed, 180d);
		} else if (downKey && canMoveDown) {
			setMotion(speed, 0d);
		}

		//stand still
		else if (!upKey && !downKey && !leftKey && !rightKey) {
			setSpeed(0);
		}

		//enable all movement again
		canMoveUp = true;
		canMoveDown = true;
		canMoveLeft = true;
		canMoveRight = true;
	}

	//onCollison
	//Move
	//updateHealth
	//updateExperience
}
