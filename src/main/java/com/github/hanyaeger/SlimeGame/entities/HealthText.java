package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;

public class HealthText extends TextEntity {

	/**
	 * Constructor of health text. Creates object of a health text.
	 * @param initialLocation
	 */
	public HealthText(Coordinate2D initialLocation) {
		super(initialLocation);
	}

	/**
	 * Sets the text for the health text.
	 * @param health
	 */
	public void setHealthText(int health){
	    setText("Health: " + health);
	}

}
