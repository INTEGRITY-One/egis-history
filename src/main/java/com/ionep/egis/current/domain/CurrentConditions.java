package com.ionep.egis.current.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(schema="EGIS_WEATHER")
public class CurrentConditions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="TEMPERATURE_ID")
	private Temperature temperature;

	@NonNull
	@ManyToOne
	@JoinColumn(name="PRECIPITATION_ID")
	private Precipitation precipitation;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="HUMIDITY_ID")
	private Humidity humidity;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="CLOUD_CONDITIONS_ID")
	private CloudConditions cloudConditions;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="WIND_ID")
	private Wind wind;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="PRESSURE_ID")
	private Pressure pressure;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private City city;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="DATE_ID")
	private DateDimension date;
	
	public CurrentConditions() {
	}
	
	public CurrentConditions from(CurrentConditions currentConditions) {
		this.city = currentConditions.city;
		this.cloudConditions = currentConditions.cloudConditions;
		this.date = currentConditions.date;
		this.humidity = currentConditions.humidity;
		this.precipitation = currentConditions.precipitation;
		this.pressure = currentConditions.pressure;
		this.temperature = currentConditions.temperature;
		this.wind = currentConditions.wind;
		return this;
	}

	public Temperature getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public Precipitation getPrecipitation() {
		return this.precipitation;
	}

	public void setPrecipitation(Precipitation precipitation) {
		this.precipitation = precipitation;
	}

	public Humidity getHumidity() {
		return this.humidity;
	}

	public void setHumidity(Humidity humidity) {
		this.humidity = humidity;
	}

	public CloudConditions getCloudConditions() {
		return this.cloudConditions;
	}
	
	public void setCloudConditions(CloudConditions cloudConditions) {
		this.cloudConditions = cloudConditions;
	}

	public Wind getWind() {
		return this.wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Pressure getPressure() {
		return this.pressure;
	}

	public void setPressure(Pressure pressure) {
		this.pressure = pressure;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public DateDimension getDate() {
		return this.date;
	}

	public void setDate(DateDimension date) {
		this.date = date;
	}

}
