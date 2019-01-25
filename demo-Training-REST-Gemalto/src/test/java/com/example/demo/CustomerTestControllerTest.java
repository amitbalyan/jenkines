package com.example.demo;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.curd.controller.CustomerRestController;
import com.curd.controller.HelloController;
import com.curd.model.Customer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(CustomerRestController.class)
@WebAppConfiguration
public class CustomerTestControllerTest {

	

	   @Autowired
	    private MockMvc mvc;
	
	   @Autowired
	   WebApplicationContext webApplicationContext;

	   protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	   protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   protected <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
	
	
	@Test
	public void getCustomerList() throws Exception {
	   String uri = "/customers";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Customer[] customerlist = mapFromJson(content,Customer[].class);
	   assertTrue(customerlist.length > 0);
	}
	
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/*
	 * 
	 * @Test
public void createProduct() throws Exception {
   String uri = "/products";
   Product product = new Product();
   product.setId("3");
   product.setName("Ginger");
   
   String inputJson = super.mapToJson(product);
   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
   
   int status = mvcResult.getResponse().getStatus();
   assertEquals(201, status);
   String content = mvcResult.getResponse().getContentAsString();
   assertEquals(content, "Product is created successfully");
}
	 */
	
	
	
}
