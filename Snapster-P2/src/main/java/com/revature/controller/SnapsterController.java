package com.revature.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.SnapsterService;

@RestController(value = "SnapsterController")

@CrossOrigin(origins = {"http://localhost:4200/login"}, allowedHeaders="*")

public class SnapsterController {
	
	SnapsterService snapsterService;

	@GetMapping(path = "/login", consumes =MediaType.APPLICATION_JSON_VALUE)
	public void validateLogin(@RequestBody String username, @RequestBody String password) {
		System.out.println("SnapsterController Received Username " + username + " , Password: " + password);
		
	}
	

}

