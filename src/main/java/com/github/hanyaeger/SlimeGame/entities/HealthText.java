package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;

public class HealthText extends TextEntity {

	public HealthText(Coordinate2D initialLocation) {
		super(initialLocation);
		// TODO Auto-generated constructor stub
	}

	public void setHealthText(int health){
	    setText("Health: " + health);
	}

}
