package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friendrequests")
public class FriendRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "sender")
	String sender;
	@Id
	@Column(name = "receiver")
	String receiver;
	@Column(name = "approval")
	boolean isApproved;

	public FriendRequest(String sender, String receiver, boolean isApproved) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.isApproved = isApproved;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	@Override
	public String toString() {
		return "FriendRequest [sender=" + sender + ", receiver=" + receiver + ", isApproved=" + isApproved + "]";
	}

}
