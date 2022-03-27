package com.github.hanyaeger.SlimeGame.entities.buttons;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartButton extends Button {

	public StartButton(Coordinate2D initialLocation, SlimeGame slimeGame) {
		super(initialLocation, slimeGame, "Play game");
	    setFill(Color.YELLOW);
	    //setFont(Font.font("Roboto", FontWeight.BOLD, 30));
		setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD, 30));
	}

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		slimeGame.setActiveScene(1);
	}

	@Override
	public void onMouseExited() {
	    setFill(Color.YELLOW);
	    super.onMouseExited();
	}

	@Override
	public void onMouseEntered() {
	    setFill(Color.RED);
	    super.onMouseEntered();
	}

}
