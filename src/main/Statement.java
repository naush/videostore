package main;

import java.util.ArrayList;
import java.util.List;

public class Statement
{

    private double totalAmount;
    private int frequentRenterPoints;
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Statement(String name) {
        this.name = name;
        totalAmount = 0;
        frequentRenterPoints = 0;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName () {
        return name;
    }

    public String make() {

        String result = getStatementHeader() +
                getStatementBody() +
                getStatementFooter();

        return result;
    }

    private String getStatementFooter() {
        String result = "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
        return result;
    }

    private String getStatementBody() {
        String result = "";

        for (Rental rental : rentals) {
            updateTotals(rental);
            result = result + rentalLine(rental);
        }

        return result;
    }

    private String getStatementHeader() {
        return "Rental Record for " + getName () + "\n";
    }

    private void updateTotals(Rental rental) {
        frequentRenterPoints = frequentRenterPoints + rental.determineFrequentRentalPoints();
        totalAmount = totalAmount + rental.determineRentalAmount();
    }

    private String rentalLine(Rental rental) {
        String result = "\t" + rental.getMovieTitle() + "\t"
                + String.valueOf(rental.determineRentalAmount()) + "\n";
        return result;
    }

}