package com.accenture.web.model;

public class Item {

	private String itemName;
	private double itemPrice;
	private boolean isDiscounted;
	private double discountPercentage;
	private double discountedPrice;

	public Item() {
		super();
	}

	public Item(String itemName, double itemPrice, boolean isDiscounted, double discountPercentage, double discountedPrice) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.isDiscounted = isDiscounted;
		this.discountPercentage = discountPercentage;
		this.discountedPrice = discountedPrice;
	}



	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public boolean getisDiscounted() {
		return isDiscounted;
	}

	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountedPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	public double getDiscountedPrice() {
		return discountedPrice;
	}
	
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

}
