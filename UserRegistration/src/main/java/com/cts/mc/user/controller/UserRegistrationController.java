package com.cts.mc.user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.mc.user.exception.UserException;
import com.cts.mc.user.model.User;
import com.cts.mc.user.service.UserRegistrationService;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	UserRegistrationService userRegistrationService;

	static Logger log = Logger.getLogger(UserRegistrationController.class.getName());
	

	@PutMapping("/createUser")
	public User createUser(@RequestBody User user) throws UserException {

		log.debug("Adding user to Json repository for userId "+user.getUserId());
		 return userRegistrationService.createUser(user);
		
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) throws UserException {
		log.debug("Updating existing user"+ user.getUserId());
		return userRegistrationService.updateUser(user);
		
	}

}
