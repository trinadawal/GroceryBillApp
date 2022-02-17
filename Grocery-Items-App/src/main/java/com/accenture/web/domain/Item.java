package com.accenture.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class Item {

	@Id
//	@Column(name = "ITEM_ID")
//	private int itemId;
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Column(name = "ITEM_PRICE")
	private double itemPrice;
	@Column(name = "DISCOUNTED")
	private boolean isDiscounted;
	@Column(name = "DISCOUNT_PERCENTAGE")
	private double discountPercentage;
	@Column(name = "DISCOUNTED_PRICE")
	private double discountedPrice;
//	
	public Item() {
		super();
	}

	public Item(String itemName, double itemPrice, boolean isDiscounted, double discountPercentage, double discountedPrice) {
		super();
//		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.isDiscounted = isDiscounted;
		this.discountPercentage = discountPercentage;
		this.discountedPrice = discountedPrice;
	}

//	public int getItemId() {
//		return itemId;
//	}

//	public void setItemId(int itemId) {
//		this.itemId = itemId;
//	}

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

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getdiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountPrice) {
		this.discountedPrice = discountPrice;
	}
}
