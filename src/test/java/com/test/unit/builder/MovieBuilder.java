package com.test.unit.builder;

import com.test.unit.entity.Movie;

public class MovieBuilder {

	private Movie movie;
	
	private MovieBuilder() {}

	public static MovieBuilder oneMovie() {
		MovieBuilder builder = new MovieBuilder();
		builder.movie = new Movie();
		builder.movie.setStock(2);
		builder.movie.setName("Movie 1");
		builder.movie.setPrice(5.0);
		return builder;
	}
	
	public MovieBuilder withoutStock() {
		movie.setStock(0);
		return this;
	}
	
	public Movie now() {
		return movie;
	}
}
