create schema EGIS_WEATHER;

create table EGIS_WEATHER.DATE_DIMENSION (
	ID bigserial unique primary key,
	DATE char(8) not null,
	HOUR char(2) not null,
	MONTH char(3) not null,
	YEAR char(4) not null,
	DAY_OF_MONTH char(2) not null,
	DAY_OF_WEEK char(3) not null,
	WEEK_OF_YEAR char(2) not null
);

create index DATE_DATE_HOUR_INDEX on EGIS_WEATHER.DATE_DIMENSION(DATE, HOUR);

create table EGIS_WEATHER.CLOUD_CONDITIONS (
	ID bigserial unique primary key,
	CLOUDINESS smallint not null
);

create index CLOUD_CONDITIONS_CLOUDINESS_INDEX on EGIS_WEATHER.CLOUD_CONDITIONS(CLOUDINESS);

create table EGIS_WEATHER.HUMIDITY (
	ID bigserial unique primary key,
	HUMID smallint not null
);

create index HUMIDITY_HUMID_INDEX on EGIS_WEATHER.HUMIDITY(HUMID);

create table EGIS_WEATHER.PRECIPITATION (
	ID bigserial unique primary key,
	PRECIP smallint not null
);

create index PRECIPITATION_PRECIP_INDEX on EGIS_WEATHER.PRECIPITATION(PRECIP);

create table EGIS_WEATHER.PRESSURE (
	ID bigserial unique primary key,
	PRESS smallint not null
);

create index PRESSURE_PRESS_INDEX on EGIS_WEATHER.PRESSURE(PRESS);

create table EGIS_WEATHER.TEMPERATURE (
	ID bigserial unique primary key,
	TEMP smallint not null
);

create index TEMPERATURE_TEMP_INDEX on EGIS_WEATHER.TEMPERATURE(TEMP);

create table EGIS_WEATHER.WIND (
	ID bigserial unique primary key,
	SPEED smallint not null,
	DIR smallint not null
);

create index WEATHER_DIR_SPEED_INDEX on EGIS_WEATHER.WIND(DIR, SPEED);

create table EGIS_WEATHER.CITY (
	ID bigserial unique primary key,
	NAME varchar(80) not null
);

create index CITY_NAME_INDEX on EGIS_WEATHER.CITY(NAME);

create table EGIS_WEATHER.CURRENT_CONDITIONS (
	ID bigserial unique primary key,
	CITY_ID bigserial references EGIS_WEATHER.CITY(ID) not null,
	DATE_ID bigserial references EGIS_WEATHER.DATE_DIMENSION(ID) not null,
	CLOUD_CONDITIONS_ID bigserial references EGIS_WEATHER.CLOUD_CONDITIONS(ID) not null,
	HUMIDITY_ID bigserial references EGIS_WEATHER.HUMIDITY(ID) not null,
	PRECIPITATION_ID bigserial references EGIS_WEATHER.PRECIPITATION(ID) not null,
	PRESSURE_ID bigserial references EGIS_WEATHER.PRESSURE(ID) not null,
	TEMPERATURE_ID bigserial references EGIS_WEATHER.TEMPERATURE(ID) not null,
	WIND_ID bigserial references EGIS_WEATHER.WIND(ID) not null
);

create index CURRENT_CONDITIONS_DATE_INDEX on EGIS_WEATHER.CURRENT_CONDITIONS(DATE_ID);
