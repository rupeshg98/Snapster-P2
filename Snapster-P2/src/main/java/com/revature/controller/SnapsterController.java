package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.SnapsterService;

@RestController(value = "SnapsterController")

@CrossOrigin(origins = { "http://localhost:4200" }, allowedHeaders = "*")

public class SnapsterController {
	SnapsterService snapsterService = new SnapsterService();

	@GetMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public User validateLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("SnapsterController Received Username " + username + ", pwd: " + password);
		User user = snapsterService.validateUser(username, password);

		return user;
	}

	@GetMapping(path = "/viewMyInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> viewMyinfo(@RequestParam("username") String username) {
		User user = snapsterService.getUser(username);
		List<User> users = new ArrayList<User>();
		if (user != null) {
			user.setPassword("");
			users.add(user);
		}
		return users;
	}

	@GetMapping(path = "/loginn", produces = MediaType.TEXT_HTML_VALUE)
	public void validateLoginn() {
		System.out.println("SnapsterController Received Username ");

	}

}
