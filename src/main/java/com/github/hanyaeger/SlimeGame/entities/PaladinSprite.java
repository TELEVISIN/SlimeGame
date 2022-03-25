package com.github.hanyaeger.SlimeGame.entities;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;

public class PaladinSprite extends DynamicSpriteEntity implements KeyListener {

	public PaladinSprite(Coordinate2D initialLocation) {
		super("sprites/LifeformSpriteSheet.png", initialLocation, new Size(32, 32), 8, 8);
        setCurrentFrameIndex(0);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if(pressedKeys.contains(KeyCode.LEFT)) {
	        setCurrentFrameIndex(16);
		} else if (pressedKeys.contains(KeyCode.RIGHT)) {
	        setCurrentFrameIndex(8);
		} else if (pressedKeys.contains(KeyCode.UP)) {
	        setCurrentFrameIndex(24);
		} else if (pressedKeys.contains(KeyCode.DOWN)) {
	        setCurrentFrameIndex(0);
		}
	}

}
