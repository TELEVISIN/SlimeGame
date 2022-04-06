package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;

public class PaladinSprite extends DynamicSpriteEntity implements KeyListener {

	public static int direction = 2; // 0 = up, 1 = right, 2 = down, 3 = left

	/**
	 * Constructor of PaladinSprite. Creates an object of a palading sprite.
	 * @param initialLocation
	 * @param size
	 */
	public PaladinSprite(Coordinate2D initialLocation, Size size) {
		super("sprites/LifeformSpriteSheet.png", initialLocation, size, 8, 8);
        setCurrentFrameIndex(32);
	}

	//handle spriet direction chance
	/**
	 * Handles the direction change of the paladin sprite
	 * @param pressedKeys
	 */
	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if(pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A)) {
	        setCurrentFrameIndex(48); //paladin facing left, 49th image
	        direction = 3;
		} else if (pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D)) {
	        setCurrentFrameIndex(40); //paladin facing right, 41th image
	        direction = 1;
		} else if (pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.W)) {
	        setCurrentFrameIndex(56); //paladin facing up, 56th image
	        direction = 0;
		} else if (pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S)) {
	        setCurrentFrameIndex(32); //paladin facing down, 33th image
	        direction = 2;
		}
	}

}
