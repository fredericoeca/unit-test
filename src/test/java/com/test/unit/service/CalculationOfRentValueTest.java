package com.test.unit.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.test.unit.entity.Movie;
import com.test.unit.entity.Rent;
import com.test.unit.entity.User;
import com.test.unit.exception.FilmWithoutStockException;
import com.test.unit.exception.VideoStoreException;

@RunWith(Parameterized.class)
public class CalculationOfRentValueTest {

	private RentService service;
	
	@Parameter
	public List<Movie> movies;
	
	@Parameter(value = 1)
	public Double rentValue;
	
	@Before
	public void initial() {
		service = new RentService();
	}
	
	private static Movie m1 = new Movie("Movie 1", 1, 4.0);
	private static Movie m2 = new Movie("Movie 2", 2, 4.0);
	private static Movie m3 = new Movie("Movie 3", 1, 4.0);
	private static Movie m4 = new Movie("Movie 4", 1, 4.0);
	private static Movie m5 = new Movie("Movie 5", 3, 4.0);
	private static Movie m6 = new Movie("Movie 6", 2, 4.0);
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		return Arrays.asList( new Object[][] {
			{ Arrays.asList(m1,m2,m3), 11.0	},
			{ Arrays.asList(m1,m2,m3,m4), 13.0 },
			{ Arrays.asList(m1,m2,m3,m4,m5), 14.0 },
			{ Arrays.asList(m1,m2,m3,m4,m5,m6), 14.0 }});
	}
	
	@Test
	public void shouldCalculationOfRentValueTest() throws FilmWithoutStockException, VideoStoreException {
		// scenario
		User user = new User("User One");
				
		// action
		Rent rent = service.rentMovie(user, movies);
		
		// verify
		assertThat(rent.getValue(), is(rentValue));		
	}

}
