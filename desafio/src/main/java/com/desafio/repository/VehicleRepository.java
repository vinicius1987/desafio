package com.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import com.desafio.models.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, String>{
	Vehicle findById (long id);
}
