package com.test.unit.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static com.test.unit.util.DateUtils.*;

import java.util.Date;

import org.junit.Test;

import com.test.unit.entity.Movie;
import com.test.unit.entity.Tenancy;
import com.test.unit.entity.User;

public class TenancyServiceTest {

	@Test
	public void testValue() {
		
		// scenario
		TenancyService service = new TenancyService();
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 2, 5.0);		
		
		// action
		Tenancy tenancy = service.rentMovie(user, movie);
		
		// checks
		assertEquals(6.0, tenancy.getValue(), 0.01);
	}
	
	@Test
	public void testTenancyDate() {
		
		// scenario
		TenancyService service = new TenancyService();
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 2, 5.0);		
		
		// action
		Tenancy tenancy = service.rentMovie(user, movie);
		
		// checks
		assertTrue(isDateEquals(tenancy.getTenancyDate(), new Date()));
	}
	
	@Test
	public void testReturnDate() {
		
		// scenario
		TenancyService service = new TenancyService();
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 2, 5.0);		
		
		// action
		Tenancy tenancy = service.rentMovie(user, movie);
		
		// checks
		assertTrue(isDateEquals(tenancy.getReturnDate(), getDateWithDifferenceOfTheDays(2)));
	}
	
}
