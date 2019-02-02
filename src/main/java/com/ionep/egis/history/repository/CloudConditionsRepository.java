package com.ionep.egis.history.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ionep.egis.current.domain.CloudConditions;

public interface CloudConditionsRepository extends CrudRepository<CloudConditions, Long> {
	
	Optional<CloudConditions> findByCloudiness(int cloudiness);

}
