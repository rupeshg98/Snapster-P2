package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.utility.HibernateSessionFactory;

public class SnapsterImpl implements Snapster{

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

		Session s = null;
		Transaction tx = null;
		User user = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			user = (User) s.get(User.class, username);
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
	
	public void insertFriendRequest(FriendRequest req) {

		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(req);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	
	public void approveRequest(FriendRequest req) {
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.update(req);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}	
	}
	
	public void deleteRequest(FriendRequest req) {

		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.delete(req);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	public ArrayList<FriendRequest> getFriendRequests(String receiver) {

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
}
