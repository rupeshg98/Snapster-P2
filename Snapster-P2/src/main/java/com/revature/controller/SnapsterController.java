package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
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
	public List<User> viewMyInfo(@RequestParam("username") String username) {
		User user = snapsterService.getUser(username);
		List<User> users = new ArrayList<User>();
		if (user != null) {
			user.setPassword("");
			users.add(user);
		}
		return users;
	}

	@GetMapping(path = "/viewMyFriends", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> viewMyFriends(@RequestParam("username") String username) {
		ArrayList<User> users = snapsterService.getAllMyFriends(username);
		if (users == null) {
			users = new ArrayList<User>();
		}
		return users;
	}

	@GetMapping(path = "/viewMyPendingFriendRequests", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> viewMyPendingFriendRequests(@RequestParam("username") String username) {
		ArrayList<User> users = snapsterService.getMyPendingFriendRequests(username);
		if (users == null) {
			users = new ArrayList<User>();
		}
		return users;
	}

	@GetMapping(path = "/addFriend", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean addFriend(@RequestParam("senderusername") String sender, @RequestParam("receiverusername") String receiver) {
		FriendRequest request = new FriendRequest();
		request.setSender(sender);
		request.setReceiver(receiver);
		return snapsterService.insertFriendRequest(request);
	}

	@GetMapping(path = "/approveRequest", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean approveRequest(@RequestParam("senderusername") String sender, @RequestParam("receiverusername") String receiver) {
		FriendRequest request = new FriendRequest();
		request.setSender(sender);
		request.setReceiver(receiver);
		return snapsterService.approveRequest(request);
	}
	
	@GetMapping(path = "/unFriend", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean unFriend(@RequestParam("senderusername") String sender, @RequestParam("receiverusername") String receiver) {
		FriendRequest request = new FriendRequest();
		request.setSender(sender);
		request.setReceiver(receiver);
		return snapsterService.deleteRequest(request);
	}
	
	@GetMapping(path = "/getMyPhotos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Photo> getMyPhotos(@RequestParam("username") String username) {
		ArrayList<Photo> photos = snapsterService.getPhotos(username);
		if (photos == null) {
			photos = new ArrayList<Photo>();
		}
		return photos;
	}
}
