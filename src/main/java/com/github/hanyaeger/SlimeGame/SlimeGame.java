package com.github.hanyaeger.SlimeGame;

import com.github.hanyaeger.SlimeGame.scenes.EndScreen;
import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.SlimeGame.scenes.StartScreen;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class SlimeGame extends YaegerGame{
	
	public static final int SPRITE_SIZE = 32;

	public static int roomTileColumns = 19; // default 19
	public static int roomTileRows = 11; // default 11
	public static int spriteScale = 2; // default 2
	
	private boolean hasWon = false;
	
	public static void main(String[] args){
	    launch(args);
	}

	@Override
	public void setupGame() {
	    setGameTitle("Tomb Of The Slime King");

	    int SlimeGameWidth = roomTileColumns * spriteScale * SPRITE_SIZE;
	    int SlimeGameHeight = roomTileRows * spriteScale * SPRITE_SIZE;
	    setSize(new Size(SlimeGameWidth, SlimeGameHeight));
	}

	@Override
	public void setupScenes(){
	    addScene(0, new StartScreen(this));
	    addScene(1, new GameLevel(this));
	    addScene(2, new EndScreen(this));
	}
	
	public void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}
	
	public boolean getHasWon() {
		return hasWon;
	}
}
