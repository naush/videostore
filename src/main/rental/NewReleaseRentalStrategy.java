package main.rental;

public class NewReleaseRentalStrategy implements RentalStrategy {
    @Override
    public double calculateRentalAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}