package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.utility.HibernateSessionFactory;

public class SnapsterImpl {

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
}
