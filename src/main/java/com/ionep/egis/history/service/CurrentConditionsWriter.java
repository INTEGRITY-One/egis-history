package com.ionep.egis.history.service;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ionep.egis.current.domain.City;
import com.ionep.egis.current.domain.CloudConditions;
import com.ionep.egis.current.domain.CurrentConditions;
import com.ionep.egis.current.domain.DateDimension;
import com.ionep.egis.current.domain.Humidity;
import com.ionep.egis.current.domain.Precipitation;
import com.ionep.egis.current.domain.Pressure;
import com.ionep.egis.current.domain.Temperature;
import com.ionep.egis.current.domain.Wind;
import com.ionep.egis.history.repository.CityRepository;
import com.ionep.egis.history.repository.CloudConditionsRepository;
import com.ionep.egis.history.repository.CurrentConditionsRepository;
import com.ionep.egis.history.repository.DateDimensionRepository;
import com.ionep.egis.history.repository.HumidityRepository;
import com.ionep.egis.history.repository.PrecipitationRepository;
import com.ionep.egis.history.repository.PressureRepository;
import com.ionep.egis.history.repository.TemperatureRepository;
import com.ionep.egis.history.repository.WindRepository;

@Component
public class CurrentConditionsWriter {
	
	private static Log log = LogFactory.getLog(CurrentConditionsWriter.class);
	
	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CloudConditionsRepository cloudConditionsRepository;

	@Autowired
	private DateDimensionRepository dateRepository;

	@Autowired
	private HumidityRepository humidityRepository;

	@Autowired
	private PrecipitationRepository precipitationRepository;

	@Autowired
	private PressureRepository pressureRepository;

	@Autowired
	private TemperatureRepository temperatureRepository;

	@Autowired
	private WindRepository windRepository;

	@Autowired
	private CurrentConditionsRepository currentConditionsRepository;
	
