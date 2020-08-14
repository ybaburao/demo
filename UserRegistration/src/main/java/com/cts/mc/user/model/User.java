package com.cts.mc.user.model;

import java.util.List;

public class User {
	private String userId;
private String firstName;
private String lastName;
private String dob;


public User() {
}
public User(String userId ,String firstName, String lastName, String dob, String email) {
	super();
	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.email = email;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
private String email;
}
