package com.revature.service;

import java.util.ArrayList;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.repository.SnapsterImpl;

public class SnapsterService {
	SnapsterImpl snapsterImpl = new SnapsterImpl();

	public void insertUser(User user) {
		snapsterImpl.insertUser(user);
	}

	public void insertPhoto(Photo photo) {
		snapsterImpl.insertPhoto(photo);
	}

	public boolean validateUser(String username, String pwd) {
		User user = snapsterImpl.getUser(username);
		if (user != null) {
			if (pwd != null && pwd.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public User getUser(String username) {
		User user = snapsterImpl.getUser(username);

		return user;
	}

	public ArrayList<Photo> getPhotos(String username) {
		ArrayList<Photo> photos = snapsterImpl.getPhotos(username);

		return photos;
	}
	
	public void insertFriendRequest(FriendRequest req) {
		snapsterImpl.insertFriendRequest(req);
	}
	
	public void approveRequest(FriendRequest req) {
		req.setApproved(true);
		snapsterImpl.approveRequest(req);
	}
	
	public void deleteRequest(FriendRequest req) {
		snapsterImpl.deleteRequest(req);
	}
	public ArrayList<FriendRequest> getFriendRequests(String receiver) {
		return snapsterImpl.getFriendRequests(receiver);
	}
}
