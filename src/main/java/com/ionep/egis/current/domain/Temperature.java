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
public class Temperature {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	private int temp;
	
	@OneToMany(mappedBy="temperature")
	private List<CurrentConditions> measurements = new ArrayList<>();
	
	public Temperature() {
	}
	
	public Temperature(int temp) {
		this.temp = temp;
	}
	
	public Temperature from(Temperature temperature) {
		this.temp = temperature.temp;
		return this;
	}
	
	public int getTemp() {
		return this.temp;
	}
	
	public void setTemp(int temp) {
		this.temp = temp;
	}

}
