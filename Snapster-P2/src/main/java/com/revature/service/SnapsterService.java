package com.revature.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.model.UserPosts;
import com.revature.repository.Snapster;
import com.revature.repository.SnapsterImpl;

@Service(value = "snapsterService")

public class SnapsterService {

	private Snapster snapsterRepo = new SnapsterImpl();
	
//	@Autowired
//	public void setSnapster(SnapsterImpl snapsterImpl) {
//		this.snapsterRepo = snapsterImpl;
//	}

	public void insertUser(User user) {
		snapsterRepo.insertUser(user);
	}

	public void insertPhoto(Photo photo) {
		snapsterRepo.insertPhoto(photo);
	}

	public User validateUser(String username, String pwd) {
		User user = snapsterRepo.getUser(username);
		if (user != null) {
			if (pwd != null && pwd.equals(user.getPassword())) {
				user.setPassword("");
				return user;
			} else {
				System.out.println ("Inside Service validateUser: pwd received: " + pwd + ", dbpwd: " + user.getPassword());
			}
		} else {
			System.out.println ("Inside Service validateUser: user returned NULL");
		}
		return null;
	}

	public User getUser(String username) {
		User user = snapsterRepo.getUser(username);

		return user;
	}

	public ArrayList<Photo> getPhotos(String username) {
		ArrayList<Photo> photos = snapsterRepo.getPhotos(username);

		return photos;
	}
	
	public boolean insertFriendRequest(FriendRequest req) {
		req.setApproved(false);
		return snapsterRepo.insertFriendRequest(req);
	}
	
	public boolean approveRequest(FriendRequest req) {
		req.setApproved(true);
		return snapsterRepo.approveRequest(req);
	}
	
	public boolean deleteRequest(FriendRequest req) {
		return snapsterRepo.deleteRequest(req);
	}
	public ArrayList<FriendRequest> getFriendRequests(String receiver) {
		System.out.println("In service getMyPendingFriendRequests");
		return snapsterRepo.getFriendRequests(receiver);
		
	}
	
	public ArrayList<User> getAllMyFriends(String username){
		return snapsterRepo.getAllMyFriends(username);		
	}
	
	public ArrayList<User> getMyPendingFriendRequests(String username){
		return snapsterRepo.getMyPendingFriendRequests(username);
	}
	
	public ArrayList<UserPosts> getAllUserPosts(String username, boolean includeFriends) {
		return snapsterRepo.getAllUserPosts(username, includeFriends);
	}
}
