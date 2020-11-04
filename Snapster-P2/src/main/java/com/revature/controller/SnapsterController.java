package com.revature.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.FriendRequest;
import com.revature.service.SnapsterService;

@RestController("snapsterController")

@CrossOrigin(origins = {"http://172.73.80.76:4200/"})
public class SnapsterController {
	@Autowired
	private SnapsterService snapsterService;

	@PostMapping(path = "/validateLogin", consumes =MediaType.APPLICATION_JSON_VALUE)
	public void validateLogin(String username, String password) {
		System.out.println("SnapsterController Received Username " + username + " , Password: " + password);
	}

}

