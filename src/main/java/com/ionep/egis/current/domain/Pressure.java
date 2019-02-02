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
public class Pressure {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	private int press;
	
	@OneToMany(mappedBy="pressure")
	private List<CurrentConditions> measurements = new ArrayList<>();
	
	public Pressure() {
	}
	
	public Pressure(int press) {
		this.press = press;
	}
	
	public Pressure from(Pressure pressure) {
		this.press = pressure.getPress();
		return this;
	}
	
	public int getPress() {
		return this.press;
	}
	
	public void setPress(int press) {
		this.press = press;
	}

}
