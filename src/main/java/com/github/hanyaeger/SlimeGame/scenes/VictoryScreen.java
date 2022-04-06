package com.github.hanyaeger.SlimeGame.scenes;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.buttons.QuitButton;
import com.github.hanyaeger.SlimeGame.entities.buttons.ReplayButton;
import com.github.hanyaeger.SlimeGame.entities.buttons.StartButton;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VictoryScreen extends StaticScene {
	
	private SlimeGame slimeGame;
	
	public VictoryScreen(SlimeGame slimeGame) {
		this.slimeGame = slimeGame;
	}

	@Override
	public void setupScene() {
	    setBackgroundImage("backgrounds/VictoryScreen.png");
	}

	@Override
	public void setupEntities(){
	    
		addEntity(new ReplayButton(new Coordinate2D(getWidth() / 2, getHeight() / 10 * 6), slimeGame));
		addEntity(new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 10 * 7), slimeGame));
	    
	}
}
