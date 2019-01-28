package com.ionep.egis.current.domain;

public class Wind {
	
	private WindDirection direction;
	
	private int speed;
	
	public WindDirection getDirection() {
		return this.direction;
	}
	
	public void setDirection(WindDirection direction) {
		this.direction = direction;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
