package com.ionep.egis.current.domain;

import lombok.Data;

@Data
public class CurrentConditions {
	
	private Temperature temperature;

	private Precipitation precipitation;
	
	private Humidity humidity;
	
	private Cloudiness cloudiness;
	
	private Wind wind;
	
	private Pressure pressure;

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

	public Cloudiness getCloudiness() {
		return this.cloudiness;
	}

	public void setCloudiness(Cloudiness cloudiness) {
		this.cloudiness = cloudiness;
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
	
}
