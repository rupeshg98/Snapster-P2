package com.revature;

import java.util.ArrayList;
import java.util.Date;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.service.SnapsterService;

public class Driver {
	SnapsterService service = new SnapsterService();

	public static void main(String[] args) {
		Driver driver = new Driver();
		// driver.insertUser();
		// driver.validateUser();
		//driver.insertPhoto();
		//driver.getPhotos();
		driver.insertRequest();
	}

	public void insertRequest() {
		String user1 = "user1";
		String user2 = "user2";
		FriendRequest req = new FriendRequest(user1, user2, false);
		service.insertFriendRequest(req);
		service.approveRequest(req);
	}
	
	
	public void insertUser() {
		String username = "user2";
		String password = "pwd";
		String email = "test";
		String firstname = "user2FirstName";
		String lastname = "user2LastName";
		Date date = new Date();

		User user = new User(username, password, email, firstname, lastname, date);

		service.insertUser(user);

	}

	public void validateUser() {
		String username = "user2";
		String password = "pwd";

		boolean validateUser1 = service.validateUser(username, password);
		System.out.println("user " + username + ", valid test1 :" + validateUser1);

		password = "pwd2";

		boolean validateUser2 = service.validateUser(username, password);
		System.out.println("user " + username + ", valid test2:" + validateUser2);

	}

	public void insertPhoto() {
		Photo photo = new Photo("user1", "PhotoLocation1", new Date());
		Photo photo2 = new Photo("user1", "PhotoLocation2", new Date());
		Photo photo3 = new Photo("user1", "PhotoLocation3", new Date());

		service.insertPhoto(photo);
		service.insertPhoto(photo2);
		service.insertPhoto(photo3);
	}

	public void getPhotos() {

		ArrayList<Photo> photos = service.getPhotos("user1");

		System.out.println("No.of Photos: " + photos.size());
		for (Photo photo : photos) {
			System.out.println("Photo for : " + photo.getUsername() + ", location: " + photo.getLocation());
		}

	}
}
