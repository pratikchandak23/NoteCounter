package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pratik.chandak
 * Customer Error Controller for different error scenarios
 *
 */
@RestController
public class CustomErrorController implements ErrorController{
	@RequestMapping("/error")
	public String handleError(HttpServletRequest httpServletRequest) {
		
		Object status = httpServletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status !=null ) {
			Integer statusCode = Integer.valueOf(status.toString());
			
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return "URL Not Found. Hence returning HTTP 404";
			}else if(statusCode == HttpStatus.BAD_REQUEST.value()) {
				return "Something wrong with your Request Parameter. Hence returning HTTP 400";
			}else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "Internal Server Error. Hence returning HTTP 500";
			}
		}
		
		return "Error Thrown.";
		
	}
}
