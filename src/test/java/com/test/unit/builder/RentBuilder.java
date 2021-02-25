package com.test.unit.builder;

import java.util.Arrays;
import java.util.Calendar;

import com.test.unit.entity.Rent;
import com.test.unit.entity.User;
import com.test.unit.util.DateUtils;

public class RentBuilder {
	
	private Rent rent;
	
	private RentBuilder() {	}
	
	public static RentBuilder oneRent() {
		RentBuilder builder = new RentBuilder();
		builder.rent = new Rent();
		builder.rent.setMovie(Arrays.asList(MovieBuilder.oneMovie().now()));
		builder.rent.setRentDate(Calendar.getInstance().getTime());
		builder.rent.setReturnDate(DateUtils.getDateWithDifferenceOfTheDays(1));
		builder.rent.setUser(UserBuilder.oneUser().now());
		builder.rent.setValue(4.0);
		return builder;
	}
	
	public RentBuilder dueDate() {
		rent.setRentDate(DateUtils.getDateWithDifferenceOfTheDays(-5));
		rent.setReturnDate(DateUtils.getDateWithDifferenceOfTheDays(-4));
		return this;
	}
	
	public RentBuilder withUser(User user) {
		rent.setUser(user);
		return this;
	}
	
	public Rent now() {
		return rent;
	}
	
}
