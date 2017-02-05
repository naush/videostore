package main.rental;

public interface RentalStrategy {
    double calculateRentalAmount(int daysRented);
    int calculateFrequentRenterPoints(int daysRented);
}
