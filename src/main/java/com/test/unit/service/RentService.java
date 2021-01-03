package com.test.unit.service;

import static com.test.unit.util.DateUtils.add;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.test.unit.entity.Movie;
import com.test.unit.entity.Rent;
import com.test.unit.entity.User;
import com.test.unit.exception.FilmWithoutStockException;
import com.test.unit.exception.VideoStoreException;
import com.test.unit.util.DateUtils;

public class RentService {

	public Rent rentMovie(User user, List<Movie> movies) throws FilmWithoutStockException, VideoStoreException {
		
		if(user == null) {
			throw new VideoStoreException("Empty user");
		}
		
		if(movies == null || movies.isEmpty()) {
			throw new VideoStoreException("Empty movie");
		}
		
		for(Movie movie: movies) {
			if(movie.getStock() == 0) {
				throw new FilmWithoutStockException();
			}
		}
		
		Rent rent = new Rent();
		rent.setMovie(movies);
		rent.setUser(user);
		rent.setRentDate(new Date());
		rent.setValue(rent.totalPrice(movies));
		
		Date deliveryDate = new Date();
		deliveryDate = add(deliveryDate, 1);
		if(DateUtils.checkDayOfTheWeek(deliveryDate, Calendar.SUNDAY)) {
			deliveryDate = add(deliveryDate, 1);
		}
		rent.setReturnDate(deliveryDate);
		
		return rent;
	}
	
}
