package com.accenture.web.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CLERKS")
public class ShoppingClerk {

	@Id
//	@Column(name = "CLERK_ID")
//	private int clerkId;
	@Column(name = "CLERK_NAME")
	private String clerkName;
	@Column(name = "CLERK_PASSWORD")
	private String clerkPassword;
	
	public ShoppingClerk() {
		super();
	}

	public ShoppingClerk(String clerkName, String clerkPassword) {
		super();
//		this.clerkId = clerkId;
		this.clerkName = clerkName;
		this.clerkPassword = clerkPassword;
	}

//	public int getClerkId() {
//		return clerkId;
//	}
//
//	public void setClerkId(int clerkId) {
//		this.clerkId = clerkId;
//	}

	public String getClerkName() {
		return clerkName;
	}

	public void setClerkName(String clerkName) {
		this.clerkName = clerkName;
	}

	public String getClerkPassword() {
		return clerkPassword;
	}

	public void setClerkPassword(String clerkPassword) {
		this.clerkPassword = clerkPassword;
	}

//	private List<ShoppingClerk> clerkList;
//
//	public List<ShoppingClerk> getClerkList() {
//		return clerkList;
//	}
//
//	public void setClerkList(List<ShoppingClerk> clerkList) {
//		this.clerkList = clerkList;
//	}
	
}
