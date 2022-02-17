package com.accenture.web;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accenture.web.domain.Item;

@SpringBootApplication
public class GroceryItemApp {

//	private List<ShoppingClerk> clerkList;
//
//	public List<Clerk> getClerkList() {
//		return clerkList;
//	}
//
//	public void setClerkList(List<Clerk> clerkList) {
//		this.clerkList = clerkList;
//	}

	private List<Item> itemList;

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GroceryItemApp.class, args);
	}

}
