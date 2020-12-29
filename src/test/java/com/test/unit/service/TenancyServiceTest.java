package com.test.unit.service;

import static com.test.unit.util.DateUtils.getDateWithDifferenceOfTheDays;
import static com.test.unit.util.DateUtils.isDateEquals;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;

import com.test.unit.entity.Movie;
import com.test.unit.entity.Tenancy;
import com.test.unit.entity.User;

public class TenancyServiceTest {

	@Test
	public void teste() {
		
		// scenario
		TenancyService service = new TenancyService();
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 2, 5.0);		
		
		// action
		Tenancy tenancy = service.rentMovie(user, movie);
		
		// checks
		assertThat(tenancy.getValue().equals(5.0));
		assertThat(isDateEquals(tenancy.getTenancyDate(), new Date()));
		assertThat(isDateEquals(tenancy.getReturnDate(), getDateWithDifferenceOfTheDays(1)));
	}
	
}
