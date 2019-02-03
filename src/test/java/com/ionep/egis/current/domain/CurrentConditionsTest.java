package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CurrentConditionsTest {
	
	@Test
	public void constructor() throws Exception {
		CurrentConditions conditions = new CurrentConditions();
		assertNotNull(conditions);
	}
	
	@Test
	public void allFields() throws Exception {
		Temperature temperature = new Temperature();
		temperature.setTemp(72);
		Precipitation precipitation = new Precipitation();
		precipitation.setPrecip(2);
		Humidity humidity = new Humidity();
		humidity.setHumid(30);
		Cloudiness cloudiness = Cloudiness.CLEAR;
		CloudConditions cloudConditions = new CloudConditions();
		cloudConditions.setCloudiness(cloudiness.ordinal());
		Wind wind = new Wind();
		wind.setDir(WindDirection.EAST.ordinal());
		wind.setSpeed(5);
		Pressure pressure = new Pressure();
		pressure.setPress(30);
		CurrentConditions conditions = new CurrentConditions();
		conditions.setTemperature(temperature);
		conditions.setPrecipitation(precipitation);
		conditions.setHumidity(humidity);
		conditions.setCloudConditions(cloudConditions);
		conditions.setWind(wind);
		conditions.setPressure(pressure);
		assertEquals(temperature, conditions.getTemperature());
		assertEquals(precipitation, conditions.getPrecipitation());
		assertEquals(humidity, conditions.getHumidity());
		assertEquals(cloudConditions, conditions.getCloudConditions());
		assertEquals(wind, conditions.getWind());
		assertEquals(pressure, conditions.getPressure());
	}

	@Test
	public void from() throws Exception {
		Temperature temperature = new Temperature();
		temperature.setTemp(72);
		Precipitation precipitation = new Precipitation();
		precipitation.setPrecip(2);
		Humidity humidity = new Humidity();
		humidity.setHumid(30);
		Cloudiness cloudiness = Cloudiness.CLEAR;
		CloudConditions cloudConditions = new CloudConditions();
		cloudConditions.setCloudiness(cloudiness.ordinal());
		Wind wind = new Wind();
		wind.setDir(WindDirection.EAST.ordinal());
		wind.setSpeed(5);
		Pressure pressure = new Pressure();
		pressure.setPress(30);
		CurrentConditions conditions = new CurrentConditions();
		conditions.setTemperature(temperature);
		conditions.setPrecipitation(precipitation);
		conditions.setHumidity(humidity);
		conditions.setCloudConditions(cloudConditions);
		conditions.setWind(wind);
		conditions.setPressure(pressure);

		Temperature temp2 = new Temperature();
		temp2.setTemp(32);
		Precipitation precip2 = new Precipitation();
		precip2.setPrecip(1);
		Humidity humid2 = new Humidity();
		humid2.setHumid(70);
		cloudiness = Cloudiness.CLOUDY;
		CloudConditions cc2 = new CloudConditions();
		cc2.setCloudiness(cloudiness.ordinal());
		Wind wind2 = new Wind();
		wind2.setDir(WindDirection.WEST.ordinal());
		wind2.setSpeed(10);
		Pressure press2 = new Pressure();
		press2.setPress(28);
		CurrentConditions copy = new CurrentConditions();
		copy.setTemperature(temp2);
		copy.setPrecipitation(precip2);
		copy.setHumidity(humid2);
		copy.setCloudConditions(cc2);
		copy.setWind(wind2);
		copy.setPressure(press2);

		assertEquals(temp2, copy.getTemperature());
		assertEquals(precip2, copy.getPrecipitation());
		assertEquals(humid2, copy.getHumidity());
		assertEquals(cc2, copy.getCloudConditions());
		assertEquals(wind2, copy.getWind());
		assertEquals(press2, copy.getPressure());
		
		copy.from(conditions);
		
		assertEquals(temperature, copy.getTemperature());
		assertEquals(precipitation, copy.getPrecipitation());
		assertEquals(humidity, copy.getHumidity());
		assertEquals(cloudConditions, copy.getCloudConditions());
		assertEquals(wind, copy.getWind());
		assertEquals(pressure, copy.getPressure());
	}

}
