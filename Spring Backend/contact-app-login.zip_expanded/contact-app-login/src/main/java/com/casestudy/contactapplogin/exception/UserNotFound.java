package com.casestudy.contactapplogin.exception;

public class UserNotFound extends Exception {
	public UserNotFound() {
		super("User Not Found");
	}
	
	public UserNotFound(String msg) {
		super(msg);
	}

}
