package com.github.hanyaeger.SlimeGame.scenes;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.Paladin;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene {
	
	private SlimeGame slimeGame;
	
	public GameLevel(SlimeGame slimeGame) {
		this.slimeGame = slimeGame;
	}

	@Override
	public void setupScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupEntities() {
		// TODO Auto-generated method stub
		addEntity(new Paladin(new Coordinate2D(getWidth() / 2, getHeight() / 4), 
								slimeGame, 
								100, 
								1, 
								10, 
								0.7));
	}

}
