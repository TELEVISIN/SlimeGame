package com.github.hanyaeger.SlimeGame.scenes;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.buttons.StartButton;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;


public class StartScreen extends StaticScene {
	
	private SlimeGame slimeGame;

	/**
	 * Constructor of startScreen. Creates an object of the start screen.
	 * @param slimeGame
	 */
	public StartScreen(SlimeGame slimeGame) {
		this.slimeGame = slimeGame;
	}

	/**
	 * Setup method for the scene
	 */
	@Override
	public void setupScene() {
	    setBackgroundImage("backgrounds/TitleScreen.png");
	}

	/**
	 * Sets up th entities used by the start screen
	 */
	@Override
	public void setupEntities(){
	    
	    addEntity(new StartButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.9), slimeGame));
	}
}
