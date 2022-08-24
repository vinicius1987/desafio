package com.desafio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;



@Entity
@Data
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String v_name;
	private String v_plate;
	private String v_desc;
	
	@ManyToOne
	@JoinColumn(name="id_vehicle_type")
	private Vehicle_type vehicle_type;

}
