package com.accenture.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.accenture.web.model.Item;
import com.accenture.web.model.ShoppingClerk;
import com.accenture.web.stub.ItemResponse;
import com.accenture.web.stub.ShoppingClerkResponse;

public class GroceryClientApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String choiceString = null;

		do {
			System.out.println(
					"\n==================================================================================================");
			System.out.println("				ABC GROCERY SHOP CLERK LOG IN");
			System.out.println(
					"==================================================================================================");
			System.out.println("\nPlease log in to your account...");
			System.out.print("Username :	");
			String clerkName = scanner.next();
			System.out.print("Password :	");
			String clerkPassword = scanner.next();
			System.out.println(
					"\n==================================================================================================");

			// LOG IN VALIDATION
			RestTemplate loginRestTemplate = new RestTemplate();
			final String loginURLString = "http://localhost:8081/ecz/api/clerksList";
			ShoppingClerkResponse shoppingClerkResponse = loginRestTemplate.getForObject(loginURLString,
					ShoppingClerkResponse.class);
			boolean found = false;
			List<ShoppingClerk> clerksList = shoppingClerkResponse.getClerks();
			for (ShoppingClerk clerk : clerksList) {
				String validateName = clerk.getClerkName().toString();
				String validatePassword = clerk.getClerkPassword().toString();
				boolean validation = (validateName.equals(clerkName) && validatePassword.equals(clerkPassword));
				if (validation) {
					found = true;
				}
			}
			if (found) {
				System.out.println("Log in successfull!");
				System.out.println(
						"==================================================================================================");
				System.out.println("\nCLERK ON DUTY : " + clerkName);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
				LocalDateTime now = LocalDateTime.now();
				System.out.println("DATE : 		" + dtf.format(now));
				OptionMenu(clerkName);
			} else {
				System.out.println("Log in failed. Incorrect username or password.");
			}

			System.out.println("\nDo you want to try again?");
			choiceString = scanner.next();

		} while (choiceString.equalsIgnoreCase("y"));
		System.out.println("\nEXITING THE PROGRAM....");

	}

	public static void OptionMenu(String clerkName) {
		try {
			ListOfItems();
			System.out.println("\nPLEASE CHOOSE OPTION : ");
			System.out.println("[1] Add Item");
			System.out.println("[2] Update Item");
			System.out.println("[3] Delete Item");
			System.out.println("[4] Generate Bill");
			System.out.println("[5] Log out");

			Scanner choiceScanner = new Scanner(System.in);
			int choice = choiceScanner.nextInt();
			if (choice == 1) {
				AddItem(clerkName);
			}
			if (choice == 2) {
				UpdateItem(clerkName);
			} if (choice == 3) {
				DeleteItem(clerkName);
			} if (choice == 4) {
				GenerateBill(clerkName);
			} if (choice == 5) {
				System.out.println("Logging out....");
				System.out.println(
						"==================================================================================================");
			}

		} catch (InputMismatchException inputMismatchException) {
			System.out.println("\nInvalid input. Please choose again.");
			System.out.println(
					"==================================================================================================");
			OptionMenu(clerkName);
		}
	}

	// ADD ITEM
	public static void AddItem(String clerkName) {
		Scanner detailScanner = new Scanner(System.in);
		System.out
				.println("\n==================================================================================================");
		System.out.println("\nInput new item details:");
		System.out.print("Name : ");
		String newItemName = detailScanner.next();
		System.out.print("Price : ");
		Double newItemPrice = detailScanner.nextDouble();
		System.out.print("Discounted : ");
		Boolean newItemIsDiscounted = detailScanner.nextBoolean();
		System.out.print("Discount Percentage : ");
		Double newItemDiscountPercentage = detailScanner.nextDouble();
		System.out.print("Discounted Price :");
		Double newItemDiscountedPrice = detailScanner.nextDouble();
		
		RestTemplate addItemRestTemplate = new RestTemplate();
		final String addItemURLString = "http://localhost:9091/ecz/api/items";
		Item items = new Item();
		items.setItemName(newItemName);
		items.setItemPrice(newItemPrice);
		items.setDiscounted(newItemIsDiscounted);
		items.setDiscountedPercentage(newItemDiscountPercentage);
		items.setDiscountedPrice(newItemDiscountedPrice);
		Item createdItem = addItemRestTemplate.postForObject(addItemURLString, items, Item.class);

		System.out.println("\nNew item saved!");
		OptionMenu(clerkName);
	}

	// UPDATE ITEM
	public static void UpdateItem(String clerkName) {
		Scanner updateScanner = new Scanner(System.in);
		System.out
				.println("\n==================================================================================================");
		System.out.println("\nPlease choose item to update.");
		System.out.print("Name : ");
		String itemToUpdate = updateScanner.next();

		RestTemplate itemsRestTemplate = new RestTemplate();
		final String itemsURLString = "http://localhost:9091/ecz/api/itemsList";
		ItemResponse itemResponse = itemsRestTemplate.getForObject(itemsURLString, ItemResponse.class);
		List<Item> itemsList = itemResponse.getItems();
		boolean found = false;
		for (Item items : itemsList) {
			if (items.getItemName().equals(itemToUpdate)) {
				found = true;
			}
		}
		if (found) {
			System.out.print("Price :");
			Double updatedPriceString = updateScanner.nextDouble();
			System.out.print("Discounted : ");
			Boolean updatedDiscounted = updateScanner.nextBoolean();
			System.out.print("Discount Percentage : ");
			Double updatedPercentageDouble = updateScanner.nextDouble();
			System.out.print("Discounted Price : ");
			Double updatedDiscountedPrice = updateScanner.nextDouble();
			
			RestTemplate updateRestTemplate = new RestTemplate();
			Item updatedItem = new Item();
			updatedItem.setItemName(itemToUpdate);
			updatedItem.setItemPrice(updatedPriceString);
			updatedItem.setDiscounted(updatedDiscounted);
			updatedItem.setDiscountedPercentage(updatedPercentageDouble);
			updatedItem.setDiscountedPrice(updatedDiscountedPrice);

			final String updateURLString = "http://localhost:9091/ecz/api/items/" + itemToUpdate;
			updateRestTemplate.put(updateURLString, updatedItem);
			OptionMenu(clerkName);
		} else {
			System.out.println("\nItem not found.");
			OptionMenu(clerkName);
		}
	}
	
	public static void DeleteItem(String clerkName) {
		Scanner updateScanner = new Scanner(System.in);
		System.out
				.println("\n==================================================================================================");
		System.out.println("\nPlease choose item to delete.");
		System.out.print("Name : ");
		String itemToDelete = updateScanner.next();

		RestTemplate itemsRestTemplate = new RestTemplate();
		final String itemsURLString = "http://localhost:9091/ecz/api/itemsList";
		ItemResponse itemResponse = itemsRestTemplate.getForObject(itemsURLString, ItemResponse.class);
		List<Item> itemsList = itemResponse.getItems();
		boolean found = false;
		for (Item items : itemsList) {
			if (items.getItemName().equals(itemToDelete)) {
				found = true;
			}
		}
		if (found) {
			RestTemplate deleteRestTemplate = new RestTemplate();
			final String deleteURLString = "http://localhost:9091/ecz/api/items/" + itemToDelete;
			deleteRestTemplate.delete(deleteURLString);
			System.out.println("\nItem successfully removed.");
			OptionMenu(clerkName);
		} else {
			System.out.println("\nItem not found.");
			OptionMenu(clerkName);
		}
	}
	
	public static void GenerateBill(String clerkName) {
		
		Random rand = new Random();
		int receiptNo = rand.nextInt(100000);
		
		RestTemplate itemsRestTemplate = new RestTemplate();
		final String itemsURLString = "http://localhost:9091/ecz/api/itemsList";
		ItemResponse itemResponse = itemsRestTemplate.getForObject(itemsURLString, ItemResponse.class);
		List<Item> itemsList = itemResponse.getItems();
		
		
		System.out.println("\n====================================================");
		System.out.println("		OFFICIAL RECEIPT");
		System.out.println("		OR NO. : " + receiptNo);
		System.out.println("====================================================");
		System.out.println("	CLERK ON DUTY : " + clerkName);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("	DATE : 		" + dtf.format(now));
		System.out.println("====================================================");
		System.out.printf("%-20s%-20s", "	ITEMS", "FINAL PRICE");
		System.out.println();
		
		for (Item items : itemsList) {
			System.out.printf("\n%-20s%-20s", "	" + items.getItemName(), "₱" + items.getDiscountedPrice());
		}
		System.out.println("\n====================================================");
		
		double totalBill = 0;
		
		for (Item items2 : itemsList) {
			totalBill += items2.getDiscountedPrice();
		}
		
		System.out.printf("\n%-20s%-20s", "	TOTAL",  "₱" + totalBill);
		System.out.println("\n====================================================");
		System.out.println();
	}
	
	public static void ListOfItems() {
		// LIST OF ITEMS
				RestTemplate itemsRestTemplate = new RestTemplate();
				final String itemsURLString = "http://localhost:9091/ecz/api/itemsList";
				ItemResponse itemResponse = itemsRestTemplate.getForObject(itemsURLString, ItemResponse.class);
				List<Item> itemsList = itemResponse.getItems();
				System.out
						.println("\n==================================================================================================");
				System.out.println("					ITEMS LIST");
				System.out.println("==================================================================================================");
				System.out.printf("%-20s%-20s%-20s%-20s%-20s", "NAME", "REGULAR PRICE", "DISCOUNTED", "% DISCOUNT" , "DISCOUNTED PRICE");
				System.out.println();
				for (Item items1 : itemsList) {
					System.out.printf("\n%-20s%-20s%-20s%-20s%-20s", items1.getItemName(), "₱" +  items1.getItemPrice(), items1.getisDiscounted(),
							items1.getDiscountPercentage() + "%", "₱" + items1.getDiscountedPrice());
				}
				System.out.println();
				System.out
						.println("\n==================================================================================================");
	}
}
