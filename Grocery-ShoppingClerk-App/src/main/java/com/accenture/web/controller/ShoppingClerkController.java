package com.accenture.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.web.domain.ShoppingClerk;
import com.accenture.web.domain.ShoppingClerkResponse;
import com.accenture.web.repository.ShoppingClerkRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ShoppingClerkController {

	@Autowired
	ShoppingClerkRepository shoppingClerkRepository;
	
	//DISPLAY ALL CLERK
	@GetMapping("/clerksList")
	public ShoppingClerkResponse getAllClerkResponse() {
		List<ShoppingClerk> clerksList = shoppingClerkRepository.findAll();
		ShoppingClerkResponse shoppingClerkResponse = new ShoppingClerkResponse();
		shoppingClerkResponse.setClerks(clerksList);
		return shoppingClerkResponse;
	}
	
	@GetMapping("/clerk")
	public List<ShoppingClerk> getAllClerks() {
		return shoppingClerkRepository.findAll();
	}
	
//	@GetMapping("/clerk/validate/{clerkName}/{clerkPassword}")
//	public ResponseEntity<Map<String, Boolean>> clerkLogin(@PathVariable String clerkName,
//			@PathVariable String clerkPassword) {
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		final String fetchClerk = "http://localhost:8081/ecz/api/clerk";
//		ShoppingClerk shoppingClerk = restTemplate.getForObject(fetchClerk, ShoppingClerk.class);
//		boolean validated = false;
//		for (ShoppingClerk clerk : shoppingClerk.getClerkList()) {
//
//			if (clerkName.equals(clerk.getClerkName()) && clerkPassword.equals(clerk.getClerkPassword())) {
//				validated = true;
//
//				if (validated) {
//
//					Map<String, Boolean> responseMap = new HashMap<>();
//					responseMap.put("isValidated", Boolean.TRUE);
//					return ResponseEntity.ok(responseMap);
//				}
//			}
//		}
//		Map<String, Boolean> responseMap = new HashMap<>();
//		responseMap.put("isValidated", Boolean.FALSE);
//		return ResponseEntity.ok(responseMap);
//	}
	
	//CREATE NEW CLERK
	@PostMapping("/newClerk")
	public ShoppingClerk createClerk(@RequestBody ShoppingClerk clerkFromBrowser) {
		ShoppingClerk savedClerk = shoppingClerkRepository.save(clerkFromBrowser);
		return savedClerk;
	}
	
	//UPDATE A CLERK
	@PutMapping("/updateClerk/{clerkName}")
	public ShoppingClerk updatedClerk(@PathVariable(value = "clerkName") String clerkName, @RequestBody ShoppingClerk clerkFromBrowser) {
		ShoppingClerk existingClerk = shoppingClerkRepository.findById(clerkName).get();
		existingClerk.setClerkName(clerkFromBrowser.getClerkName());
		existingClerk.setClerkPassword(clerkFromBrowser.getClerkPassword());
		ShoppingClerk updatedClerk = shoppingClerkRepository.save(existingClerk);
		return updatedClerk;
	}
	

}
