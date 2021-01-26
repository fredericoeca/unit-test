package com.test.unit.service;

import static com.test.unit.matchers.OwnMatchers.isMonday;
import static com.test.unit.util.DateUtils.getDateWithDifferenceOfTheDays;
import static com.test.unit.util.DateUtils.isDateEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.test.unit.builder.UserBuilder;
import com.test.unit.entity.Movie;
import com.test.unit.entity.Rent;
import com.test.unit.entity.User;
import com.test.unit.exception.FilmWithoutStockException;
import com.test.unit.exception.VideoStoreException;
import com.test.unit.matchers.OwnMatchers;
import com.test.unit.util.DateUtils;

public class RentServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	RentService service;
	
	@Before
	public void before() {
		service = new RentService();
	}
			
	@Test
	public void shouldRentMovieSuccess() throws Exception {
				
		Assume.assumeFalse(DateUtils.checkDayOfTheWeek(Calendar.getInstance().getTime(), Calendar.SATURDAY));
		
		// scenario
		User user = UserBuilder.oneUser().now();
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Movie 1", 1, 5.0));
		movies.add(new Movie("Movie 2", 2, 6.0));
		
		// action
		Rent rent = service.rentMovie(user, movies);
		
		// checks
		error.checkThat(rent.getValue(), is(equalTo(11.0)));
		error.checkThat(isDateEquals(rent.getRentDate(), new Date()), is(true));
		error.checkThat(isDateEquals(rent.getReturnDate(), getDateWithDifferenceOfTheDays(1)), is(true));
		error.checkThat(rent.getReturnDate(), OwnMatchers.getDateWithDifferenceOfTheDays(1));
	}
	
	@Test(expected = FilmWithoutStockException.class)
	public void shouldNotRentMovieWithoutStock_1() throws Exception {
				
		// scenario
		User user = UserBuilder.oneUser().now();
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Movie 1", 0, 5.0));
		movies.add(new Movie("Movie 2", 2, 6.0));
		
		// action
		service.rentMovie(user, movies);			
	}
	
	@Test
	public void shouldNotRentMovieWithoutStock_2() {
				
		// scenario
		User user = UserBuilder.oneUser().now();
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Movie 1", 1, 5.0));
		movies.add(new Movie("Movie 2", 0, 4.0));		
	
		assertThrows(FilmWithoutStockException.class, () -> {
			service.rentMovie(user, movies);		
		});				
	}
	
	@Test
	public void shouldNotRentMovieWithoutUser() throws FilmWithoutStockException {
				
		// scenario
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Movie 1", 1, 5.0));
		movies.add(new Movie("Movie 2", 1, 5.0));
	
		try {
			service.rentMovie(null, movies);
			Assert.fail();
		} catch (VideoStoreException e) {
			assertThat(e.getMessage(), is("Empty user"));
		}		
		
	}

	@Test
	public void shouldPay75percentInTheThirdMovie() throws FilmWithoutStockException, VideoStoreException {
		// scenario
		User user = UserBuilder.oneUser().now();
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Movie 1", 1, 4.0));
		movies.add(new Movie("Movie 2", 2, 4.0));
		movies.add(new Movie("Movie 3", 1, 4.0)); // value: 4 (75%) = 3
		
		// action
		Rent rent = service.rentMovie(user, movies);
		
		// verify
		assertThat(rent.getValue(), is(11.0));		
	}
	
	@Test
	public void shouldPay50percentInTheFourthMovie() throws FilmWithoutStockException, VideoStoreException {
		// scenario
		User user = UserBuilder.oneUser().now();
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Movie 1", 1, 4.0));
		movies.add(new Movie("Movie 2", 2, 4.0));
		movies.add(new Movie("Movie 3", 1, 4.0)); // value: 4 (75%) = 3
		movies.add(new Movie("Movie 4", 1, 4.0)); // value: 4 (50%) = 2
		
		// action
		Rent rent = service.rentMovie(user, movies);
		
		// verify
		assertThat(rent.getValue(), is(13.0));		
	}
	
	@Test
	public void shouldPay25percentInTheFifthMovie() throws FilmWithoutStockException, VideoStoreException {
		// scenario
		User user = UserBuilder.oneUser().now();
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Movie 1", 1, 4.0));
		movies.add(new Movie("Movie 2", 2, 4.0));
		movies.add(new Movie("Movie 3", 1, 4.0)); // value: 4 (75%) = 3
		movies.add(new Movie("Movie 4", 1, 4.0)); // value: 4 (50%) = 2
		movies.add(new Movie("Movie 5", 3, 4.0)); // value: 4 (25%) = 1
		
		// action
		Rent rent = service.rentMovie(user, movies);
		
		// verify
		assertThat(rent.getValue(), is(14.0));		
	}
	
	@Test
	public void shouldNotPayTheSixthMovie() throws FilmWithoutStockException, VideoStoreException {
		// scenario
		User user = UserBuilder.oneUser().now();
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Movie 1", 1, 4.0));
		movies.add(new Movie("Movie 2", 2, 4.0));
		movies.add(new Movie("Movie 3", 1, 4.0)); // value: 4 (75%) = 3
		movies.add(new Movie("Movie 4", 1, 4.0)); // value: 4 (50%) = 2
		movies.add(new Movie("Movie 5", 3, 4.0)); // value: 4 (25%) = 1
		movies.add(new Movie("Movie 6", 1, 4.0)); // value: 4 (0) = 0
		
		// action
		Rent rent = service.rentMovie(user, movies);
		
		// verify
		assertThat(rent.getValue(), is(14.0));		
	}

	@Test
	public void souldNotReturnMovieOnSunday() throws FilmWithoutStockException, VideoStoreException {
		
		Assume.assumeTrue(DateUtils.checkDayOfTheWeek(Calendar.getInstance().getTime(), Calendar.SATURDAY));
		
		// scenario
		User user = UserBuilder.oneUser().now();
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Movie 1", 1, 5.0));
		movies.add(new Movie("Movie 2", 2, 6.0));
		
		// action
		Rent rent = service.rentMovie(user, movies);
		
		// verify
		//assertThat(rent.getReturnDate(), isDay(Calendar.SUNDAY));
		assertThat(rent.getReturnDate(), isMonday());
	}

}
