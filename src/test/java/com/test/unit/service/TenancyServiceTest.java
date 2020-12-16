package com.test.unit.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.test.unit.entity.Movie;
import com.test.unit.entity.Tenancy;
import com.test.unit.entity.User;
import com.test.unit.util.DateUtils;

public class TenancyServiceTest {

	@Test
	public void teste() {
		
		// cenário
		TenancyService service = new TenancyService();
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 2, 5.0);		
		
		// ação
		Tenancy tenancy = service.rentMovie(user, movie);
		
		// verificação
		Assert.assertTrue(tenancy.getValue() == 5.0);
		Assert.assertTrue(DateUtils.isDateEquals(tenancy.getTenancyDate(), new Date()));
		Assert.assertTrue(DateUtils.isDateEquals(tenancy.getReturnDate(), DateUtils.getDateWithDifferenceOfTheDays(1)));
	}
	
}
