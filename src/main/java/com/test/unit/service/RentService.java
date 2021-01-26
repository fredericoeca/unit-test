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
		Double valueTotal = 0d;
		for(int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			Double valueMovie = movie.getPrice();
			switch (i) {
				case 2: valueMovie = valueMovie * 0.75; break;
				case 3: valueMovie = valueMovie * 0.5; break;
				case 4: valueMovie = valueMovie * 0.25; break;
				case 5: valueMovie = 0d; break;
			}
			valueTotal += valueMovie;
		}
		rent.setValue(valueTotal);
				
		// Delivery day
		Date dateDelivery = new Date();
		dateDelivery = add(dateDelivery, 1);
		if(DateUtils.checkDayOfTheWeek(dateDelivery, Calendar.SUNDAY)) {
			dateDelivery = add(dateDelivery, 1);
		}
		rent.setReturnDate(dateDelivery);
		
		// Save a Rent...	
		//TODO add method save a rent
		
		return rent;
	}
	
}
