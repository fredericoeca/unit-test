package com.test.unit.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rent {

	private User user;
	private List<Movie> movie = new ArrayList<>();
	private Date rentDate;
	private Date returnDate;
	private Double value;
	
	public Rent() {}

	public Rent(User user, Date rentDate, Date returnDate, Double value) {
		super();
		this.user = user;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	/*public Double totalPrice(List<Movie> movies) {	
		if(movies.size() >= 3) { movies.get(2).setPrice(movies.get(2).getPrice() * 0.75); } 
		if(movies.size() >= 4) { movies.get(3).setPrice(movies.get(3).getPrice() * 0.5); }
		if(movies.size() >= 5) { movies.get(4).setPrice(movies.get(4).getPrice() * 0.25); }
		if(movies.size() >= 6) { movies.get(5).setPrice(movies.get(5).getPrice() * 0); }
		return movies.stream().mapToDouble( m -> m.getPrice()).sum();
	}*/
}
