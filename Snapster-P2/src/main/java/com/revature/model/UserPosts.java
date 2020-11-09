package com.revature.model;

import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userposts")
public class UserPosts implements Serializable {

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
	@Column(name = "post")
	String post;
	@Id
	@Column(name = "senttime")
	Date senttime;

	public UserPosts() {
		super();
	}

	public UserPosts(String username, String post, Date senttime) {
		super();
		this.username = username;
		this.post = post;
		this.senttime = senttime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getSenttime() {
		return senttime;
	}

	public void setSenttime(Date senttime) {
		this.senttime = senttime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((senttime == null) ? 0 : senttime.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserPosts other = (UserPosts) obj;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (senttime == null) {
			if (other.senttime != null)
				return false;
		} else if (!senttime.equals(other.senttime))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserPosts [username=" + username + ", post=" + post + ", senttime=" + senttime + "]";
	}

}
