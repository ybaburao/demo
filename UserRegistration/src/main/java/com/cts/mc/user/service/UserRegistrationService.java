package com.cts.mc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mc.user.dao.UserJsonRepository;
import com.cts.mc.user.exception.UserException;
import com.cts.mc.user.model.User;

@Service
public class UserRegistrationService implements IUserRegistrationService {
	@Autowired
	UserJsonRepository jsonRepository;
	@Override
	public User createUser(User user) throws UserException {
		jsonRepository.readJson(user);
		return user;
	}

	@Override
	public User updateUser(User user) throws UserException {
		jsonRepository.readJson(user);
		return user;
	}

}
