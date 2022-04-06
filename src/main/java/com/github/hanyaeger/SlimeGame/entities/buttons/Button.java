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

	/**
	 * Creates a button
	 * @param initialLocation
	 * @param slimeGame
	 * @param buttonText
	 */
	public Button(Coordinate2D initialLocation, SlimeGame slimeGame, String buttonText) {
		super(initialLocation, buttonText);
		setAnchorPoint(AnchorPoint.CENTER_CENTER);
		this.slimeGame = slimeGame;
	}

	/**
	 * Handles the mouse button pressed events
	 * @param button
	 * @param coordinate2d
	 */
	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
	}

	/**
	 * Handles the mouse exit event
	 */
	@Override
	public void onMouseExited() {
	    setCursor(Cursor.DEFAULT);
	}

	/**
	 * Handles the mouse enter event
	 */
	@Override
	public void onMouseEntered() {
	    setCursor(Cursor.HAND);
	}

}
