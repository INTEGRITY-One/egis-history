package com.ionep.egis.history.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ionep.egis.current.domain.Temperature;

public interface TemperatureRepository extends CrudRepository<Temperature, Long> {
	
	Optional<Temperature> findByTemp(int temp);

}
