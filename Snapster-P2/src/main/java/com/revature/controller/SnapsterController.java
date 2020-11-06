package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.SnapsterService;

@RestController(value = "SnapsterController")

@CrossOrigin(origins = {"http://localhost:4200"})
public class SnapsterController {
	
	SnapsterService snapsterService;

	@PostMapping(path = "/home", consumes =MediaType.APPLICATION_JSON_VALUE)
	public void validateLogin(String username, String password) {
		System.out.println("SnapsterController Received Username " + username + " , Password: " + password);
		
	}
	

}

