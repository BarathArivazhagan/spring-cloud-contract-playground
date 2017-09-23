package com.barath.cloud.app;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	private static final Logger logger=LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer customer){
		
		logger.info("Customer is getting created {}",customer.toString());
		return customer;
		
	}
	
	
	

}
