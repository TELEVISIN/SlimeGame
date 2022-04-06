package com.github.hanyaeger.SlimeGame.entities.buttons;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuitButton extends Button {

	/**
	 * Constructor of the quit button. Creates an object of the quit button
	 * @param initialLocation
	 * @param slimeGame
	 */
	public QuitButton(Coordinate2D initialLocation, SlimeGame slimeGame) {
		super(initialLocation, slimeGame, "Quit game");
	    setFill(Color.YELLOW);
		setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD, 30));
	}

	/**
	 * Handles mouse pressed events
	 * @param button
	 * @param coordinate2d
	 */
	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		slimeGame.quit();
	}

	/**
	 * Handles mouse exit event
	 */
	@Override
	public void onMouseExited() {
	    setFill(Color.YELLOW);
	    super.onMouseExited();
	}

	/**
	 * Handles mouse enter event
	 */
	@Override
	public void onMouseEntered() {
	    setFill(Color.RED);
	    super.onMouseEntered();
	}

}
