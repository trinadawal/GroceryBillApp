package com.accenture.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.web.GroceryItemApp;
import com.accenture.web.domain.Item;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DiscountedBillController {

	@GetMapping("/item/discounted")
	public GroceryItemApp getDiscountedItems() {

		RestTemplate restTemplate = new RestTemplate();

		final String fetchItemApi = "http://localhost:9091/ecz/api/items/list";
		GroceryItemApp groceryItemApp = restTemplate.getForObject(fetchItemApi, GroceryItemApp.class);
		GroceryItemApp discountedItemsList = new GroceryItemApp();
		List<Item> items = new ArrayList<>();
		for (Item item : groceryItemApp.getItemList()) {
			if (item.getisDiscounted()) {
				items.add(item);
			}
		}
		discountedItemsList.setItemList(items);
		return discountedItemsList;
		

	}
	
	@GetMapping("/item/discountedBill")
	public double getTotalDiscountedBill() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String discountedBillAPIString = "http://localhost:8083/ecz/api/item/discounted";
		GroceryItemApp groceryItemApp = restTemplate.getForObject(discountedBillAPIString, GroceryItemApp.class);
		double totalDiscountedBill = 0;
		
		for (Item item : groceryItemApp.getItemList()) {
			totalDiscountedBill += item.getItemPrice();
		}
		return totalDiscountedBill;
	}
}
