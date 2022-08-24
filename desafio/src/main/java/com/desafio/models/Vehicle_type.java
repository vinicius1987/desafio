package com.desafio.models;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Vehicle_type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String t_name;
	private String t_desc;

	@OneToMany
	@JoinColumn(name = "id_vehicle")
	List<Vehicle> vehicles;
}
