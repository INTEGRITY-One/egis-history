package com.ionep.egis.current.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(schema="EGIS_WEATHER")
public class Wind {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
//	private WindDirection direction;
	@NonNull
	private int dir;
	
	@NonNull
	private int speed;
	
//	public WindDirection getDirection() {
//		return this.direction;
//	}
//	
//	public void setDirection(WindDirection direction) {
//		this.direction = direction;
//	}
//	
	@OneToMany(mappedBy="wind")
	private List<CurrentConditions> measurements = new ArrayList<>();
	
	public Wind() {
	}
	
	public Wind(int dir, int speed) {
		this.dir = dir;
		this.speed = speed;
	}
	
	public Wind from(Wind wind) {
		this.dir = wind.dir;
		this.speed = wind.speed;
		return this;
	}
	
	public int getDir() {
		return this.dir;
	}
	
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
