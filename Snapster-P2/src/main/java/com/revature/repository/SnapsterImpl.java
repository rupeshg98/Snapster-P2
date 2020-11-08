package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.utility.HibernateSessionFactory;

@Repository(value = "SnapsterRepo")
public class SnapsterImpl implements Snapster {

	public void insertUser(User user) {

		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(user);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}

	public User getUser(String username) {
		System.out.println("Inside Impl getUser: username: " + username);
		Session s = null;
		Transaction tx = null;
		User user = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
//			user = s.load(User.class, username);
//			
//			if (user == null ) {
//				System.out.println ("Inside Impl user is NULL");
//			} else {
//				System.out.println ("Inside Impl user is NOT NULL : " + user.toString());
//			}

			List<User> users = s.createQuery("FROM User WHERE user_name = :xyz").setParameter("xyz", username)
					.getResultList();

			if (users != null) {
				for (int i = 0; i < users.size(); i++) {
					user = users.get(i);
					System.out.println("Impl Loop User for : " + user.getUsername() + ", pwd: " + user.getPassword());
				}
			} else {
				System.out.println ("Inside Impl user is NULL");
			}
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return user;
	}

	public void insertPhoto(Photo photo) {

		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(photo);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}

	public ArrayList<Photo> getPhotos(String username) {

		Session s = null;
		Transaction tx = null;
		ArrayList<Photo> photos = new ArrayList<Photo>();

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();

			List<Photo> photos2 = s.createQuery("FROM Photo WHERE username = :xyz").setParameter("xyz", username)
					.getResultList();

//			for (int i = 0; i < photos2.size(); i++) {
//				Photo photo = photos2.get(i);
//				System.out
//						.println("Impl Loop Photo for : " + photo.getUsername() + ", location: " + photo.getLocation());
//			}

			photos = new ArrayList<Photo>(photos2);

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return photos;
	}

	public boolean insertFriendRequest(FriendRequest req) {

		Session s = null;
		Transaction tx = null;
		boolean returnValue = false;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(req);
			tx.commit();
			returnValue = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return returnValue;
	}

	public boolean approveRequest(FriendRequest req) {
		Session s = null;
		Transaction tx = null;
		boolean returnValue = false;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();

			s.update(req);
			tx.commit();
			returnValue = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return returnValue;
	}

	public boolean deleteRequest(FriendRequest req) {

		Session s = null;
		Transaction tx = null;
		boolean returnValue = false;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.delete(req);
			tx.commit();
			returnValue = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return returnValue;
	}

	public ArrayList<FriendRequest> getFriendRequests(String receiver) {
		System.out.println("In repository getFriendRequests");
		Session s = null;
		Transaction tx = null;
		ArrayList<FriendRequest> friends = new ArrayList<FriendRequest>();

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			List<FriendRequest> friends2 = s.createQuery("FROM FriendRequest WHERE receiver = :xyz")
					.setParameter("xyz", receiver).getResultList();

			friends = new ArrayList<FriendRequest>(friends2);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

		return friends;
	}
	
	public ArrayList<User> getAllMyFriends(String username) {
		System.out.println("In repository getAllMyFriends");
		Session s = null;
		Transaction tx = null;
		ArrayList<User> friends = new ArrayList<User>();

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			List<FriendRequest> friendsApprovedMe = s.createQuery("FROM FriendRequest WHERE sender = :xyz")
					.setParameter("xyz", username).getResultList();
			List<FriendRequest> friendsIApproved = s.createQuery("FROM FriendRequest WHERE receiver = :xyz")
					.setParameter("xyz", username).getResultList();
			tx.commit();
			
			if (friendsApprovedMe != null) {
				for (int i = 0; i < friendsApprovedMe.size(); i++) {
					FriendRequest friendRequest = friendsApprovedMe.get(i);
					if (friendRequest.isApproved()) {
						String friendUserName = friendRequest.getReceiver();
						User user = getUser(friendUserName);
						if (user != null) {
							user.setPassword("");
							friends.add(user);
						}
					}
				}
			}

			if (friendsIApproved != null) {
				for (int i = 0; i < friendsIApproved.size(); i++) {
					FriendRequest friendRequest = friendsIApproved.get(i);
					if (friendRequest.isApproved()) {
						String friendUserName = friendRequest.getSender();
						User user = getUser(friendUserName);
						if (user != null) {
							user.setPassword("");
							friends.add(user);
						}
					}
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

		return friends;
	}

	public ArrayList<User> getMyPendingFriendRequests(String username) {
		System.out.println("In repository getMyPendingFriendRequests");
		Session s = null;
		Transaction tx = null;
		ArrayList<User> friends = new ArrayList<User>();

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			List<FriendRequest> friendsIamNotApproved = s.createQuery("FROM FriendRequest WHERE receiver = :xyz")
					.setParameter("xyz", username).getResultList();
			tx.commit();
			
			if (friendsIamNotApproved != null) {
				for (int i = 0; i < friendsIamNotApproved.size(); i++) {
					FriendRequest friendRequest = friendsIamNotApproved.get(i);
					if (!friendRequest.isApproved()) {
						String friendUserName = friendRequest.getSender();
						User user = getUser(friendUserName);
						if (user != null) {
							user.setPassword("");
							friends.add(user);
						}
					}
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

		return friends;
	}

}
