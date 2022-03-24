package com.github.hanyaeger.SlimeGame.entities.buttons;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;

import javafx.scene.input.MouseButton;

public class Button extends TextEntity implements MouseButtonPressedListener {
	
	protected SlimeGame slimeGame;

	public Button(Coordinate2D initialLocation, SlimeGame slimeGame, String buttonText) {
		super(initialLocation, buttonText);
		setAnchorPoint(AnchorPoint.CENTER_CENTER);
		this.slimeGame = slimeGame;
	}

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		// TODO Auto-generated method stub
		
	}

}
