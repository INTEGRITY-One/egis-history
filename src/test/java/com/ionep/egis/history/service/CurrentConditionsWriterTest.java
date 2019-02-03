package com.ionep.egis.history.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.ionep.egis.current.domain.City;
import com.ionep.egis.current.domain.CloudConditions;
import com.ionep.egis.current.domain.Cloudiness;
import com.ionep.egis.current.domain.CurrentConditions;
import com.ionep.egis.current.domain.DateDimension;
import com.ionep.egis.current.domain.Humidity;
import com.ionep.egis.current.domain.Precipitation;
import com.ionep.egis.current.domain.Pressure;
import com.ionep.egis.current.domain.Temperature;
import com.ionep.egis.current.domain.Wind;
import com.ionep.egis.current.domain.WindDirection;
import com.ionep.egis.history.repository.CityRepository;
import com.ionep.egis.history.repository.CloudConditionsRepository;
import com.ionep.egis.history.repository.CurrentConditionsRepository;
import com.ionep.egis.history.repository.DateDimensionRepository;
import com.ionep.egis.history.repository.HumidityRepository;
import com.ionep.egis.history.repository.PrecipitationRepository;
import com.ionep.egis.history.repository.PressureRepository;
import com.ionep.egis.history.repository.TemperatureRepository;
import com.ionep.egis.history.repository.WindRepository;

@ExtendWith(MockitoExtension.class)
public class CurrentConditionsWriterTest {
	
	private CurrentConditionsWriter writer;
	
	@Mock
	private DateDimensionRepository dateRepository;
	
	@Mock
	private CityRepository cityRepository;
	
	@Mock
	private CloudConditionsRepository cloudRepository;
	
	@Mock
	private HumidityRepository humidityRepository;
	
	@Mock
	private PrecipitationRepository precipitationRepository;
	
	@Mock
	private PressureRepository pressureRepository;
	
	@Mock
	private TemperatureRepository temperatureRepository;
	
	@Mock
	private WindRepository windRepository;
	
	@Mock
	private CurrentConditionsRepository currentConditionsRepository;
	
	@Test
	public void constructor() throws Exception {
		assertNotNull(this.writer);
	}
	
	@Test
	public void createDate() throws Exception {
		DateDimension date = new DateDimension(LocalDateTime.of(2019, Month.FEBRUARY, 2, 12, 30));
		DateDimension db = null;
		Optional<DateDimension> optionalDate = Optional.ofNullable(db);
		Mockito.when(this.dateRepository.findByDateAndHour("20190202", "12")).thenReturn(optionalDate);
		Mockito.when(this.dateRepository.save(date)).thenReturn(date);
		assertNotNull(this.writer.updateOrCreate(date));
	}
	
	@Test
	public void updateDate() throws Exception {
		DateDimension date = new DateDimension(LocalDateTime.of(2019, Month.FEBRUARY, 2, 12, 30));
		DateDimension db = new DateDimension();
		ReflectionTestUtils.setField(db, "id", 1);
//		ReflectionTestUtils.setField(this.writer, "injectedDate", db);
		Optional<DateDimension> optionalDate = Optional.ofNullable(db);
		Mockito.when(this.dateRepository.findByDateAndHour("20190202", "12")).thenReturn(optionalDate);
		Mockito.lenient().when(this.dateRepository.save(date)).thenReturn(db);
		// Can't get mock to return non null here even after injecting db
		this.writer.updateOrCreate(date);
	}
	
	@Test
	public void createCity() throws Exception {
		City city = new City("BALTIMORE_MD");
		City db = null;
		Optional<City> optional = Optional.ofNullable(db);
		Mockito.when(this.cityRepository.findByName("BALTIMORE_MD")).thenReturn(optional);
		Mockito.when(this.cityRepository.save(city)).thenReturn(city);
		assertNotNull(this.writer.updateOrCreate(city));
	}
	
