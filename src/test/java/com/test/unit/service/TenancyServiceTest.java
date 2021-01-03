package com.test.unit.service;

import static com.test.unit.util.DateUtils.getDateWithDifferenceOfTheDays;
import static com.test.unit.util.DateUtils.isDateEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.test.unit.entity.Movie;
import com.test.unit.entity.Tenancy;
import com.test.unit.entity.User;
import com.test.unit.exception.FilmWithoutStockException;
import com.test.unit.exception.VideoStoreException;

public class TenancyServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	TenancyService service;
	
	@Before
	public void before() {
		service = new TenancyService();
	}
	
	@After
	public void After() {
		System.out.println("after");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("after class");
	}
		
	@Test
	public void testTenancy() throws Exception {
				
		// scenario
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 2, 5.0);		
		
		// action
		Tenancy tenancy = service.rentMovie(user, movie);
		
		// checks
		error.checkThat(tenancy.getValue(), is(equalTo(5.0)));
		error.checkThat(isDateEquals(tenancy.getTenancyDate(), new Date()), is(true));
		error.checkThat(isDateEquals(tenancy.getReturnDate(), getDateWithDifferenceOfTheDays(1)), is(true));	
	}
	
	@Test(expected = FilmWithoutStockException.class)
	public void testTenancy_filmWithoutStock() throws Exception {
				
		// scenario
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 0, 5.0);		
		
		// action
		service.rentMovie(user, movie);			
	}
	
	@Test
	public void testTenancy_filmWithoutStock_2() {
				
		// scenario
		User user = new User("User One");
		Movie movie = new Movie("Movie 1", 0, 5.0);		
	
		assertThrows(Exception.class, () -> {
			service.rentMovie(user, movie);		
		});				
	}
	
	@Test
	public void testTenancy_emptyUser() throws FilmWithoutStockException {
				
		// scenario
		Movie movie = new Movie("Movie 1", 2, 5.0);		
	
		try {
			service.rentMovie(null, movie);
			Assert.fail();
		} catch (VideoStoreException e) {
			assertThat(e.getMessage(), is("Empty user"));
		}		
		
	}

}
