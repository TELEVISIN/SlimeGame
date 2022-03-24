package com.github.hanyaeger.SlimeGame;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class SlimeGame extends YaegerGame{
	
	public static void main(String[] args){
	    launch(args);
	}

	@Override
	public void setupGame() {
	    setGameTitle("SlimeGame");
	    setSize(new Size(1000, 750));
	}

	@Override
	public void setupScenes() {
		// TODO Auto-generated method stub
		
	}
}
