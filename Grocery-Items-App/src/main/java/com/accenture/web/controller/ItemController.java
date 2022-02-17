package com.accenture.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.web.GroceryItemApp;
import com.accenture.web.domain.Item;
import com.accenture.web.domain.ItemResponse;
import com.accenture.web.repository.ItemRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	// DISPLAY LIST OF ITEMS
	@GetMapping("/itemsList")
	public ItemResponse getAllItemResponse() {
		List<Item> itemsList = itemRepository.findAll();
		ItemResponse itemResponse = new ItemResponse();
		itemResponse.setItems(itemsList);
		return itemResponse;
	}

	@GetMapping("/items")
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	@GetMapping("/items/list")
	public GroceryItemApp getItem() {
		List<Item> itemsList = itemRepository.findAll();
		GroceryItemApp groceryItemApp = new GroceryItemApp();
		groceryItemApp.setItemList(itemsList);
		return groceryItemApp;
 	}
	
	@PostMapping("/items")
	public Item createItem(@RequestBody Item itemFromBrowser) {
		Item savedItem = itemRepository.save(itemFromBrowser);
		return savedItem;
	}

	
	@PutMapping("/items/{itemName}")
	public Item updatedItem1(@PathVariable(value = "itemName") String itemName, @RequestBody Item itemFromBrowser) {
		Item existingItem = itemRepository.findById(itemName).get();
		existingItem.setItemName(itemName);
		existingItem.setDiscountPercentage(itemFromBrowser.getDiscountPercentage());
		existingItem.setItemPrice(itemFromBrowser.getItemPrice());
		existingItem.setItemName(itemFromBrowser.getItemName());
		existingItem.setDiscountedPrice(itemFromBrowser.getdiscountedPrice());
		Item updatedItem = itemRepository.save(existingItem);
		return updatedItem;
	}

//	//DELETE ITEM
//	@DeleteMapping("/deleteItem/{itemName}")
//	public void deleteItem(@PathVariable(value="itemName") String itemName) {
//		itemRepository.deleteById(itemName);
//	}
//	
	@DeleteMapping("/items/{itemName}")
	public void deleteItem1(@PathVariable(value="itemName") String itemName) {
		itemRepository.deleteById(itemName);
	}
}
