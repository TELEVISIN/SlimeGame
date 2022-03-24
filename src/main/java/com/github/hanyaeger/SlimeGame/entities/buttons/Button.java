package com.github.hanyaeger.SlimeGame.entities.buttons;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;

import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;

public class Button extends TextEntity implements MouseButtonPressedListener,MouseEnterListener,MouseExitListener {
	
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

	@Override
	public void onMouseExited() {
	    setCursor(Cursor.DEFAULT);
	}

	@Override
	public void onMouseEntered() {
	    setCursor(Cursor.HAND);
	}

}
