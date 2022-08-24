package com.desafio.repository;

import org.springframework.data.repository.CrudRepository;


import com.desafio.models.Vehicle_type;


public interface VehicleTypeRepository extends CrudRepository<Vehicle_type, String> {
	Vehicle_type findById(long id);
	
	
}

