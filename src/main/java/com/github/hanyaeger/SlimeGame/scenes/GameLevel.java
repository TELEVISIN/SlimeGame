package com.github.hanyaeger.SlimeGame.scenes;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.AttackSprite;
import com.github.hanyaeger.SlimeGame.entities.AttackTimer;
import com.github.hanyaeger.SlimeGame.entities.HealthText;
import com.github.hanyaeger.SlimeGame.entities.Paladin;
import com.github.hanyaeger.SlimeGame.entities.PaladinSprite;
import com.github.hanyaeger.SlimeGame.entities.Player;
import com.github.hanyaeger.SlimeGame.entities.SmallSlime;
import com.github.hanyaeger.SlimeGame.entities.rooms.NormalRoom;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import spawners.SlimeSpawner;

import java.util.Set;

public class GameLevel extends DynamicScene implements TileMapContainer, MouseButtonPressedListener, KeyListener, TimerContainer, EntitySpawnerContainer {
    
    private SlimeGame slimeGame;
    private Paladin paladin;
    private Coordinate2D attackLocation;
    
    private Timer timer;

    protected Room normalRoom;
    
    public GameLevel(SlimeGame slimeGame) {
        this.slimeGame = slimeGame;
    }

	@Override
	public void setupScene() {
		// TODO Auto-generated method stub
		setBackgroundAudio("audio/Algar Euphoria Green Flower Loopable.mp3");

        //generate the room first time
        generateRoom();
	}

    @Override
    public void setupEntities() {
        // TODO Auto-generated method stub
        
		var healthText = new HealthText(
		        new Coordinate2D(getWidth() / 2, getHeight() - 75)
		    );
		healthText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		healthText.setFill(Color.RED);
		healthText.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
		healthText.setHealthText(Player.health);
	
		paladin = new Paladin(new Coordinate2D(getWidth() / 2, getHeight() / 2), // Coordinate2D coordinate2d
				slimeGame, // SlimeGame slimeGame
				healthText,
				100, // int health
				1, // double speed
				10, // double attackPower
				0.7); // double attackSpeed
		
		var smallSlime = new SmallSlime(new Coordinate2D(getWidth() / 3, getHeight() / 4),
				slimeGame, normalRoom);
	
	    addEntity(healthText);
    	    	
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
        	switch (PaladinSprite.direction) {
        		case 0:
        			attackLocation = new Coordinate2D(-64, -128);
        			break;
        		case 1:
        			attackLocation = new Coordinate2D(0, -64);
        			break;
        		case 2:
        			attackLocation = new Coordinate2D(-64, 0);
        			break;
        		case 3:
        			attackLocation = new Coordinate2D(-128, -64);
        			break;
        		default:
        			break;	
        	}
        	attackLocation = attackLocation.add(paladin.getAnchorLocation());
            addEntity(new AttackSprite(attackLocation));
        } 
        
        //RIGHT MOUSE BUTTON for blocking
        else if (button == MouseButton.SECONDARY) {
            paladin.Block();
            normalRoom.print();
        }
    }


    //handle map
    @Override
    public void setupTileMaps() {
        addTileMap(normalRoom);
    }

    //generate a new room
    public void generateRoom()
    {
        normalRoom = new NormalRoom(this);
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

	@Override
	public void setupEntitySpawners() {
		// TODO Auto-generated method stub
		addEntitySpawner(new SlimeSpawner(getWidth(), getHeight(), normalRoom));
	}
}