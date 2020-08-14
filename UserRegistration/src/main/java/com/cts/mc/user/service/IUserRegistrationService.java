package com.cts.mc.user.service;

import com.cts.mc.user.exception.UserException;
import com.cts.mc.user.model.User;

public interface IUserRegistrationService {
	public User createUser(User user) throws UserException;
	public User updateUser(User user) throws UserException;

}
