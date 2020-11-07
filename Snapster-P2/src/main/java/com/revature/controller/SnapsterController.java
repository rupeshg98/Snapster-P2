package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.SnapsterService;

@RestController(value = "SnapsterController")

@CrossOrigin(origins = {"http://localhost:4200"}, allowedHeaders="*")

public class SnapsterController {
	SnapsterService snapsterService = new SnapsterService();
    
	@GetMapping(path = "/login", produces=MediaType.APPLICATION_JSON_VALUE)
	public String validateLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("SnapsterController Received Username " + username +", pwd: " + password);
		boolean isValidUser = snapsterService.validateUser(username, password);
		
		return ("{isValidUser:"+isValidUser + "}");
	}

	@GetMapping(path = "/loginaaa")
	public void validateLogin() {
		System.out.println("SnapsterController Received Username ");
		//return ("<html><body>Hello returned from Login</body></html>");
	}
	@GetMapping(path = "/loginn", produces=MediaType.TEXT_HTML_VALUE)
	public void validateLoginn() {
		System.out.println("SnapsterController Received Username ");
		
	}
	

}

