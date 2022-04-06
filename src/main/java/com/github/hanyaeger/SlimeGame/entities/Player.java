package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Crate;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Door;
import com.github.hanyaeger.SlimeGame.entities.obstacles.Wall;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;


public abstract class Player extends iLifeform implements KeyListener {
	final static int BASE_HEALTH = 100;
	final double BASE_SPEED = 5;
	final int CORNER_CLIP_BUFFER = 1;

	double hitboxMultiplier = 0.8;
	int width = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;
	int height = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;
	
	private int health;
	double speed = BASE_SPEED;

	boolean leftKey;
	boolean upKey;
	boolean rightKey;
	boolean downKey;

	SlimeGame slimeGame;
	Room parentRoom;
	HealthText healthText;

	/**
	 * Constructor of Player. Creates an object of a player.
	 * @param coordinate2d
	 * @param slimeGame
	 * @param healthText
	 * @param parentRoom
	 */
	public Player(Coordinate2D coordinate2d, SlimeGame slimeGame, HealthText healthText, Room parentRoom) {
		super(coordinate2d);
		this.slimeGame = slimeGame;
		this.healthText = healthText;
		this.parentRoom = parentRoom;

		setHealth(BASE_HEALTH);
	}

	/**
	 * Handles the pressed key change events
	 * @param pressedKeys
	 */
	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		leftKey = pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A);
		upKey = pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.W);
		rightKey = pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D);
		downKey = pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S);

		Move();
		
		if (pressedKeys.contains(KeyCode.Q)) {
			changeHealth(-5);
		}
	}

	/**
	 * Sets the health of the player
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
		updateHealthText();
	}

	/**
	 * Changes the Health of the player
	 * @param healthLoss
	 */
	private void changeHealth(int healthLoss) {
		health += healthLoss;
		
		if (health <= 0) {
			slimeGame.setActiveScene(2);
		}
		
		updateHealthText();
	}

	/**
	 * Updates the health of the player
	 */
	private void updateHealthText() {
		healthText.setHealthText(health);
	}

	/**
	 * Handles the collision of the player
	 * @param collidingObject
	 */
	public void onCollision(Collider collidingObject) {
		//if colliding with door, open it on button press
		if (collidingObject instanceof Door) {
			//if doors are open generate new room
			if (parentRoom.doorsOpen) {
				gameLevel.setNewRoom();
			}
		}

		//if colliding with enemy, take damage
		if (collidingObject instanceof LifeformHitbox) {
			System.out.println("Enemy");
			changeHealth(-5);

		}

		//if colliding with wall or crate check wall collision
		if (collidingObject instanceof Wall || collidingObject instanceof Crate || collidingObject instanceof Door) {
			checkWallCollision(collidingObject);
		}
	}

	/**
	 * Checks for collision with the walls and enables, disables movement based on said collision
	 * @param collidingObject
	 */
	public void checkWallCollision(Collider collidingObject) {

		double wallX;
		double wallY;
		double wallSize = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;

		double playerHitboxSize = width * hitboxMultiplier;

		int boundryBuffer = SlimeGame.SPRITE_SIZE * SlimeGame.spriteScale;
		double windowHeight = this.getSceneHeight();
		double windowWidth = this.getSceneWidth();

		//instance is wall
		if (collidingObject instanceof Wall) {
			wallX = ((Wall) collidingObject).getAnchorLocation().getX();
			wallY = ((Wall) collidingObject).getAnchorLocation().getY();
		}
		//instance is Crate
		else if (collidingObject instanceof Crate){
			if (((Crate) collidingObject).isDestroyed) {
				//if crate is destroyed, cancel collision
				return;
			}

			wallX = ((Crate) collidingObject).getAnchorLocation().getX();
			wallY = ((Crate) collidingObject).getAnchorLocation().getY();
		}
		//instance is Door
		else
		{
			wallX = ((Door) collidingObject).getAnchorLocation().getX();
			wallY = ((Door) collidingObject).getAnchorLocation().getY();
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


	/**
	 * Signals an attack in the console.
	 */
	public void Attack() {}

	/**
	 * Signals an block in the console.
	 */
	public void Block() {}

	/**
	 * Handles movement for the player
	 */
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
}
