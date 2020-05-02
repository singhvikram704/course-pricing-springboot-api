package com.assignment.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.assignment.api.ApiAbstractTest;
import com.assignment.api.model.CoursePaymentDetail;
import com.assignment.api.model.ResponseObject;


public class CoursePaymentDetailControllerTest extends ApiAbstractTest {

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void checkCoursePriceSuccess() throws Exception {
		String uri = "/api/course/price/2/IND";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).contextPath("/api")
			    .accept(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
		String content = mvcResult.getResponse().getContentAsString();
		ResponseObject<CoursePaymentDetail> responseObject = super.mapFromJson(content, ResponseObject.class);
	    assertEquals("success", responseObject.getMessage());
	}
	
	@Test
	@SuppressWarnings("unchecked")	
	public void checkCoursePriceFailure() throws Exception {
		String uri = "/api/course/price/9/IND";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).contextPath("/api")
			    .accept(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
		String content = mvcResult.getResponse().getContentAsString();
	    ResponseObject<CoursePaymentDetail> responseObject = super.mapFromJson(content, ResponseObject.class);
	    assertNotEquals("success", responseObject.getMessage());
	}

}
