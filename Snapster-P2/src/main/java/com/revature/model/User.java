package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users") 
public class User {
	
	@Id
	@Column(name = "user_name")
	String username;
	
	@Column(name = "user_pass")
	String password;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "firstname")
	String firstname;
	
	@Column(name = "lastname")
	String lastname;

	@Column(name = "date")
	Date date;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email, String firstname, String lastname, Date date) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", date=" + date + "]";
	}

	
	
	
}
