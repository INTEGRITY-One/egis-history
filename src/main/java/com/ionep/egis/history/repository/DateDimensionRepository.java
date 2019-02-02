package com.ionep.egis.history.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ionep.egis.current.domain.DateDimension;

public interface DateDimensionRepository extends CrudRepository<DateDimension, Long> {
	
	Optional<DateDimension> findByDateAndHour(String date, String hour);

}
