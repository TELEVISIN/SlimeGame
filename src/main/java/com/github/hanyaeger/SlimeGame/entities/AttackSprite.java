package com.github.hanyaeger.SlimeGame.entities;

import java.time.Instant;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;

import javafx.scene.input.MouseButton;

public class AttackSprite extends DynamicSpriteEntity implements MouseButtonPressedListener, Collider, UpdateExposer {

	private long createdTimestamp;
	private long attackTimer = 100000000;
	public int attackPower = 1;
	
	public AttackSprite(Coordinate2D initialLocation) {
		super("sprites/LifeformSpriteSheet.png", initialLocation, new Size(128, 128), 8, 8);
		switch(PaladinSprite.direction) {
	    	case 0:
	    		setCurrentFrameIndex(27); //up
	    		break;
	    	case 1:
	    		setCurrentFrameIndex(11); //right
	    		break;
	    	case 2:
	    		setCurrentFrameIndex(3); //down
	    		break;
	    	case 3:
	    		setCurrentFrameIndex(19); //left
	    		break;
	    	default:
	    		break;
	    }
	}

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void explicitUpdate(long timestamp) {
		// TODO Auto-generated method stub
		if(createdTimestamp == 0) {
			createdTimestamp = timestamp;
		}

		if(timestamp > createdTimestamp + attackTimer) {
			remove();
		}
	}
}
