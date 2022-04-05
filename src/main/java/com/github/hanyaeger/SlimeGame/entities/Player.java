package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Door;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
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
	final static int BASE_HEALTH = 100;
	final double BASE_SPEED = 5;
	final double BASE_ATTACK_SPEED = 0.7;
	final double BASE_ATTACK_POWER = 10;
	final int CORNER_CLIP_BUFFER = 1;

	double hitboxMultiplier = 0.8;
	int width = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;
	int height = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;
	
	public static int health = BASE_HEALTH;
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
		//if colliding with door, open it on button press

		if (collidingObject instanceof Door) {
			System.out.println("Door");

		}

		//if colliding with enemy, take damage
		if (collidingObject instanceof Enemy) {
			System.out.println("Enemy");
			health -= 5;
		}

		//if colliding with wall or crate check wall collision
		if (collidingObject instanceof Wall || collidingObject instanceof Crate) {
			checkWallCollision(collidingObject);
		}
	}

	public void checkWallCollision(Collider collidingObject) {

		double wallX;
		double wallY;
		double wallSize = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;

		double playerHitboxSize = width * hitboxMultiplier;

		int boundryBuffer = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;
		double windowHeight = this.getSceneHeight();
		double windowWidth = this.getSceneWidth();

		if (collidingObject instanceof Wall) {
			wallX = ((Wall) collidingObject).getAnchorLocation().getX();
			wallY = ((Wall) collidingObject).getAnchorLocation().getY();
		} else {
			if (((Crate) collidingObject).isDestroyed) {
				//if crate is destroyed, cancel collision
				return;
			}

			wallX = ((Crate) collidingObject).getAnchorLocation().getX();
			wallY = ((Crate) collidingObject).getAnchorLocation().getY();
		}


		double lifeFormX = this.getLocationInScene().getX();
		double lifeFormY = this.getLocationInScene().getY();


		boolean topWall = (wallY <= lifeFormY - wallSize * 1.4) &&
				(lifeFormX < wallX + wallSize * 1.4 - CORNER_CLIP_BUFFER) &&
				(lifeFormX > wallX - wallSize * 0.4 + CORNER_CLIP_BUFFER);

		boolean bottomWall = (wallY >= lifeFormY + wallSize * 0.24) &&
				(lifeFormX < wallX + wallSize * 1.4 - CORNER_CLIP_BUFFER) &&
				(lifeFormX > wallX - wallSize * 0.4 + CORNER_CLIP_BUFFER);

		boolean rightWall = (wallX >= lifeFormX + wallSize * 0.24) &&
				(lifeFormY < wallY + wallSize * 1.4 - CORNER_CLIP_BUFFER) &&
				(lifeFormY > wallY - wallSize * 0.4 + CORNER_CLIP_BUFFER);

		boolean leftWall = (wallX <= lifeFormX - wallSize * 1.4) &&
				(lifeFormY < wallY + wallSize * 1.4 - CORNER_CLIP_BUFFER) &&
				(lifeFormY > wallY - wallSize * 0.4 + CORNER_CLIP_BUFFER);

		boolean topEdge = lifeFormY - playerHitboxSize * 0.6 <= boundryBuffer;
		boolean bottomEdge = lifeFormY + playerHitboxSize * 0.6 >= windowHeight - boundryBuffer;
		boolean leftEdge = lifeFormX - playerHitboxSize * 0.6 <= boundryBuffer;
		boolean rightEdge = lifeFormX + playerHitboxSize * 0.6 >= windowWidth - boundryBuffer;


		//check if lifeform is not at edge of the room
		if (!topEdge && !bottomEdge && !leftEdge && !rightEdge) {

			//if wall is top
			if (topWall) {
				System.out.println("TOP WALL");
				if (leftKey && upKey) {
					//go right if right is also pressed
					setMotion(speed / 2, 270d);
				} else if (upKey && rightKey) {
					//go left if left is also pressed
					setMotion(speed / 2, 90d);
				} else if (upKey) {
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveUp = false;
			}

			//if wall is bottom
			if (bottomWall) {
				System.out.println("BOTTOM WALL");
				if (leftKey && downKey) {
					//go right if right is also pressed
					setMotion(speed / 2, 270d);
				} else if (rightKey && downKey) {
					//go left if left is also pressed
					setMotion(speed / 2, 90d);
				} else if (downKey) {
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveDown = false;
			}

			//if wall is left
			if (leftWall) {
				System.out.println("LEFT WALL");
				if (downKey && leftKey) {
					//go down if down is also pressed
					setMotion(speed / 2, 0d);
				} else if (upKey && leftKey) {
					//go left if left is also pressed
					setMotion(speed / 2, 180d);
				} else if (leftKey) {
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveLeft = false;
			}

			//if wall is right
			if (rightWall) {
				System.out.println("RIGHT WALL");
				if (downKey && rightKey) {
					//go down if down is also pressed
					setMotion(speed / 2, 0d);
				} else if (upKey && rightKey) {
					//go up if up is also pressed
					setMotion(speed / 2, 180d);
				} else if (rightKey) {
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveRight = false;
			}
		} else {
			//block movement and don't check for other walls if lifeform is at an edge

			//if player is at top of room
			if (topEdge) {
				System.out.println("Top Edge");
				if (leftKey && upKey) {
					//go right if right is also pressed
					setMotion(speed / 2, 270d);
				} else if (upKey && rightKey) {
					//go left if left is also pressed
					setMotion(speed / 2, 90d);
				} else if (upKey) {
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveUp = false;
			}

			//if player is at bottom of room
			if (bottomEdge) {
				System.out.println("Bottom Edge");
				if (leftKey && downKey) {
					//go right if right is also pressed
					setMotion(speed / 2, 270d);
				} else if (rightKey && downKey) {
					//go left if left is also pressed
					setMotion(speed / 2, 90d);
				} else if (downKey) {
					//stop the up motion
					setSpeed(0);
				}

				//soft block up movement
				canMoveDown = false;
			}

			//if player is at left of room
			if (leftEdge) {
				//if wall is left
				if (leftWall) {
					System.out.println("Left Edge");
					if (downKey && leftKey) {
						//go down if down is also pressed
						setMotion(speed / 2, 0d);
					} else if (upKey && leftKey) {
						//go left if left is also pressed
						setMotion(speed / 2, 180d);
					} else if (leftKey) {
						//stop the up motion
						setSpeed(0);
					}

					//soft block up movement
					canMoveLeft = false;
				}
			}

			//if player is at right of room
			if (rightEdge) {
				//if wall is right
				if (rightWall) {
					System.out.println("Right Edge");
					if (downKey && rightKey) {
						//go down if down is also pressed
						setMotion(speed / 2, 0d);
					} else if (upKey && rightKey) {
						//go up if up is also pressed
						setMotion(speed / 2, 180d);
					} else if (rightKey) {
						//stop the up motion
						setSpeed(0);
					}

					//soft block up movement
					canMoveRight = false;
				}
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
