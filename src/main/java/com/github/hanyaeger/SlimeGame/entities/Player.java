package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;

/*
 * 
 * @author Jasper
 * 
 */

public abstract class Player extends iLifeform implements KeyListener {
	final int BASE_HEALTH = 100;
	final double BASE_SPEED = 1.5;
	final double BASE_ATTACK_SPEED = 0.7;
	final double BASE_ATTACK_POWER = 10;
	
	int health = BASE_HEALTH;
	double speed = BASE_SPEED;
	double attackPower = BASE_ATTACK_POWER;
	double attackSpeed = BASE_ATTACK_SPEED;
	
	int experience;
	int level;
	SlimeGame slimeGame;
	
	public Player(Coordinate2D coordinate2d, SlimeGame slimeGame, int health, double speed, double attackPower, double atatckSpeed) {
		super(coordinate2d);
	}
	
	public void onPressedKeys(Set<KeyCode> pressedKeys) {
		if(pressedKeys.contains(KeyCode.LEFT)) {
			setMotion(3, 270d);
		} else if (pressedKeys.contains(KeyCode.RIGHT)) {
			setMotion(3, 90d);
		} else if (pressedKeys.contains(KeyCode.UP)) {
			setMotion(3, 180d);
		} else if (pressedKeys.contains(KeyCode.DOWN)) {
			setMotion(3, 0d);
		} else if (pressedKeys.isEmpty()) {
			setSpeed(0);
		}
		
		//onCollison
		//Attack
		//Move
		//updateHealth
		//updateExperience
		
	}
	
}
