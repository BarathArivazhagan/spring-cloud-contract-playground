package com.barath.cloud.app;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ContractProducerApplication.class,webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CustomerRestBase {
	
	@Autowired
	private MockMvc mockMvc;
	
	  @Before
	  public void setup() {	    
		RestAssuredMockMvc.mockMvc(mockMvc);
	  }
	

}
