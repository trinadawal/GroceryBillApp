package com.accenture.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.web.GroceryItemApp;
import com.accenture.web.GroceryRegularBillApplication;
import com.accenture.web.domain.Item;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TotalBillController {


	@GetMapping("/item/totalBill")
	public double getRegularItem() {

		RestTemplate restTemplate = new RestTemplate();

		final String fetchItemApi = "http://localhost:9091/ecz/api/items/list";
		GroceryItemApp groceryItemApp = restTemplate.getForObject(fetchItemApi, GroceryItemApp.class);
		GroceryItemApp regularItemsList = new GroceryItemApp();
		double totalBill = 0;
		for (Item item : groceryItemApp.getItemList()) {
			totalBill += item.getdiscountedPrice();
		}
		return totalBill;

	}

}
