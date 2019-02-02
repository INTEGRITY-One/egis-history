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
public class Precipitation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	private int precip;
	
	@OneToMany(mappedBy="precipitation")
	private List<CurrentConditions> measurements = new ArrayList<>();
	
	public Precipitation() {
	}
	
	public Precipitation(int precip) {
		this.precip = precip;
	}
	
	public Precipitation from(Precipitation precipitation) {
		this.precip = precipitation.precip;
		return this;
	}

	public void setPrecip(int precip) {
		this.precip = precip;
	}
	
	public int getPrecip() {
		return this.precip;
	}

}
