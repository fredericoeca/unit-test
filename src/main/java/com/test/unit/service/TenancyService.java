package com.test.unit.service;

import static com.test.unit.util.DateUtils.add;

import java.util.Date;

import com.test.unit.entity.Movie;
import com.test.unit.entity.Tenancy;
import com.test.unit.entity.User;
import com.test.unit.exception.FilmWithoutStockException;

public class TenancyService {

	public Tenancy rentMovie(User user, Movie movie) throws Exception {
		
		if(movie.getStock() == 0) {
			throw new FilmWithoutStockException();
		}
		
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
	
}
