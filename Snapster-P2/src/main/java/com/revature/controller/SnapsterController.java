package com.revature.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.model.UserPosts;
import com.revature.service.S3Service;
import com.revature.service.SnapsterService;

@RestController(value = "SnapsterController")

@CrossOrigin(origins = { "http://localhost:4200" }, allowedHeaders = "*")

public class SnapsterController {
	SnapsterService snapsterService = new SnapsterService();
	S3Service s3service = new S3Service();

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
	public boolean addFriend(@RequestParam("senderusername") String sender,
			@RequestParam("receiverusername") String receiver) {
		FriendRequest request = new FriendRequest();
		request.setSender(sender);
		request.setReceiver(receiver);
		return snapsterService.insertFriendRequest(request);
	}

	@GetMapping(path = "/approveRequest", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean approveRequest(@RequestParam("senderusername") String sender,
			@RequestParam("receiverusername") String receiver) {
		FriendRequest request = new FriendRequest();
		request.setSender(sender);
		request.setReceiver(receiver);
		return snapsterService.approveRequest(request);
	}

	@GetMapping(path = "/unFriend", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean unFriend(@RequestParam("senderusername") String sender,
			@RequestParam("receiverusername") String receiver) {
		FriendRequest request = new FriendRequest();
		request.setSender(sender);
		request.setReceiver(receiver);
		return snapsterService.deleteRequest(request);
	}

	@GetMapping(path = "/getPhotos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Photo> getMyPhotos(@RequestParam("username") String username,
			@RequestParam("includeFriends") String includeFriends) {
		ArrayList<Photo> photos = null;
		if (includeFriends.equals("true")) {
			photos = snapsterService.getPhotos(username, true);
		} else {
			photos = snapsterService.getPhotos(username, false);
		}
		if (photos == null) {
			photos = new ArrayList<Photo>();
		}
		return photos;

	}
/*
	@PostMapping(path = "/addPhoto", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addPhoto(@RequestParam("file") File file, @RequestParam("caption") String caption,
			@RequestParam("username") String username) {
//	public Photo addPhoto(@RequestParam("file") File file, @RequestParam("caption") String caption, @RequestParam("username") String username) {
		// TODO server-side validation here
		System.out.println("Inside addPhoto: username: " + username + ", caption: " + caption + ", file: " + file);
		String uuid = UuidCreator.getTimeOrdered().toString();
		Photo photo = new Photo(username, uuid, caption, new Date());
		// s3service.putObject(file, uuid);
		snapsterService.insertPhoto(photo);
//		return photo;
	}
*/
	@PostMapping(path = "/addPhoto", consumes = MediaType.ALL_VALUE)
	public void addPhoto(HttpServletRequest request, @RequestBody Object file) {
		String caption = request.getParameter("caption");
		String username = request.getParameter("username");
		System.out.println("Inside addPhoto Caption: " + caption + ", username: " + username + ", file: " + file);
		
	}
	@GetMapping(path = "/addPost", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean addPost(@RequestParam("username") String username, @RequestParam("post") String post) {
		UserPosts userPost = new UserPosts();
		userPost.setUsername(username);
		userPost.setPost(post);
		userPost.setSenttime(new Date());
		return snapsterService.insertUserPosts(userPost);
	}

	@GetMapping(path = "/getPosts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserPosts> getAllUserPosts(@RequestParam("username") String username,
			@RequestParam("includeFriends") String includeFriends) {
		ArrayList<UserPosts> userPosts = null;
		if (includeFriends.equals("true")) {
			userPosts = snapsterService.getAllUserPosts(username, true);
		} else {
			userPosts = snapsterService.getAllUserPosts(username, false);
		}
		if (userPosts == null) {
			userPosts = new ArrayList<UserPosts>();
		}
		return userPosts;
	}
}
