package com.revature.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.SnapsterService;

@RestController(value = "SnapsterController")

@CrossOrigin(origins = "*", allowedHeaders="*")
public class SnapsterController {
	
	SnapsterService snapsterService;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public void validateLogin(@RequestBody String username, @RequestBody String password) {
		System.out.println("SnapsterController Received Username " + username + " , Password: " + password);
		
	}
	

}

