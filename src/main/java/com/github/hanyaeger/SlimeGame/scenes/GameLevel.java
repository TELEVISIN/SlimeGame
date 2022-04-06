package com.github.hanyaeger.SlimeGame.scenes;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.AttackSprite;
import com.github.hanyaeger.SlimeGame.entities.AttackTimer;
import com.github.hanyaeger.SlimeGame.entities.HealthText;
import com.github.hanyaeger.SlimeGame.entities.Paladin;
import com.github.hanyaeger.SlimeGame.entities.PaladinSprite;
import com.github.hanyaeger.SlimeGame.entities.SlimeKing;
import com.github.hanyaeger.SlimeGame.entities.SmallSlime;
import com.github.hanyaeger.SlimeGame.entities.rooms.BossRoom;
import com.github.hanyaeger.SlimeGame.entities.rooms.NormalRoom;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
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

import java.util.Random;
import java.util.Set;

public class GameLevel extends DynamicScene implements TileMapContainer, MouseButtonPressedListener, KeyListener, TimerContainer, EntitySpawnerContainer {
    
    private SlimeGame slimeGame;
    private Paladin paladin;
    private Coordinate2D attackLocation;

	private SlimeKing slimeKing;
	private int slimeKingChanceThreshold = 20;
	private Random random = new Random();
	private int slimeKingChance;
	private boolean bossTime = false;
    
    private Timer timer;

    public Room room;

	/**
	 * Constructor of GameLevel. Creates an object of the game level.
	 * @param slimeGame
	 */
	public GameLevel(SlimeGame slimeGame) {
        this.slimeGame = slimeGame;
    }

	/**
	 * Setup method for the scene
	 */
	@Override
	public void setupScene() {
		slimeGame.setHasWon(false);
		setBackgroundAudio("audio/Algar Euphoria Green Flower Loopable.mp3");

		checkBossTime();

		//generate the room
		generateRoom();
	}

	/**
	 * Sets up the entities for the scene
	 */
    @Override
    public void setupEntities() {
		var healthText = new HealthText(
		        new Coordinate2D(getWidth() / 2, getHeight() - 75)
		    );
		healthText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		healthText.setFill(Color.RED);
		healthText.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
	
		paladin = new Paladin(new Coordinate2D(getWidth() / 2, getHeight() / 2), // Coordinate2D coordinate2d
				slimeGame, // SlimeGame slimeGame
				healthText,
				room,
				this);

		
		var smallSlime = new SmallSlime(new Coordinate2D(getWidth() / 3, getHeight() / 4),
				slimeGame, room);
	
	    addEntity(healthText);
    	    	
        addEntity(paladin);

		if (bossTime) {
			addSlimeKing();
		}
    }

	/**
	 * Adds the slime king to the scene.
	 */
	private void addSlimeKing()
	{
		//spawn slime king
		slimeKing = new SlimeKing(new Coordinate2D(512, 128), slimeGame, room);
		addEntity(slimeKing);
	}

	/**
	 * Checks if it's time for the boss.
	 */
	private void checkBossTime()
	{
		//check if it is time for the boss
		slimeKingChance = random.nextInt(100);
		System.out.println(slimeKingChance);

		//spawn slime king on chance
		if (slimeKingChance <= slimeKingChanceThreshold) {
			bossTime = true;
			System.out.println("KING SLIME APPROACHES");
		}
	}

	/**
	 * Handles mouse pressed events of the gamelevel.
	 * @param button
	 * @param coordinate2d
	 */
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
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
        }
    }


    //handle map
	/**
	 * Sets up the tilemaps used by this room
	 */
    @Override
    public void setupTileMaps() {
        addTileMap(room);
    }

    //generate a new room
	/**
	 * Generates a new room
	 */
    public void generateRoom()
    {
		if (!bossTime) {
			//random room
			room = new NormalRoom(this);
		}
		else
		{
			room = new BossRoom(this);
		}
    }

	//set a new room for the level

	/**
	 * Sets the scene again to update the room
	 */
	public void setNewRoom()
	{
		//clear the level and run setup entities again
		slimeGame.setActiveScene(1);
	}

	/**
	 * Handles key pressed events for gamelevel
	 * @param pressedKeys
	 */
    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        boolean escapePressed = pressedKeys.contains(KeyCode.ESCAPE);

        //if escape key is pressed, go to titlescreen
        if (escapePressed)
        {
            slimeGame.setActiveScene(0);
        }
    }

	/**
	 * Sets up the timers used by the game level
	 */
	@Override
	public void setupTimers() {
		//timer in ms
		timer = new AttackTimer(1000);
		addTimer(timer);
	}

	/**
	 * Sets up the entity Spawners used by the game level
	 */
	@Override
	public void setupEntitySpawners() {
		addEntitySpawner(new SlimeSpawner(getWidth(), getHeight(), room));
	}
}