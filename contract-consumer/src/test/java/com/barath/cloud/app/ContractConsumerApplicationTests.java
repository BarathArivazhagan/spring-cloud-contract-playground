package com.barath.cloud.app;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@AutoConfigureStubRunner(workOffline=true,ids="com.barath.cloud.contract.samples:contract-producer:+:stubs:9000")
public class ContractConsumerApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	private TestRestTemplate restTemplate=new TestRestTemplate();
	
	private final ObjectMapper mapper=new ObjectMapper();
	

	@Test
	public void test_save_customer() {
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> request=new HttpEntity<Object>(new Customer(25L, "barath"), headers);
		ResponseEntity<String> responseEntity=this.restTemplate.postForEntity(URI.create("http://localhost:9000/create"), request, String.class);
		System.out.println("Response Obtained from the mOCk "+responseEntity);
	}
	
	
	
	protected static class Customer{
		
		
		private Long customerId;
		
		private String customerName;

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public Customer(Long customerId, String customerName) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
		}

		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
	}
	

}
