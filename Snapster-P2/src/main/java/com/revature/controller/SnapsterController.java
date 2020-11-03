package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.service.SnapsterService;

@RestController("snapsterController")
@RequestMapping(path = "/snapster")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SnapsterController {
	@Autowired
	private SnapsterService snapsterService;

	@GetMapping(path = "/friendRequests/{receiver}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<FriendRequest> findAllFriendRequests(@PathVariable String receiver){
		return this.snapsterService.getFriendRequests(receiver);
	}
}
