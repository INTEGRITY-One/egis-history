package com.ionep.egis.history.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ionep.egis.current.domain.Wind;

public interface WindRepository extends CrudRepository<Wind, Long> {
	
	Optional<Wind> findByDirAndSpeed(int dir, int speed);

}
