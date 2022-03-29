package com.github.hanyaeger.SlimeGame.scenes;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.AttackSprite;
import com.github.hanyaeger.SlimeGame.entities.Paladin;
import com.github.hanyaeger.SlimeGame.entities.rooms.NormalRoom;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;

import javafx.scene.input.MouseButton;

public class GameLevel extends DynamicScene implements TileMapContainer, MouseButtonPressedListener {
	
	private SlimeGame slimeGame;
	private Paladin paladin;
	
	public GameLevel(SlimeGame slimeGame) {
		this.slimeGame = slimeGame;
	}

	@Override
	public void setupScene() {
		// TODO Auto-generated method stub
		paladin = new Paladin(new Coordinate2D(getWidth() / 2, getHeight() / 4), 
				slimeGame, 
				100, 
				1, 
				10, 
				0.7);
	}

	@Override
	public void setupEntities() {
		// TODO Auto-generated method stub
		addEntity(paladin);
	}
	
	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		// TODO Auto-generated method stub
		
		//LEFT MOUSE BUTTON for attacking
		if(button == MouseButton.PRIMARY) {
			paladin.Attack();
			addEntity(new AttackSprite(paladin.getAnchorLocation()));
			
		} 
		
		//RIGHT MOUSE BUTTON for blocking
		else if (button == MouseButton.SECONDARY) {
			paladin.Block();
		}
	}

	@Override
	public void setupTileMaps() {
		Room normalRoom = new NormalRoom(this);
		addTileMap(normalRoom);
	}
}
