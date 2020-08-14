package com.cts.mc.user.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cts.mc.user.exception.UserException;
import com.cts.mc.user.model.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class UserJsonRepository {
	static Logger log = Logger.getLogger(UserJsonRepository.class.getName());
	ObjectMapper mapper = new ObjectMapper();

	// read json ---get UserDetail
	public User readJson(User user) throws UserException {

		log.debug(" readJson method start");

		ArrayList<User> existingUser = null;
		InputStream input;
		try {
			input = new FileInputStream("D:\\313474\\OnlineOrderProcessing\\UserRegistration\\src\\main\\resources\\UserData.json");
			if (input.available() == 0) {
				log.debug(" Json file is empty----writing first object");
				writeJson(Arrays.asList(user));
			} else {
				log.debug("Json file is not empty updating the user");
				List<User> usersList = Arrays.asList(mapper.readValue(input, User[].class));

				existingUser = new ArrayList<>(usersList);
				updateJson(existingUser, user);
			}
		} catch (Exception e) {

			throw new UserException("Exception occured whlile storing the User data in UserData.json for the UserId : "+ user.getUserId());
		}
		;
		return user;
	}

	// write json ---insert User

	public void writeJson(List<User> user)
			throws JsonGenerationException, JsonMappingException, FileNotFoundException, IOException {
		log.debug("writing user to json file");
		mapper.writeValue(new FileOutputStream("D:\\313474\\OnlineOrderProcessing\\UserRegistration\\src\\main\\resources\\UserData.json"), user);
	}

	// write json ---update iser
	public void updateJson(ArrayList<User> existingUsers, User newUser) throws UserException {
		log.debug("UpdateJson method starts......");
		int initialSize = existingUsers.size();
		log.debug(" Existing Json objects count " + initialSize);

		boolean[] flag = { true };
		flag[0] = false;

		if (existingUsers.size() == 0) {
			existingUsers.add(newUser);
		} else {

			System.out.println(" update json method else block ");
			existingUsers.forEach(existingUser -> {
				if (existingUser.getUserId().equals(newUser.getUserId())) {
					log.debug(" User already exists so updating it ");
					existingUser.setFirstName(newUser.getFirstName());
					existingUser.setLastName(newUser.getLastName());
					existingUser.setDob(newUser.getDob());
					existingUser.setEmail(newUser.getEmail());
//					existingUser.getProducts().addAll(newUser.getProducts());
					flag[0] = true;
				}

			});

			if (flag[0] == false) {
				existingUsers.addAll(Arrays.asList(newUser));
			}
		}

		try {
			mapper.writeValue(new FileOutputStream("D:\\313474\\OnlineOrderProcessing\\UserRegistration\\src\\main\\resources\\UserData.json"),
					existingUsers);
		} catch (Exception e) {
			throw new UserException("Exception occured whlile storing the User data in UserData.json for the UserId : "+ newUser.getUserId());
		}
	}

}
