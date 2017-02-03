package main;

public class Rental
{
    Movie movie;
    private int daysRented;

    public Rental (Movie movie, int daysRented) {
        this.movie 		= movie;
        this.daysRented = daysRented;
    }

    public int determineFrequentRentalPoints() {
        return movie.determineFrequentRentalPoints(daysRented);
    }

    public double determineRentalAmount() {
        return movie.determineRentalAmount(daysRented);
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }
}