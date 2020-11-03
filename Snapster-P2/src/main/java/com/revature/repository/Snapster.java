package com.revature.repository;

import java.util.ArrayList;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;

public interface Snapster {
	public void insertUser(User user);
	public User getUser(String username);
	public void insertPhoto(Photo photo);
	public ArrayList<Photo> getPhotos(String username);
	public void insertFriendRequest(FriendRequest req);
	public void approveRequest(FriendRequest req);
	public void deleteRequest(FriendRequest req);
	public ArrayList<FriendRequest> getFriendRequests(String receiver);
}
