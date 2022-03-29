package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class PaladinSprite extends DynamicSpriteEntity implements KeyListener {

	
	public static int direction = 2; // 0 = up, 1 = right, 2 = down, 3 = left
	public PaladinSprite(Coordinate2D initialLocation) {
		super("sprites/LifeformSpriteSheet.png", initialLocation, new Size(64, 64), 8, 8);
        setCurrentFrameIndex(0);
	}

	//handle paladin movement
	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if(pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A)) {
	        setCurrentFrameIndex(16); //paladin facing left, 17th image
	        direction = 3;
		} else if (pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D)) {
	        setCurrentFrameIndex(8); //paladin facing right, 9th image
	        direction = 1;
		} else if (pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.W)) {
	        setCurrentFrameIndex(24); //paladin facing up, 25th image
	        direction = 0;
		} else if (pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S)) {
	        setCurrentFrameIndex(0); //paladin facing down, first item
	        direction = 2;
		}
	}

}
