package com.github.hanyaeger.SlimeGame.entities;

import com.github.hanyaeger.api.Timer;

public class AttackTimer extends Timer {

	/**
	 * Constructor of attack timer. Creates object of the attack timer.
	 * @param intervalInMs
	 */
	public AttackTimer(long intervalInMs) {
		super(intervalInMs);
	}

	/**
	 * Create the timestamp for the timer.
	 * @param timestamp
	 */
	@Override
	public void onAnimationUpdate(long timestamp) {
	}

}
