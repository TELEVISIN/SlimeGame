package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.input.KeyCode;

public class Paladin extends Player {
	public Paladin(Coordinate2D coordinate2d, SlimeGame slimeGame, int health, double speed, double attackPower, double attackSpeed) {
		super(coordinate2d, slimeGame, health, speed, attackPower, attackSpeed);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		// TODO Auto-generated method stub
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
	}

	@Override
	protected void setupEntities() {
		// TODO Auto-generated method stub
		addEntity(new PaladinSprite(new Coordinate2D(0, 0)));
	}
}
