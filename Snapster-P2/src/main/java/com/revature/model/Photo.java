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
	@Column(name = "filename")
	String filename;
	@Column(name = "caption")
	String caption;
	@Column(name = "username")
	String username;

	@Column(name = "created_date")
	Date created_date;

	public Photo() {
		super();
	}

	public Photo(String username, String filename, String caption, Date createdDate) {
		super();
		this.username = username;
		this.filename = filename;
		this.caption = caption;
		this.created_date = createdDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getCreatedDate() {
		return created_date;
	}

	public void setCreatedDate(Date createdDate) {
		this.created_date = createdDate;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result + ((created_date == null) ? 0 : created_date.hashCode());
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
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
		Photo other = (Photo) obj;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (created_date == null) {
			if (other.created_date != null)
				return false;
		} else if (!created_date.equals(other.created_date))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
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
		return "Photo [filename=" + filename + ", caption=" + caption + ", username=" + username + ", createdDate="
				+ created_date + "]";
	}

	
}
