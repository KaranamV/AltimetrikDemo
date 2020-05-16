package com.altimetrik.covid.tracking.CovidStatistics.Controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.covid.tracking.CovidStatistics.Model.CovidMetrics;
import com.altimetrik.covid.tracking.CovidStatistics.Service.CovidService;

@RestController
public class CovidController {

	@Autowired
	private CovidService service;

	@GetMapping(value = "/states/{stateCode}", produces = "application/json")
	public CovidMetrics findCovidDetailsByState(@PathVariable String stateCode) {
		return service.findCovidDetailsForState(stateCode);
	}

	@GetMapping(value = "/countries/{countryCode}", produces = "application/json")
	public CovidMetrics findCovidDetailsByCountry(@PathVariable String countryCode) {
		return service.findCovidDetailsForCountry(countryCode);
	}

	
}