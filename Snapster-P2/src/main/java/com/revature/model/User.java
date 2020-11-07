package com.revature.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_name")
	String user_name;

	@Column(name = "user_pass")
	String user_pass;

	@Column(name = "email")
	String email;

	@Column(name = "first_name")
	String first_name;

	@Column(name = "last_name")
	String last_name;

	@Column(name = "date")
	Date date;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email, String firstname, String lastname, Date date) {
		super();
		this.user_name = username;
		this.user_pass = password;
		this.email = email;
		this.first_name = firstname;
		this.last_name = lastname;
		this.date = date;
	}

	public String getUsername() {
		return user_name;
	}

	public void setUsername(String username) {
		this.user_name = username;
	}

	public String getPassword() {
		return user_pass;
	}

	public void setPassword(String password) {
		this.user_pass = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return first_name;
	}

	public void setFirstname(String firstname) {
		this.first_name = firstname;
	}

	public String getLastname() {
		return last_name;
	}

	public void setLastname(String lastname) {
		this.last_name = lastname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [username=" + user_name + ", password=" + user_pass + ", email=" + email + ", firstname=" + first_name
				+ ", lastname=" + last_name + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((user_pass == null) ? 0 : user_pass.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (user_pass == null) {
			if (other.user_pass != null)
				return false;
		} else if (!user_pass.equals(other.user_pass))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

}
