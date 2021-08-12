package com.country.crud2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.country.crud2.services.CrudService;
import com.country.crud2.model.Country;

@RestController
@RequestMapping("/rest/v2")
public class CrudRestController {
	
	@Autowired
	private CrudService service;

	@GetMapping("/getcountrylist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Country> fetchCountryList(){
		List<Country> countries = new ArrayList<Country>();
		countries = service.fetchCountryList();

		return countries;
	}
	
	@PostMapping("/addcountry")
	@CrossOrigin(origins = "http://localhost:4200")
	public Country saveCountry(@RequestBody Country country  ){
		return service.saveCountryToDB(country);
	} 
	@GetMapping("/getcountrybyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Country fetchCountrybyid(@PathVariable int id){
		return	service.fetchCountryById(id).get();		
	} 
	@DeleteMapping("/deletecountrybyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200") 
	public String DeleteCountryById(@PathVariable int id){
		return service.deleteCountryById(id);
	} 
	
}
