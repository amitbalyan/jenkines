package com.curd.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.bean.Customer;





@RestController
public class HelloController{

	@GetMapping("/hello-world")
	public String helloWorld() {
		
		
		return "Hello World";
	}
	

			
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/details")
		@ResponseBody
	 public Customer details(){
		
		Customer c1=new Customer();
		c1.setId (101);
		c1.setName("amit");
		c1.setAddress("delhi");
			
		
		return c1;
		   
	}

}


