package com.cts.mc.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mc.email.exception.EmailException;
import com.cts.mc.email.model.EmailMessage;
import com.cts.mc.email.service.EmailService; 

@RestController
@RequestMapping("/email")
public class EmailController {
@Autowired
EmailService emailService;
	
	@RequestMapping("/send")
	public String sendEmail(@RequestBody EmailMessage emailMessage) throws EmailException {
		return emailService.sendEmail(emailMessage);
	}
	
	
	

}
