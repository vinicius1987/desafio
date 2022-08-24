package com.desafio.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.desafio.models.Vehicle;
import com.desafio.models.Vehicle_type;
import com.desafio.repository.VehicleRepository;
import com.desafio.repository.VehicleTypeRepository;


@Controller
public class VehicleController {
	
	@Autowired
	private VehicleRepository vr;
	
	@Autowired
	private VehicleTypeRepository vtr;
	
	@RequestMapping(value = "/cadastrarVehicle", method = RequestMethod.GET)
	public ModelAndView cadastrarVehicle() {
		ModelAndView mv = new ModelAndView("vehicle/FormVehicle");
		Iterable<Vehicle_type> Vehicle_types = vtr.findAll(); 
		mv.addObject("Vehicle_types", Vehicle_types);
		return mv;
	}
	@RequestMapping(value = "/cadastrarVehicle", method = RequestMethod.POST)
	public String form(long id_type, Vehicle vehicle) {
		vehicle.setVehicle_type(vtr.findById(id_type));
		vr.save(vehicle);
		return "redirect:/findAllVehicle";
	}
	
	@RequestMapping("/findAllVehicle")
	public ModelAndView findAllVehicle() {
		ModelAndView mv = new ModelAndView("vehicle/FormDetalesVehicle");
		Iterable<Vehicle> Vehicles = vr.findAll();
		mv.addObject("Vehicles", Vehicles);
		return mv;
	}
	
	@RequestMapping("deletarVehicle")
	public String deletarVehicle(long id) {
		Vehicle vehicle = vr.findById(id);
		vr.delete(vehicle);
		return "redirect:/findAllVehicle;";
	}
	
	
}
