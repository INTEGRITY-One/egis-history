package com.ionep.egis.history.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ionep.egis.current.domain.Precipitation;

public interface PrecipitationRepository extends CrudRepository<Precipitation, Long> {
	
	Optional<Precipitation> findByPrecip(int precip);

}
