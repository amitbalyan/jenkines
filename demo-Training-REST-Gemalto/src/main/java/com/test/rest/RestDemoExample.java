package com.test.rest;


import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.bean.Customer;

@RestController
public class RestDemoExample {
	
	@GetMapping("/customers")
	public String getCustomers() {
		return "My Hello Rest";
	}

	
	@RequestMapping(produces = MediaType.APPLICATION_XML, 
		    method = RequestMethod.GET,
		    value = "/details")
	 @ResponseBody
			public Customer details(){
				
				Customer c1=new Customer();
				c1.setId(21);
				c1.setName("Amit");
				c1.setAddress("Noida");
				
				return c1;
				
			}
	
}
