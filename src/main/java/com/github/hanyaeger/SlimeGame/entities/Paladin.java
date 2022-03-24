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
		
	}

	@Override
	protected void setupEntities() {
		// TODO Auto-generated method stub
		addEntity(new PaladinSprite(new Coordinate2D(0, 0)));
	}
}
