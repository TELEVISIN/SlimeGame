package com.github.hanyaeger.SlimeGame.scenes;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.AttackSprite;
import com.github.hanyaeger.SlimeGame.entities.AttackTimer;
import com.github.hanyaeger.SlimeGame.entities.Paladin;
import com.github.hanyaeger.SlimeGame.entities.PaladinSprite;
import com.github.hanyaeger.SlimeGame.entities.rooms.NormalRoom;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.Set;

public class GameLevel extends DynamicScene implements TileMapContainer, MouseButtonPressedListener, KeyListener, TimerContainer {
    
    private SlimeGame slimeGame;
    private Paladin paladin;
    private AttackSprite attackSprite;
    private Timer timer;
    
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
            //execute the attack
        	paladin.Attack();
            
            //create attackSprite
            addEntity(new AttackSprite(paladin.getAnchorLocation()));
        } 
        
        //RIGHT MOUSE BUTTON for blocking
        else if (button == MouseButton.SECONDARY) {
            paladin.Block();
        }
    }

    
    
    
    //handle map
    @Override
    public void setupTileMaps() {
        Room normalRoom = new NormalRoom(this);
        addTileMap(normalRoom);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        boolean escapePressed = pressedKeys.contains(KeyCode.ESCAPE);

        //if escape key is pressed, go to titlescreen
        if (escapePressed)
        {
            slimeGame.setActiveScene(0);
        }
    }

	@Override
	public void setupTimers() {
		// TODO Auto-generated method stub
		
		//timer in ms
		timer = new AttackTimer(1000);
		addTimer(timer);
	}
}