	public boolean writeCurrentConditions(CurrentConditions currentConditions) {
		boolean success = true;
		DateDimension date = updateOrCreate(currentConditions.getDate());
		City city = updateOrCreate(currentConditions.getCity());
		CloudConditions cloudConditions = updateOrCreate(currentConditions.getCloudConditions());
		Humidity humidity = updateOrCreate(currentConditions.getHumidity());
		Precipitation precipitation = updateOrCreate(currentConditions.getPrecipitation());
		Pressure pressure = updateOrCreate(currentConditions.getPressure());
		Temperature temperature = updateOrCreate(currentConditions.getTemperature());
		Wind wind = updateOrCreate(currentConditions.getWind());
		CurrentConditions written = updateOrCreate(date, city, cloudConditions, humidity, precipitation, pressure, temperature, wind);
		success = written != null;
		return success;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	protected DateDimension updateOrCreate(DateDimension date) {
		log.info("date      : " + date.getDate());
		log.info("dayOfMonth: " + date.getDayOfMonth());
		log.info("dayOfWeek : " + date.getDayOfWeek());
		log.info("hour      : " + date.getHour());
		log.info("month     : " + date.getMonth());
		log.info("weekOfYear: " + date.getWeekOfYear());
		log.info("year      : " + date.getYear());
		Optional<DateDimension> found = this.dateRepository.findByDateAndHour(date.getDate(), date.getHour());
		if (found.isPresent()) {
			DateDimension copied = found.get().from(date);
			DateDimension updated = this.dateRepository.save(copied);
			return updated;
		}
		else {
			DateDimension created = this.dateRepository.save(date);
			return created;
		}
	}

	protected City updateOrCreate(City city) {
		Optional<City> found = this.cityRepository.findByName(city.getName());
		if (found.isPresent()) {
			City copied = found.get().from(city);
			City updated = this.cityRepository.save(copied);
			return updated;
		}
		else {
			City created = this.cityRepository.save(city);
			return created;
		}
	}

	protected CloudConditions updateOrCreate(CloudConditions cloudConditions) {
		Optional<CloudConditions> found = this.cloudConditionsRepository.findByCloudiness(cloudConditions.getCloudiness());
		if (found.isPresent()) {
			CloudConditions copied = found.get().from(cloudConditions);
			CloudConditions updated = this.cloudConditionsRepository.save(copied);
			return updated;
		}
		else {
			CloudConditions created = this.cloudConditionsRepository.save(cloudConditions);
			return created;
		}
	}

	protected Humidity updateOrCreate(Humidity humidity) {
		Optional<Humidity> found = this.humidityRepository.findByHumid(humidity.getHumid());
		if (found.isPresent()) {
			Humidity copied = found.get().from(humidity);
			Humidity updated = this.humidityRepository.save(copied);
			return updated;
		}
		else {
			Humidity created = this.humidityRepository.save(humidity);
			return created;
		}
	}

	protected Precipitation updateOrCreate(Precipitation precipitation) {
		Optional<Precipitation> found = this.precipitationRepository.findByPrecip(precipitation.getPrecip());
		if (found.isPresent()) {
			Precipitation copied = found.get().from(precipitation);
			Precipitation updated = this.precipitationRepository.save(copied);
			return updated;
		}
		else {
			Precipitation created = this.precipitationRepository.save(precipitation);
			return created;
		}
	}

	protected Pressure updateOrCreate(Pressure pressure) {
		Optional<Pressure> found = this.pressureRepository.findByPress(pressure.getPress());
		if (found.isPresent()) {
			Pressure copied = found.get().from(pressure);
			Pressure updated = this.pressureRepository.save(copied);
			return updated;
		}
		else {
			Pressure created = this.pressureRepository.save(pressure);
			return created;
		}
	}

	protected Temperature updateOrCreate(Temperature temperature) {
		Optional<Temperature> found = this.temperatureRepository.findByTemp(temperature.getTemp());
		if (found.isPresent()) {
			Temperature copied = found.get().from(temperature);
			Temperature updated = this.temperatureRepository.save(copied);
			return updated;
		}
		else {
			Temperature created = this.temperatureRepository.save(temperature);
			return created;
		}
	}

	protected Wind updateOrCreate(Wind wind) {
		Optional<Wind> found = this.windRepository.findByDirAndSpeed(wind.getDir(), wind.getSpeed());
		if (found.isPresent()) {
			Wind copied = found.get().from(wind);
			Wind updated = this.windRepository.save(copied);
			return updated;
		}
		else {
			Wind created = this.windRepository.save(wind);
			return created;
		}
	}

	protected CurrentConditions updateOrCreate(DateDimension date, City city, CloudConditions cloudConditions, Humidity humidity,
			Precipitation precipitation, Pressure pressure, Temperature temperature, Wind wind) {
		Optional<CurrentConditions> found = this.currentConditionsRepository.findByDateAndHourAndCityName(
				date.getDate(), date.getHour(), city.getName());
		if (found.isPresent()) {
			CurrentConditions copied = found.get();
			copied.setCity(city);
			copied.setCloudConditions(cloudConditions);
			copied.setDate(date);
			copied.setHumidity(humidity);
			copied.setPrecipitation(precipitation);
			copied.setPressure(pressure);
			copied.setTemperature(temperature);
			copied.setWind(wind);
			CurrentConditions updated = this.currentConditionsRepository.save(copied);
			return updated;
		}
		else {
			CurrentConditions fresh = new CurrentConditions();
			fresh.setCity(city);
			fresh.setCloudConditions(cloudConditions);
			fresh.setDate(date);
			fresh.setHumidity(humidity);
			fresh.setPrecipitation(precipitation);
			fresh.setPressure(pressure);
			fresh.setTemperature(temperature);
			fresh.setWind(wind);
			CurrentConditions created = this.currentConditionsRepository.save(fresh);
			return created;
		}
	}

}
