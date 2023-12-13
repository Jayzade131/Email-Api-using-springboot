package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.EmailRequest;
import com.main.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "hello.. welcome here..!";
	}
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> requestemail(@RequestBody EmailRequest emailRequest)
	{
		
		System.out.println(emailRequest);
	boolean result=	this.emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage());
		
		if(result)
		{
			return ResponseEntity.ok("sending email successfully...");
			
		}
		else {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email is not send yet...");
		}
		
		
	}

}
