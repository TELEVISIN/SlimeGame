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

public class DeathScreen extends StaticScene {
	
	private SlimeGame slimeGame;
	
	public DeathScreen(SlimeGame slimeGame) {
		this.slimeGame = slimeGame;
	}

	@Override
	public void setupScene() {
	    setBackgroundImage("backgrounds/DeathScreen.png");
	}

	@Override
	public void setupEntities(){
		
		var screenText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 10 * 4), "You Dieded!");
		screenText.setFill(Color.YELLOW);
		screenText.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD, 45));
		screenText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		addEntity(screenText);
	    				
		addEntity(new ReplayButton(new Coordinate2D(getWidth() / 2, getHeight() / 10 * 6), slimeGame));
		addEntity(new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 10 * 7), slimeGame));
	    
	}
}
