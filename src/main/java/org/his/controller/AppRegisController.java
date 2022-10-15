package org.his.controller;

import org.his.binding.CitizenApp;
import org.his.service.ApplicationRegiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRegisController {

	@Autowired
	private ApplicationRegiService applicationRegi;

	@PostMapping("/app")
	public ResponseEntity<String> registration(@RequestBody CitizenApp app) {

		Integer appId = applicationRegi.createApplication(app);

		if (appId > 0) {
			return new ResponseEntity<>("App Created with App Id:" + appId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid ssn", HttpStatus.BAD_REQUEST);
		}
	}
		
	
	@GetMapping("/msg")
	public String getMst() {
		return "Helllo";
	}
}
