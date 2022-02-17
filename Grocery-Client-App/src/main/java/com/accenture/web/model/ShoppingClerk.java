package com.accenture.web.model;

public class ShoppingClerk {

	private int clerkId;
	private String clerkName;
	private String clerkPassword;

	public ShoppingClerk() {
		super();
	}

	public ShoppingClerk(int clerkId, String clerkName, String clerkPassword) {
		super();
		this.clerkId = clerkId;
		this.clerkName = clerkName;
		this.clerkPassword = clerkPassword;
	}

	public int getClerkId() {
		return clerkId;
	}

	public void setClerkId(int clerkId) {
		this.clerkId = clerkId;
	}

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

}
