package com.ionep.egis.history.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ionep.egis.current.domain.City;

public interface CityRepository extends CrudRepository<City, Long> {
	
	Optional<City> findByName(String name);

}