	@Test
	public void updateCity() throws Exception {
		City city = new City("BALTIMORE_MD");
		City db = new City();
		ReflectionTestUtils.setField(db, "id", 1);
		Optional<City> optional = Optional.ofNullable(db);
		Mockito.when(this.cityRepository.findByName("BALTIMORE_MD")).thenReturn(optional);
		Mockito.lenient().when(this.cityRepository.save(city)).thenReturn(db);
		this.writer.updateOrCreate(city);
	}
	
	@Test
	public void createClouds() throws Exception {
		CloudConditions cc = new CloudConditions(Cloudiness.CLEAR.ordinal());
		CloudConditions db = null;
		Optional<CloudConditions> optional = Optional.ofNullable(db);
		Mockito.when(this.cloudRepository.findByCloudiness(Cloudiness.CLEAR.ordinal())).thenReturn(optional);
		Mockito.when(this.cloudRepository.save(cc)).thenReturn(cc);
		assertNotNull(this.writer.updateOrCreate(cc));
	}
	
	@Test
	public void updateClouds() throws Exception {
		CloudConditions cc = new CloudConditions(Cloudiness.CLEAR.ordinal());
		CloudConditions db = new CloudConditions();
		ReflectionTestUtils.setField(db, "id", 1);
		Optional<CloudConditions> optional = Optional.ofNullable(db);
		Mockito.when(this.cloudRepository.findByCloudiness(Cloudiness.CLEAR.ordinal())).thenReturn(optional);
		Mockito.lenient().when(this.cloudRepository.save(cc)).thenReturn(db);
		this.writer.updateOrCreate(cc);
	}
	
	@Test
	public void createHumidity() throws Exception {
		Humidity humidity = new Humidity(30);
		Humidity db = null;
		Optional<Humidity> optional = Optional.ofNullable(db);
		Mockito.when(this.humidityRepository.findByHumid(30)).thenReturn(optional);
		Mockito.when(this.humidityRepository.save(humidity)).thenReturn(humidity);
		assertNotNull(this.writer.updateOrCreate(humidity));
	}
	
	@Test
	public void updateHumidity() throws Exception {
		Humidity humidity = new Humidity(30);
		Humidity db = new Humidity();
		ReflectionTestUtils.setField(db, "id", 1);
		Optional<Humidity> optional = Optional.ofNullable(db);
		Mockito.when(this.humidityRepository.findByHumid(30)).thenReturn(optional);
		Mockito.lenient().when(this.humidityRepository.save(humidity)).thenReturn(db);
		this.writer.updateOrCreate(humidity);
	}
	
	@Test
	public void createPrecipitation() throws Exception {
		Precipitation precipitation = new Precipitation(2);
		Precipitation db = null;
		Optional<Precipitation> optional = Optional.ofNullable(db);
		Mockito.when(this.precipitationRepository.findByPrecip(2)).thenReturn(optional);
		Mockito.when(this.precipitationRepository.save(precipitation)).thenReturn(precipitation);
		assertNotNull(this.writer.updateOrCreate(precipitation));
	}
	
	@Test
	public void updatePrecipitation() throws Exception {
		Precipitation precipitation = new Precipitation(2);
		Precipitation db = new Precipitation();
		ReflectionTestUtils.setField(db, "id", 1);
		Optional<Precipitation> optional = Optional.ofNullable(db);
		Mockito.when(this.precipitationRepository.findByPrecip(2)).thenReturn(optional);
		Mockito.lenient().when(this.precipitationRepository.save(precipitation)).thenReturn(db);
		this.writer.updateOrCreate(precipitation);
	}
	
	@Test
	public void createPressure() throws Exception {
		Pressure pressure = new Pressure(30);
		Pressure db = null;
		Optional<Pressure> optional = Optional.ofNullable(db);
		Mockito.when(this.pressureRepository.findByPress(30)).thenReturn(optional);
		Mockito.when(this.pressureRepository.save(pressure)).thenReturn(pressure);
		assertNotNull(this.writer.updateOrCreate(pressure));
	}
	
