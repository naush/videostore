package main;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    double determineRentalAmount(int daysRented) {
        return (double) (daysRented * 3);
    }

    @Override
    int determineFrequentRentalPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        else
            return 1;
    }
}