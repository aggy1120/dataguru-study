package com.zy.ebusiness.chapter1.restful.controller;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ActiveProfiles("local")
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration(locations = { "classpath:applicationContext.xml","classpath:spring-mvc.xml" })  
@RunWith(SpringJUnit4ClassRunner.class)  
public class TestRestFulController {
	
	private Logger logger = LoggerFactory.getLogger(TestRestFulController.class);
	
	@Autowired  
    private WebApplicationContext wac;  
    private MockMvc mockMvc;
    
    @Before  
    public void setUp() {  
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
    }  
    
    @Test
    public void testPOST() throws Exception{
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/restful/person/post")
				.param("name", "zhangyi")
				.param("address", "3")
				.param("phoneNumber", "1100096"))
				.andReturn();  
    	checkStatus(result);
    }
    
    @Test
    public void testGet() throws Exception{
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/restful/person/zhangyi"))
				.andReturn();  
    	checkStatus(result);
    }
    
    @Test
    public void testPUT() throws Exception{
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/restful/person/zhangyi")
    			.param("name", "zhangyi")
				.param("address", "3")
				.param("phoneNumber", "1100096"))
				.andReturn();  
    	checkStatus(result);
    }
    
    @Test
    public void testDelete() throws Exception{
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/restful/person/zhangyi"))
				.andReturn();  
    	checkStatus(result);
    }
    
    /**
	 * 检查状态是否为200 接口调用是否返回正常的status(1)
	 * @param result
	 * @throws UnsupportedEncodingException 
	 */
	public void checkStatus(MvcResult result) throws UnsupportedEncodingException{
		String response = result.getResponse().getContentAsString();
		logger.info(response);	    
		Assert.assertNotNull(response);
	    Assert.assertEquals(200, result.getResponse().getStatus());
	}
	
}