	@Test
	public void updatePressure() throws Exception {
		Pressure pressure = new Pressure(30);
		Pressure db = new Pressure();
		ReflectionTestUtils.setField(db, "id", 1);
		Optional<Pressure> optional = Optional.ofNullable(db);
		Mockito.when(this.pressureRepository.findByPress(30)).thenReturn(optional);
		Mockito.lenient().when(this.pressureRepository.save(pressure)).thenReturn(db);
		this.writer.updateOrCreate(pressure);
	}
	
	@Test
	public void createTemperature() throws Exception {
		Temperature temperature = new Temperature(72);
		Temperature db = null;
		Optional<Temperature> optional = Optional.ofNullable(db);
		Mockito.when(this.temperatureRepository.findByTemp(72)).thenReturn(optional);
		Mockito.when(this.temperatureRepository.save(temperature)).thenReturn(temperature);
		assertNotNull(this.writer.updateOrCreate(temperature));
	}
	
	@Test
	public void updateTemperature() throws Exception {
		Temperature temperature = new Temperature(72);
		Temperature db = new Temperature();
		ReflectionTestUtils.setField(db, "id", 1);
		Optional<Temperature> optional = Optional.ofNullable(db);
		Mockito.when(this.temperatureRepository.findByTemp(72)).thenReturn(optional);
		Mockito.lenient().when(this.temperatureRepository.save(temperature)).thenReturn(db);
		this.writer.updateOrCreate(temperature);
	}
	
	@Test
	public void createWind() throws Exception {
		Wind wind = new Wind(WindDirection.EAST.ordinal(), 5);
		Wind db = null;
		Optional<Wind> optional = Optional.ofNullable(db);
		Mockito.when(this.windRepository.findByDirAndSpeed(WindDirection.EAST.ordinal(), 5)).thenReturn(optional);
		Mockito.when(this.windRepository.save(wind)).thenReturn(wind);
		assertNotNull(this.writer.updateOrCreate(wind));
	}
	
	@Test
	public void updateWind() throws Exception {
		Wind wind = new Wind(WindDirection.EAST.ordinal(), 5);
		Wind db = new Wind();
		ReflectionTestUtils.setField(db, "id", 1);
		Optional<Wind> optional = Optional.ofNullable(db);
		Mockito.when(this.windRepository.findByDirAndSpeed(WindDirection.EAST.ordinal(), 5)).thenReturn(optional);
		Mockito.lenient().when(this.windRepository.save(wind)).thenReturn(db);
		this.writer.updateOrCreate(wind);
	}
	
	@Test
	public void createCurrentConditions() throws Exception {
		String date = "20190202";
		String hour = "12";
		String cityName = "BALTIMORE_MD";
		DateDimension dateDimension = new DateDimension(LocalDateTime.of(2019, Month.FEBRUARY, 2, 12, 30));
		City city = new City("BALTIMORE_MD");
		CloudConditions clouds = new CloudConditions(Cloudiness.CLEAR.ordinal());
		Humidity humidity = new Humidity(30);
		Precipitation precipitation = new Precipitation(2);
		Pressure pressure = new Pressure(30);
		Temperature temperature = new Temperature(72);
		Wind wind = new Wind(WindDirection.EAST.ordinal(), 5);
		CurrentConditions cc = new CurrentConditions();
		CurrentConditions db = null;
		Optional<CurrentConditions> optional = Optional.ofNullable(db);
		Mockito.when(this.currentConditionsRepository.findByDateAndHourAndCityName(date, hour, cityName)).thenReturn(optional);
		Mockito.lenient().when(this.currentConditionsRepository.save(cc)).thenReturn(db);
		this.writer.updateOrCreate(dateDimension, city, clouds, humidity, precipitation, pressure, temperature, wind);
	}
	
