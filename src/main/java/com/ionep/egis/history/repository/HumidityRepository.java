package com.ionep.egis.history.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ionep.egis.current.domain.Humidity;

public interface HumidityRepository extends CrudRepository<Humidity, Long> {
	
	Optional<Humidity> findByHumid(int humid);

}
