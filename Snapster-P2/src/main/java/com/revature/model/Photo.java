package com.revature.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photos")
public class Photo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	@Column(name = "username")
	String username;
	@Id
	@Column(name = "file_location")
	String location;

	@Column(name = "created_date")
	Date createdDate;

	public Photo() {
		super();
	}

	public Photo(String username, String location, Date createdDate) {
		super();
		this.username = username;
		this.location = location;
		this.createdDate = createdDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Photo [username=" + username + ", location=" + location + ", createdDate=" + createdDate + "]";
	}

}