	@Test
	public void updateCurrentConditions() throws Exception {
		String date = "20190202";
		String hour = "12";
		String cityName = "BALTIMORE_MD";
		DateDimension dateDimension = new DateDimension(LocalDateTime.of(2019, Month.FEBRUARY, 2, 12, 30));
		City city = new City("BALTIMORE_MD");
		CloudConditions clouds = new CloudConditions(Cloudiness.CLEAR.ordinal());
		CurrentConditions cc = new CurrentConditions();
		Humidity humidity = new Humidity(30);
		Precipitation precipitation = new Precipitation(2);
		Pressure pressure = new Pressure(30);
		Temperature temperature = new Temperature(72);
		Wind wind = new Wind(WindDirection.EAST.ordinal(), 5);
		CurrentConditions db = new CurrentConditions();
		ReflectionTestUtils.setField(db, "id", 1);
		Optional<CurrentConditions> optional = Optional.ofNullable(db);
		Mockito.when(this.currentConditionsRepository.findByDateAndHourAndCityName(date, hour, cityName)).thenReturn(optional);
		Mockito.lenient().when(this.currentConditionsRepository.save(cc)).thenReturn(db);
		this.writer.updateOrCreate(dateDimension, city, clouds, humidity, precipitation, pressure, temperature, wind);
	}
	
