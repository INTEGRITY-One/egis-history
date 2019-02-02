package com.ionep.egis.history.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ionep.egis.current.domain.CurrentConditions;

public interface CurrentConditionsRepository extends CrudRepository<CurrentConditions, Long> {
	
	@Query(value = "select c from CurrentConditions c where c.date.date = :date and c.date.hour = :hour and c.city.name = :cityName")
	Optional<CurrentConditions> findByDateAndHourAndCityName(
			@Param("date")String date, @Param("hour")String hour, @Param("cityName")String cityName);

}
