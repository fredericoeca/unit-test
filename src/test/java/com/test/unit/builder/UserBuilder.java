package com.test.unit.builder;

import com.test.unit.entity.User;

public class UserBuilder {

	private User user;
	
	private UserBuilder() {}
	
	public static UserBuilder oneUser() {
		UserBuilder builder = new UserBuilder();
		builder.user = new User();
		builder.user.setName("User 1");
		return builder;
	}
	
	public User now() {
		return user;
	}
}
