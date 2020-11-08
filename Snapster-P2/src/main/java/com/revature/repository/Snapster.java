package com.revature.repository;

import java.util.ArrayList;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.model.UserPosts;

public interface Snapster {
	public void insertUser(User user);
	public User getUser(String username);
	public void insertPhoto(Photo photo);
	public ArrayList<Photo> getPhotos(String username, boolean includeFriends);
	public boolean insertFriendRequest(FriendRequest req);
	public boolean approveRequest(FriendRequest req);
	public boolean deleteRequest(FriendRequest req);
	public ArrayList<FriendRequest> getFriendRequests(String receiver);
	public ArrayList<User> getAllMyFriends(String username);
	public ArrayList<User> getMyPendingFriendRequests(String username);
	public boolean insertUserPosts(UserPosts post);
	public ArrayList<UserPosts> getAllUserPosts(String username, boolean includeFriends);
}
