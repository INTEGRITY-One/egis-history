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
public class Humidity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NonNull
	private int humid;
	
	@OneToMany(mappedBy="humidity")
	private List<CurrentConditions> measurements = new ArrayList<>();
	
	public Humidity() {
	}
	
	public Humidity(int humid) {
		this.humid = humid;
	}
	
	public Humidity from(Humidity humidity) {
		this.humid = humidity.humid;
		return this;
	}
	
	public int getHumid() {
		return this.humid;
	}
	
	public void setHumid(int humid) {
		this.humid = humid;
	}

}
