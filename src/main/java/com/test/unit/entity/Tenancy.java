package com.test.unit.entity;

import java.util.Date;

public class Tenancy {

	private User user;
	private Movie movie;
	private Date tenancyDate;
	private Date returnDate;
	private Double value;
	
	public Tenancy() {}

	public Tenancy(User user, Movie movie, Date tenancyDate, Date returnDate, Double value) {
		super();
		this.user = user;
		this.movie = movie;
		this.tenancyDate = tenancyDate;
		this.returnDate = returnDate;
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Date getTenancyDate() {
		return tenancyDate;
	}

	public void setTenancyDate(Date tenancyDate) {
		this.tenancyDate = tenancyDate;
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

}
