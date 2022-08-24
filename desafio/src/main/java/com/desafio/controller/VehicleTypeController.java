package com.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.desafio.models.Vehicle_type;
import com.desafio.repository.VehicleTypeRepository;





@Controller
public class VehicleTypeController {
	
	@Autowired VehicleTypeRepository vtr;
	
	@RequestMapping(value = "/cadastrarVehicleType", method = RequestMethod.GET)
	public String form() {
		return "vehicle/FormVehicleType";
	}
	
	@RequestMapping(value = "/cadastrarVehicleType", method = RequestMethod.POST)
	public String form(Vehicle_type vehicle_type) {
		vtr.save(vehicle_type);
		return "redirect:/findAllVehicleType";
	}
	
	@RequestMapping("/findAllVehicleType")
	public ModelAndView findAllVehicleType() {
		ModelAndView mv = new ModelAndView("vehicle/FormDetalesVehicleType");
		Iterable<Vehicle_type> Vehicle_types = vtr.findAll();
		mv.addObject("Vehicle_types", Vehicle_types);
		return mv;
	}
	@RequestMapping("deletarVehicleType")
	public String deletarVehicleType(long id) {
		Vehicle_type vehicle_type = vtr.findById(id);
		vtr.delete(vehicle_type);
		return "redirect:/findAllVehicleType;";
	}
	@RequestMapping("updateVehicleType")
	public ModelAndView updateVehicleType(long id) {
		ModelAndView mv = new ModelAndView("vehicle/updateVehicleType");
		Vehicle_type Vehicle_type = vtr.findById(id);
		mv.addObject("Vehicle_type", Vehicle_type);
		return mv;
	}
	
	
	
}
