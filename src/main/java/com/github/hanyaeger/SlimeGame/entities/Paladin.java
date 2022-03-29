package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class Paladin extends Player {
	public Paladin(Coordinate2D coordinate2d, SlimeGame slimeGame, int health, double speed, double attackPower, double attackSpeed) {
		super(coordinate2d, slimeGame, health, speed, attackPower, attackSpeed);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		// TODO Auto-generated method stub
		boolean leftKey = pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A);
		boolean upKey = pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.W);
		boolean rightKey = pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D);
		boolean downKey = pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S);
		
		
		//diagonal movement
		if(leftKey && upKey) {
			setMotion(10, 225d);
		} else if (upKey && rightKey) {
			setMotion(10, 135d);
		} else if (rightKey && downKey) {
			setMotion(10, 45d);
		} else if (downKey && leftKey) {
			setMotion(10, 315d);
		}
		//horizontal and vertical movement
		else if(leftKey) {
			setMotion(10, 270d);
		} else if (rightKey) {
			setMotion(10, 90d);
		} else if (upKey) {
			setMotion(10, 180d);
		} else if (downKey) {
			setMotion(10, 0d);
		} 
		
		//stand still
		else if (pressedKeys.isEmpty()) {
			setSpeed(0);
		}
	}

	@Override
	protected void setupEntities() {
		// TODO Auto-generated method stub
		addEntity(new PaladinSprite(new Coordinate2D(0, 0)));
	}
	
	@Override
	public void Attack() {
		System.out.println("Attack!");
	}
	
	public void Block() {
		System.out.println("Block!");
	}
}
