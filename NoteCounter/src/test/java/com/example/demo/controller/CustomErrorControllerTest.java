package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class CustomErrorControllerTest {
	
	private CustomErrorController customErrorController;
	private HttpServletRequest httpServletRequest;
	
	@BeforeEach
	 public void setUp() {
		customErrorController = new CustomErrorController();
		httpServletRequest = new MockHttpServletRequest();
	 }
	
	@Test
	public void testHttp404() {
		httpServletRequest.setAttribute(RequestDispatcher.ERROR_STATUS_CODE,404);
		String error = customErrorController.handleError(httpServletRequest);
		Assertions.assertEquals(error,"URL Not Found. Hence returning HTTP 404");
	}
	
	@Test
	public void testHttp400() {
		httpServletRequest.setAttribute(RequestDispatcher.ERROR_STATUS_CODE,400);
		String error = customErrorController.handleError(httpServletRequest);
		Assertions.assertEquals(error,"Something wrong with your Request Parameter. Hence returning HTTP 400");
	}
	
	@Test
	public void testHttp500() {
		httpServletRequest.setAttribute(RequestDispatcher.ERROR_STATUS_CODE,500);
		String error = customErrorController.handleError(httpServletRequest);
		Assertions.assertEquals(error,"Internal Server Error. Hence returning HTTP 500");
	}
	
	@Test
	public void testGenericError() {
		httpServletRequest.setAttribute(RequestDispatcher.ERROR_STATUS_CODE,503);
		String error = customErrorController.handleError(httpServletRequest);
		Assertions.assertEquals(error,"Error Thrown.");
	}
	
	
	@AfterEach
	 public void tearDown() {
		customErrorController = null;
		httpServletRequest = null;
	 }

}
