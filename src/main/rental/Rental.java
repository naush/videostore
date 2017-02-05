package main.rental;

import main.data.Movie;

public class Rental
{
	private Movie movie;
	private int daysRented;
	private RentalStrategy strategy;

	public Rental (Movie movie, int daysRented, RentalStrategy strategy) {
		this.movie 		= movie;
		this.daysRented = daysRented;
		this.strategy = strategy;
	}

	public String getMovieTitle () {
		return movie.getTitle();
	}

	public double getRentalAmount() {
		return strategy.calculateRentalAmount(daysRented);
	}

	public int getFrequentRenterPoints() {
		return strategy.calculateFrequentRenterPoints(daysRented);
	}
}