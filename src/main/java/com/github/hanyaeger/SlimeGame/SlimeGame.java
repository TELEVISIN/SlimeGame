package com.github.hanyaeger.SlimeGame;

import com.github.hanyaeger.SlimeGame.scenes.GameLevel;
import com.github.hanyaeger.SlimeGame.scenes.StartScreen;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class SlimeGame extends YaegerGame{
	
	public static void main(String[] args){
	    launch(args);
	}

	@Override
	public void setupGame() {
	    setGameTitle("SlimeGame");
	    setSize(new Size(950, 650));
	}

	@Override
	public void setupScenes(){
	    addScene(0, new StartScreen(this));
	    addScene(1, new GameLevel(this));
	}
}
