package com.ionep.egis.history.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ionep.egis.current.domain.Pressure;

public interface PressureRepository extends CrudRepository<Pressure, Long> {
	
	Optional<Pressure> findByPress(int press);

}