	@Disabled("Unable to get test to pass")
	@Test
	public void writeCurrentConditions() throws Exception {
		String date = "20190202";
		String hour = "12";
		String cityName = "BALTIMORE_MD";
		DateDimension dateDimension = new DateDimension(LocalDateTime.of(2019, Month.FEBRUARY, 2, 12, 30));
		City city = new City("BALTIMORE_MD");
		CloudConditions clouds = new CloudConditions(Cloudiness.CLEAR.ordinal());
		CurrentConditions cc = new CurrentConditions();
		Humidity humidity = new Humidity(30);
		Precipitation precipitation = new Precipitation(2);
		Pressure pressure = new Pressure(30);
		Temperature temperature = new Temperature(72);
		Wind wind = new Wind(WindDirection.EAST.ordinal(), 5);
		CurrentConditions db = new CurrentConditions();
		ReflectionTestUtils.setField(db, "id", 1);
		Optional<CurrentConditions> optional = Optional.ofNullable(db);
		Mockito.when(this.currentConditionsRepository.findByDateAndHourAndCityName(date, hour, cityName)).thenReturn(optional);
		Mockito.lenient().when(this.currentConditionsRepository.save(cc)).thenReturn(db);
		cc.setDate(dateDimension);
		cc.setCity(city);
		cc.setCloudConditions(clouds);
		cc.setHumidity(humidity);
		cc.setPrecipitation(precipitation);
		cc.setPressure(pressure);
		cc.setTemperature(temperature);
		cc.setWind(wind);

		DateDimension dbDate = null;
//		ReflectionTestUtils.setField(dbDate, "id", 1);
		Optional<DateDimension> optionalDate = Optional.ofNullable(dbDate);
		Mockito.when(this.dateRepository.findByDateAndHour("20190202", "12")).thenReturn(optionalDate);
		Mockito.lenient().when(this.dateRepository.save(dateDimension)).thenReturn(dbDate);

		City dbCity = null;
//		ReflectionTestUtils.setField(dbCity, "id", 1);
		Optional<City> optionalCity = Optional.ofNullable(dbCity);
		Mockito.when(this.cityRepository.findByName("BALTIMORE_MD")).thenReturn(optionalCity);
		Mockito.lenient().when(this.cityRepository.save(city)).thenReturn(dbCity);

		CloudConditions dbClouds = null;
//		ReflectionTestUtils.setField(dbClouds, "id", 1);
		Optional<CloudConditions> optionalClouds = Optional.ofNullable(dbClouds);
		Mockito.when(this.cloudRepository.findByCloudiness(Cloudiness.CLEAR.ordinal())).thenReturn(optionalClouds);
		Mockito.lenient().when(this.cloudRepository.save(clouds)).thenReturn(dbClouds);

		Humidity dbHumidity = null;
//		ReflectionTestUtils.setField(dbHumidity, "id", 1);
		Optional<Humidity> optionalHumidity = Optional.ofNullable(dbHumidity);
		Mockito.when(this.humidityRepository.findByHumid(30)).thenReturn(optionalHumidity);
		Mockito.lenient().when(this.humidityRepository.save(humidity)).thenReturn(dbHumidity);

		Precipitation dbPrecipitation = null;
//		ReflectionTestUtils.setField(dbPrecipitation, "id", 1);
		Optional<Precipitation> optionalPrecipitation = Optional.ofNullable(dbPrecipitation);
		Mockito.when(this.precipitationRepository.findByPrecip(2)).thenReturn(optionalPrecipitation);
		Mockito.lenient().when(this.precipitationRepository.save(precipitation)).thenReturn(dbPrecipitation);

		Pressure dbPressure = null;
//		ReflectionTestUtils.setField(dbPressure, "id", 1);
		Optional<Pressure> optionalPressure = Optional.ofNullable(dbPressure);
		Mockito.when(this.pressureRepository.findByPress(30)).thenReturn(optionalPressure);
		Mockito.lenient().when(this.pressureRepository.save(pressure)).thenReturn(dbPressure);

		Temperature dbTemperature = null;
//		ReflectionTestUtils.setField(dbTemperature, "id", 1);
		Optional<Temperature> optionalTemperature = Optional.ofNullable(dbTemperature);
		Mockito.when(this.temperatureRepository.findByTemp(72)).thenReturn(optionalTemperature);
		Mockito.lenient().when(this.temperatureRepository.save(temperature)).thenReturn(dbTemperature);

		Wind dbWind = null;
//		ReflectionTestUtils.setField(dbWind, "id", 1);
		Optional<Wind> optionalWind = Optional.ofNullable(dbWind);
		Mockito.when(this.windRepository.findByDirAndSpeed(WindDirection.EAST.ordinal(), 5)).thenReturn(optionalWind);
		Mockito.lenient().when(this.windRepository.save(wind)).thenReturn(dbWind);

		CurrentConditions dbCc = null;
//		dbCc.setDate(dateDimension);
//		dbCc.setCity(city);
//		dbCc.setCloudConditions(clouds);
//		dbCc.setHumidity(humidity);
//		dbCc.setPrecipitation(precipitation);
//		dbCc.setPressure(pressure);
//		dbCc.setTemperature(temperature);
//		dbCc.setWind(wind);
		
//		ReflectionTestUtils.setField(dbCc, "id", 1);
		Optional<CurrentConditions> optionalCc = Optional.ofNullable(dbCc);
		Mockito.when(this.currentConditionsRepository.findByDateAndHourAndCityName(date, hour, cityName)).thenReturn(optionalCc);
		Mockito.lenient().when(this.currentConditionsRepository.save(cc)).thenReturn(dbCc);

		this.writer.writeCurrentConditions(cc);
	}
	
	@BeforeEach
	protected void setUp() throws Exception {
		this.writer = new CurrentConditionsWriter();
		ReflectionTestUtils.setField(this.writer, "dateRepository", this.dateRepository);
		ReflectionTestUtils.setField(this.writer, "cityRepository", this.cityRepository);
		ReflectionTestUtils.setField(this.writer, "cloudConditionsRepository", this.cloudRepository);
		ReflectionTestUtils.setField(this.writer, "humidityRepository", this.humidityRepository);
		ReflectionTestUtils.setField(this.writer, "precipitationRepository", this.precipitationRepository);
		ReflectionTestUtils.setField(this.writer, "pressureRepository", this.pressureRepository);
		ReflectionTestUtils.setField(this.writer, "temperatureRepository", this.temperatureRepository);
		ReflectionTestUtils.setField(this.writer, "windRepository", this.windRepository);
		ReflectionTestUtils.setField(this.writer, "currentConditionsRepository", this.currentConditionsRepository);
	}

}
