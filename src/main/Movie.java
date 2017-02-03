package main;

public abstract class Movie
{
	private String title;

	public Movie (String title) {
		this.title 		= title;
	}

	public String getTitle () {
		return title;
	}

    abstract double determineRentalAmount(int daysRented);

    int determineFrequentRentalPoints(int daysRented) {
        return 1;
    }
}