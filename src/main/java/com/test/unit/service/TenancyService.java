package com.test.unit.service;

import static com.test.unit.util.DateUtils.add;

import java.util.Date;

import com.test.unit.entity.Movie;
import com.test.unit.entity.Tenancy;
import com.test.unit.entity.User;
import com.test.unit.util.DateUtils;

public class TenancyService {

	public Tenancy rentMovie(User user, Movie movie) {
		Tenancy tenancy = new Tenancy();
		tenancy.setMovie(movie);
		tenancy.setUser(user);
		tenancy.setTenancyDate(new Date());
		tenancy.setValue(movie.getPrice());
		
		Date deliveryDate = new Date();
		deliveryDate = add(deliveryDate, 1);
		tenancy.setReturnDate(deliveryDate);
		
		return tenancy;
	}
	
	public static void main(String[] args) {
		// cenário
		TenancyService service = new TenancyService();
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 2, 5.0);		
		
		// ação
		Tenancy tenancy = service.rentMovie(user, movie);
		
		// verificação
		System.out.println(tenancy.getValue() == 5.0);
		System.out.println(DateUtils.isDateEquals(tenancy.getTenancyDate(), new Date()));
		System.out.println(DateUtils.isDateEquals(tenancy.getReturnDate(), DateUtils.getDateWithDifferenceOfTheDays(1)));
	}
	
}
