package com.test.unit.service;

import static com.test.unit.util.DateUtils.getDateWithDifferenceOfTheDays;
import static com.test.unit.util.DateUtils.isDateEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.test.unit.entity.Movie;
import com.test.unit.entity.Tenancy;
import com.test.unit.entity.User;

public class TenancyServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void testeTenancy() {
				
		// scenario
		TenancyService service = new TenancyService();
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 2, 5.0);		
		
		// action
		Tenancy tenancy = service.rentMovie(user, movie);
		
		// checks
		error.checkThat(tenancy.getValue(), is(equalTo(6.0)));
		error.checkThat(isDateEquals(tenancy.getTenancyDate(), new Date()), is(true));
		error.checkThat(isDateEquals(tenancy.getReturnDate(), getDateWithDifferenceOfTheDays(1)), is(false));
	}
}
