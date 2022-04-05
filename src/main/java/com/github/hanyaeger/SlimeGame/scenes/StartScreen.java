package com.github.hanyaeger.SlimeGame.scenes;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.buttons.StartButton;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartScreen extends StaticScene {
	
	private SlimeGame slimeGame;
	
	public StartScreen(SlimeGame slimeGame) {
		this.slimeGame = slimeGame;
	}

	@Override
	public void setupScene() {
	    setBackgroundImage("sprites/TitleScreen.png");
	}

	@Override
	public void setupEntities(){
	    
	    addEntity(new StartButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.9), slimeGame));
	}
}
